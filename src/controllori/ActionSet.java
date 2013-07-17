/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllori;


import eccezioni.ActionNotFoundException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author panda
 */
public class ActionSet {
    private static final String ACTIONSCLASSPATH = "controllori/actions/";
    private static ActionSet instance;

    private HashMap<String,Action> _actions;

    public static ActionSet getInstance() {
        if ( instance==null) {
           instance = new ActionSet();
        }
        return instance;
     }

    private ActionSet() {
        URL urlActions = getActionsUrl();
       // System.out.println("urlActions: "+urlActions.toString());
        String[] classNames = isJarArchive(urlActions)
                            ? getClassNamesFromJar(urlActions)
                            : getClassNamesFromDir(urlActions);
        this._actions = initActionSet(classNames);
    }

    public Action getAction(String actionStringId) throws ActionNotFoundException{
    	Action action = _actions.get(actionStringId);
    	if (action==null) throw new ActionNotFoundException("Action id "+actionStringId+" not found.");
    	return action;
    }

    /**
     * Inizializza l'hashmap delle azioni con tutte le classi contenute nell'array di stringhe passato per parametro
     * che implementano l'interfaccia Action e che si trovano nel classpath specificato dalla
     * costante ACTIONSCLASSPATH.
     * @param classNames di tipo String[] - Array di nomi di classi che si tenterà di
     * 		caricare nell'ActionSet
     * @return di tipo HashMap<String,Action> - HashMap delle Action correttamente caricate nell'ActionSet
     */
    private static HashMap<String,Action> initActionSet(String[] classNames) {
        HashMap<String,Action> azioni = new HashMap<String,Action>();
        Class currentActionClass;
        Action currentAction;

        for (int i = 0; i < classNames.length; i++)
        {
            try
            {
                currentActionClass = Class.forName(ACTIONSCLASSPATH.replace('/','.') + classNames[i].substring(0, classNames[i].length()-6));
                if (Action.class.isAssignableFrom(currentActionClass))
                {
                    try
                    {
                        currentAction = (Action)currentActionClass.newInstance();
                        azioni.put(currentAction.getActionStringId(), currentAction);
                    }
                    catch (InstantiationException ex) {}
                    catch (IllegalAccessException ex) {}
                }
            } catch (ClassNotFoundException ex) {}
        }

        return azioni;
    }

    /**
     * Trova tutti i file .class presenti nella directory specificata dall'url
     * passato per parametro
     * @param urlActions di tipo URL - url che contiene il percorso utilizzato
     * 		per cercare i file .class
     * 		REQUIRES: l'url non deve specificare un percorso interno a un file jar
     * @return di tipo String[] - Array di nomi di file .class che sono stati trovati
     * 		all'interno della directory specificata dal parametro url
     */
    private static String[] getClassNamesFromDir(URL urlActions) {
        String dirFilePath = getDirFilePath(urlActions);
        //System.out.println("dirFilePath = " + dirFilePath);
        FiltroFileEndsWith filtroClass = new FiltroFileEndsWith(".class");
        File dirFileInstructions = new File(dirFilePath);
        return dirFileInstructions.list(filtroClass);
    }

    /**
     * Trova tutti i file .class presenti nel classpath interno all'archivio jar
     * specificato dall'url passato per parametro
     * @param urlActions di tipo URL - url che contiene il percorso utilizzato
     * 		per cercare i file .class
     * 		REQUIRES: l'url deve specificare un percorso interno a un file jar
     * @return di tipo String[] - Array di nomi di file .class che sono stati trovati
     * 		all'interno del classpath relativo al file jar specificato dal parametro url
     */
    private static String[] getClassNamesFromJar(URL urlActions) { 
        JarFile jarFile;
        Enumeration<JarEntry> entries;
        try {
            JarURLConnection conn = (JarURLConnection)urlActions.openConnection();
            jarFile = conn.getJarFile();
            entries = jarFile.entries();
        } catch (IOException ex) {
            Logger.getLogger(ActionSet.class.getName()).log(Level.SEVERE, null, ex);
            return new String[0];
        }
        
        String classNames = "";
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            //System.out.println(entry.toString());
            if (entry.getName().startsWith(ACTIONSCLASSPATH) && entry.getName().endsWith(".class")) {
                String className = entry.getName();
                //System.out.println("    "+entry.getName());
                if (className.startsWith("/")) {
                    className = className.substring(1);
                }

                className = className.substring(className.lastIndexOf('/')+1);

                //System.out.println("    "+className);
                classNames = classNames + "||" + className;
            }
        }

