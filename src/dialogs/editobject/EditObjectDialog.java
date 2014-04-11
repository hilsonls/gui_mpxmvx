package dialogs.editobject;

import bean.Oggetto;
import bean.Parent;
import bean.Position;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.TileObject;
import gui.TilesWorkspace;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author panda
 */
public class EditObjectDialog extends JDialog{
    public static final int TILE_TYPE_VIDEO = 1;
    public static final int TILE_TYPE_AUDIO = 2;
    public static final int TILE_TYPE_TEXT = 3;
    public static final int TILE_TYPE_LOGO = 4;
    public static final int TILE_TYPE_CLOCK = 5;
    public static final int TILE_TYPE_TIMER = 6;
    public static final int TILE_TYPE_OTHER = 7;
    
    private JTabbedPane tabbedPane;
    
    private TypePanel typePanel;
    private BorderPanel borderPanel;
    private ParentPanel parentPanel;
    private PropertiesPanel propPanel;
    private UmdPanel umdPanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    //tilesworkspace per lanciare comandi quali init show e repaint
    private TilesWorkspace tilesWorkspace;
    //idModulo per sapere di quale modulo fa parte l'oggetto in questione
    private int idModulo;
    
    public EditObjectDialog(Frame frame, TilesWorkspace tilesWorkspace, int idModulo) throws MVException {
        super(frame);
        
        //memorizzo il tileWorkspace e l'id del modulo;
        this.tilesWorkspace = tilesWorkspace;
        this.idModulo = idModulo;
        
        Oggetto bean = tilesWorkspace.getSelectedObject().getBean();
        
        setTitle("Edit object "+bean.getId()+ " ("+bean.getUsername().getVal()+")");
        setResizable(true);
        setModal(true);
        setDefaultCloseOperation(2);
        
        // Locate the dialog where the mouse is
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        screenSize.width -= insets.right;
        screenSize.height -= insets.bottom;
        Dimension size = new Dimension(830, 800);
        Point location = MouseInfo.getPointerInfo().getLocation();
        if (location.x + size.width > screenSize.width) {
            location.x = screenSize.width - size.width;
        }
        if (location.y + size.height > screenSize.height) {
            location.y = screenSize.height - size.height;
            if (location.y < insets.top) {
                size.height += location.y;
                size.height -= insets.top;
                location.y = insets.top;
            }
        }
        setLocation(location);
        setSize(size);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(buttonActionListener);
        okButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        typePanel = new TypePanel(bean);
        borderPanel = new BorderPanel(bean.getBorder());
        parentPanel = new ParentPanel(bean.getParent());
        propPanel = new PropertiesPanel(bean.getObjectSequence());
        umdPanel = new UmdPanel(bean.getUmd());
        
        typePanel.setTypeListener(new TypeListener());
        
        tabbedPane = new JDioTabbedPane(true);

        tabbedPane.addChangeListener(new ChangeListenerColorHandled());

        //tabbedPane.setBounds(1, 1, 340, 450);
        //Aggiungo i vari panel al tabbedPane
        tabbedPane.add(typePanel);
        tabbedPane.add(borderPanel);
        tabbedPane.add(parentPanel);
        tabbedPane.add(propPanel);
        tabbedPane.add(umdPanel);
        
        tabbedPane.setSelectedComponent(typePanel);
        
        tabbedPane.setTitleAt(0, "Type");
        tabbedPane.setTitleAt(1, "Border");
        tabbedPane.setTitleAt(2, "Parent");
        tabbedPane.setTitleAt(3, "Properties");
        tabbedPane.setTitleAt(4, "UMD");
        
        addEscapeListener();
        
        getContentPane().add(tabbedPane, "Center");
        setVisible(true);
    } 
    
    public class TypeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox jcb = (JComboBox)e.getSource();
            //TODO: attualmente la query che ritorna i possibili valori del tipo di tile non funziona
            //      quindi bisognerà verificare se il seguente confronto è corretto
            String selected = (String)jcb.getSelectedItem();
            if (selected.equals("Video")) {
                umdPanel.setTileType(TILE_TYPE_VIDEO);
                propPanel.setTileType(TILE_TYPE_VIDEO);
            } else if (selected.equals("Audio")) {
                umdPanel.setTileType(TILE_TYPE_AUDIO);
                propPanel.setTileType(TILE_TYPE_AUDIO);
            } else if (selected.equals("Text")) {
                umdPanel.setTileType(TILE_TYPE_TEXT);
                propPanel.setTileType(TILE_TYPE_TEXT);
            } else if (selected.equals("Logo")) {
                umdPanel.setTileType(TILE_TYPE_LOGO);
                propPanel.setTileType(TILE_TYPE_LOGO);
            } else if (selected.equals("Clock")) {
                umdPanel.setTileType(TILE_TYPE_CLOCK);
                propPanel.setTileType(TILE_TYPE_CLOCK);
            } else if (selected.equals("Timer")) {
                umdPanel.setTileType(TILE_TYPE_TIMER);
                propPanel.setTileType(TILE_TYPE_TIMER);
            }
            else {
                umdPanel.setTileType(TILE_TYPE_OTHER);
                propPanel.setTileType(TILE_TYPE_OTHER);
            }
            
            typePanel.setTypeChanged();
        
            if (tabbedPane == null) {
                return;
            }
            
