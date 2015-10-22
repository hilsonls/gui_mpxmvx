package gui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author antonio
 */
public class JSplashFrame extends JFrame {
    
    public static URL defaultIcon;
    
    public static ImageIcon firstIcon;
    
    public static Font defaultFont = new Font("Lucida",Font.BOLD,16);
    
    public static JPanel getJSplashPanel(String msg, Font font, ImageIcon imageicon){
        firstIcon = imageicon;
        return getJSplashPanel(msg, font, (URL)null, (URL)null);
    }
    
    public static JPanel getJSplashPanel(String msg, Font font, URL imgAddress1, URL imgAddress2){
        
        JPanel panel = new JPanel();
          
            panel.addMouseListener(new MouseAdapter() { }); 
            panel.addMouseMotionListener(new MouseMotionAdapter() { });
            panel.addKeyListener(new KeyAdapter() { });
            panel.setFocusTraversalKeysEnabled(false); 
            
                  
        panel.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
        Dimension dimensioni = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setLocation((dimensioni.width / 8)*3, (dimensioni.height / 8)*3);
        panel.setSize(new Dimension(dimensioni.width / 4, dimensioni.height / 4));
        panel.setLayout(new GridLayout(2, 1));
        panel.setOpaque(false);
        
               
        
        Color c = new Color(200, 200, 200, 160);
        //panel.setBackground(c);
        
        
        if(msg != null) {
            JLabel mes;
            mes = new JLabel(msg, SwingConstants.CENTER);
            mes.setOpaque(true);
            mes.setBackground(c);
            if (font != null) {
                defaultFont = font;
            }
            mes.setFont(defaultFont);
            panel.add(mes);
        } else {
            panel.setLayout(new GridLayout(1, 1));
        }

        JButton but = null;
        if (imgAddress1 != null) {
            defaultIcon = imgAddress1;
            firstIcon = new ImageIcon(defaultIcon);
            if (firstIcon.getImage().getWidth(null) > 0)
                but = new JButton(firstIcon);
        }
        if (but == null && imgAddress2 != null) {
            defaultIcon = imgAddress2;
            firstIcon = new ImageIcon(defaultIcon);
            if (firstIcon.getImage().getWidth(null) > 0)
                but = new JButton(firstIcon);
        }
        if (but == null && firstIcon != null){
            but = new JButton(firstIcon);
        }

        if(but != null){
            but.setBorderPainted(false);
            but.setEnabled(false);
            but.setDisabledIcon(firstIcon);
            but.setOpaque(false);
//            but.setBackground(c);
            panel.add(but);
            //Cursor myPointer= Toolkit.getDefaultToolkit().createCustomCursor(firstIcon.getImage(), new Point(0,0), "Blah");
            //panel.setCursor(myPointer); 
        }
        //panel.repaint();
        panel.setEnabled(true);
        panel.setVisible(true);
        
        return panel;
    }
   
    public static JFrame getJSplashFrame(String msg, Font font, URL imgAddress1, URL imgAddress2) {
        
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        
        JPanel pannello = getJSplashPanel(msg, font, imgAddress1, imgAddress2);

        Image image = firstIcon.getImage();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        Dimension dimensioni = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dimensioni.width - imageWidth) / 2, (dimensioni.height - imageHeight) / 2);
        frame.setSize(imageWidth, imageHeight);
        frame.setTitle("Loading");
        
        frame.add(pannello);
       
        frame.setIconImage(image);
        
        frame.setVisible(true);
        
        return frame;
    }
    
    public static JDialog getJSplashDialog(Frame frame, String msg, Font font, URL imgAddress1, URL imgAddress2){
         
        JDialog dialog = new JDialog(frame, true);
        
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setUndecorated(true);
        dialog.setTitle("wait..");
        Dimension dimensioni = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((dimensioni.width / 8)*3, (dimensioni.height / 8)*3);
        dialog.setSize(new Dimension(dimensioni.width / 4, dimensioni.height / 4));
        
        //dialog.setModal(true);
        dialog.add(getJSplashPanel(msg, font, imgAddress1, imgAddress2));
        
        dialog.setVisible(true);
        
        return dialog;
        
    }
}