        return classNames.replaceFirst("\\|\\|", "").split("\\|\\|");

    }

    /**
     * Trova l'url del classpath relativo memorizzato nella costante ACTIONSCLASSPATH
     * @return di tipo URL - l'url del classpath relativo memorizzato nella costante ACTIONSCLASSPATH
     */
    private static URL getActionsUrl() {
        return Action.class.getClassLoader().getResource(ACTIONSCLASSPATH);
    }

    /**
     * Determina se l'url passato per parametro si riferisce a un archivio jar
     * @param urlActions di tipo URL - url da verificare
     * @return di tipo boolean - True se l'url passato per parametro si riferisce
     * 		a un archivio jar, False altrimenti.
     */
    private static boolean isJarArchive(URL urlActions) {
        //if (urlActions.toString().indexOf('!')!=-1)
        //System.out.println("URL protocol is "+urlActions.getProtocol());
        if (urlActions.getProtocol().equalsIgnoreCase("JAR"))
            return true;
        else
            return false;
    }

    /**
     * Estrae dall'url il percorso assoluto della directory
     * @param urlActions di tipo url - url dal quale sarà estratto il percorso
     * 		assoluto della directory
     * @return di tipo String - percorso assoluto della directory puntata dall'url
     */
    private static String getDirFilePath(URL urlActions) {
        return unescape(urlActions.getPath());
    }

    /**
     * Effettua la conversione delle sequenze di caratteri di escape tipici di un url.
     * Preso da www.w3.org/International/UTF8URL.java
     * @param s di tipo String - La stringa da elaborare
     * @return di tipo String - Stringa elaborata
     */
    private static String unescape(String s) {
        StringBuffer sbuf = new StringBuffer () ;
        int l  = s.length() ;
        int ch = -1 ;
        int b, sumb = 0;
        for (int i = 0, more = -1 ; i < l ; i++) {
            /* Get next byte b from URL segment s */
            switch (ch = s.charAt(i)) {
                case '%':
                    ch = s.charAt (++i) ;
                    int hb = (Character.isDigit ((char) ch)
                        ? ch - '0'
                        : 10+Character.toLowerCase((char) ch) - 'a') & 0xF ;
                    ch = s.charAt (++i) ;
                    int lb = (Character.isDigit ((char) ch)
                        ? ch - '0'
                        : 10+Character.toLowerCase ((char) ch)-'a') & 0xF ;
                    b = (hb << 4) | lb ;
                    break ;
                case '+':
                    b = ' ' ;
                    break ;
                default:
                    b = ch ;
            }
            /* Decode byte b as UTF-8, sumb collects incomplete chars */
            if ((b & 0xc0) == 0x80) {			// 10xxxxxx (continuation byte)
                sumb = (sumb << 6) | (b & 0x3f) ;	// Add 6 bits to sumb
                if (--more == 0) sbuf.append((char) sumb) ; // Add char to sbuf
            } else if ((b & 0x80) == 0x00) {		// 0xxxxxxx (yields 7 bits)
                sbuf.append((char) b) ;			// Store in sbuf
            } else if ((b & 0xe0) == 0xc0) {		// 110xxxxx (yields 5 bits)
                sumb = b & 0x1f;
                more = 1;				// Expect 1 more byte
            } else if ((b & 0xf0) == 0xe0) {		// 1110xxxx (yields 4 bits)
                sumb = b & 0x0f;
                more = 2;				// Expect 2 more bytes
            } else if ((b & 0xf8) == 0xf0) {		// 11110xxx (yields 3 bits)
                sumb = b & 0x07;
                more = 3;				// Expect 3 more bytes
            } else if ((b & 0xfc) == 0xf8) {		// 111110xx (yields 2 bits)
                sumb = b & 0x03;
                more = 4;				// Expect 4 more bytes
            } else /*if ((b & 0xfe) == 0xfc)*/ {	// 1111110x (yields 1 bit)
                sumb = b & 0x01;
                more = 5;				// Expect 5 more bytes
            }
            /* We don't test if the UTF-8 encoding is well-formed */
        }
        return sbuf.toString() ;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        System.out.println("getClasses("+packageName+") returns following directories");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            System.out.println("    "+resource.toString());
            dirs.add(new File(resource.toString()));
        }
        System.out.println();
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName, Action.class, false));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName, Class klass, boolean searchInSubPackage) throws ClassNotFoundException {
        System.out.println("findClasses("+directory+", "+packageName+") returns following classes");
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory() && searchInSubPackage) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + file.getName() + "/", klass, searchInSubPackage));
            } else if (file.getName().endsWith(".class")) {
                System.out.println("    "+file.toString());
                classes.add(Class.forName(packageName.replace('/', '.')  + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }


    /**
     *
     * OVERVIEW: Implementazione dell'interfaccia FilenameFilter per selezionare i soli
     * file i cui nomi terminano con un determinato suffisso.
     *
     */
    private static class FiltroFileEndsWith implements FilenameFilter {
        private String pattern;

        public FiltroFileEndsWith(String suffix) {
            pattern = new String(suffix);
        }

        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(pattern.toLowerCase());
        }
    }
}