            if (propPanel.getTabCount() == 0) {
                tabbedPane.remove(propPanel);
            } else if (tabbedPane.indexOfComponent(propPanel) == -1) {
                tabbedPane.add(propPanel, 3);
                tabbedPane.setTitleAt(3, "Properties");
            }
        }
        
    }
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else if(obj == cancelButton)
                cancelAction();
        }
    }
    
    private void okAction() {
        
        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //AGGIORNO I BEAN dei panels
            typePanel.save();
            borderPanel.save();
            parentPanel.save();
            propPanel.save();
            umdPanel.save();
            
            //gestisco il parenting
            handleParenting();
            Vector figli = tilesWorkspace.getChildren(tilesWorkspace.getSelectedObject());
            handleChildren(figli);
            
            //UPLOADO IL PORCO XML A H
            
            CtrlWorkspace.getInstance().saveObjectToMV(idModulo, tilesWorkspace.getSelectedObject().getBean());
            
            for ( int j = 0; j < figli.size(); j++ ){
                
                 CtrlWorkspace.getInstance().saveObjectToMV(idModulo, ((TileObject)figli.elementAt(j)).getBean());
                
            }
                    
                       
            //tilesWorkspace.selectedObject().reloadFromBean();
            tilesWorkspace.loadTilesFromBean();
            tilesWorkspace.applyZOrder();
            //PER preservare il null pointer exception mi assicuro che ci sia almeno un oggetto a schermo
//            if(tilesWorkspace.getSelectedObject()!= null)
//                tilesWorkspace.getSelectedObject().updateAspect();
            tilesWorkspace.requestFocusInWindow();
            tilesWorkspace.repaint();
            dispose();
            
            
        } catch (MVException ex) {
            //TODO:  fare panel.undo()  oppure avvertire l'utente di ricaricare la configurazione del multiviewer
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
    
    private void handleParenting(){
        
        TileObject selectedObject = tilesWorkspace.getSelectedObject();
        Oggetto bean = selectedObject.getBean();
        Parent bParent = bean.getParent();
        Position bPosition = bean.getPosition();
                
        TileObject parentObject = tilesWorkspace.getParent(selectedObject.getBean().getParent().getObjid());
            
        if(parentObject != null)
        {
            Position parentPosition =  parentObject.getBean().getPosition();
            
            if(bParent.getAnchorPoint().getIntval() == 0)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else
            if(bParent.getAnchorPoint().getIntval() == 1)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + ( parentPosition.getWidth().getVal() - bPosition.getWidth().getVal() )/2 );                   
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else
            if(bParent.getAnchorPoint().getIntval() == 2)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal() );                   
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else
            if(bParent.getAnchorPoint().getIntval() == 6)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal() );                   
            } else
            if(bParent.getAnchorPoint().getIntval() == 7)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + ( parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()) / 2);
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal() );                   
            } else
            if(bParent.getAnchorPoint().getIntval() == 8)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()  );
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal() );                   
            } else
            if(bParent.getAnchorPoint().getIntval() == 3)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + ( parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2 );                   
            } else
            if(bParent.getAnchorPoint().getIntval() == 5)
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + (parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2 );                   
            } else
            {
                bPosition.getX().setVal(parentPosition.getX().getVal() + ( parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()) / 2);
                bPosition.getY().setVal(parentPosition.getY().getVal() + ( parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2 );                   
            }
      
            bPosition.getX().setVal( bPosition.getX().getVal() + bParent.getXoffs().getVal() );
            bPosition.getY().setVal( bPosition.getY().getVal() + bParent.getYoffs().getVal() );
        }
    }
        
    private void handleChildren(Vector figli) {

        for (int i = 0; i < figli.size(); i++) {

            TileObject tileObject = (TileObject) figli.elementAt(i);
            Oggetto bean = tileObject.getBean();
            Parent bParent = bean.getParent();
            Position bPosition = bean.getPosition();

            TileObject parentObject = tilesWorkspace.getSelectedObject();
            Position parentPosition = parentObject.getBean().getPosition();

            if (bParent.getLockSizeRatio().getVal()) {
                bPosition.getWidth().setVal((int) ((double) parentPosition.getWidth().getVal() * tileObject.getParentLockRatioX()));
                bPosition.getHeight().setVal((int) ((double) parentPosition.getHeight().getVal() * tileObject.getParentLockRatioY()));
            }
    
            if (bParent.getAnchorPoint().getIntval() == 0) {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 1) {
                bPosition.getX().setVal(parentPosition.getX().getVal() + (parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()) / 2);
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 2) {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 6) {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 7) {
                bPosition.getX().setVal(parentPosition.getX().getVal() + (parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()) / 2);
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 8) {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + parentPosition.getHeight().getVal() - bPosition.getHeight().getVal());
            } else if (bParent.getAnchorPoint().getIntval() == 3) {
                bPosition.getX().setVal(parentPosition.getX().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + (parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2);
            } else if (bParent.getAnchorPoint().getIntval() == 5) {
                bPosition.getX().setVal(parentPosition.getX().getVal() + parentPosition.getWidth().getVal() - bPosition.getWidth().getVal());
                bPosition.getY().setVal(parentPosition.getY().getVal() + (parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2);
            } else {
                bPosition.getX().setVal(parentPosition.getX().getVal() + (parentPosition.getWidth().getVal() - bPosition.getWidth().getVal()) / 2);
                bPosition.getY().setVal(parentPosition.getY().getVal() + (parentPosition.getHeight().getVal() - bPosition.getHeight().getVal()) / 2);
            }
    
            bPosition.getX().setVal(bPosition.getX().getVal() + bParent.getXoffs().getVal());
            bPosition.getY().setVal(bPosition.getY().getVal() + bParent.getYoffs().getVal());


        }
    }
    
    /**
     * Close dialog when Esc key pressed
     */
    private void addEscapeListener() {
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }
        };
        
        getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
 


}
