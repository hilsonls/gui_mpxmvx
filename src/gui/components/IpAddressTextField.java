/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */

public class IpAddressTextField extends JTextField {
    
    private boolean borderToChange = false;
    private IPAddressVerifier verifier;
    
    public IpAddressTextField(boolean allowEmpty) {
        this(allowEmpty, true);
    }
    
    public IpAddressTextField(boolean allowEmpty, boolean autoVerify) {
        super();
        verifier = new IPAddressVerifier(allowEmpty);
        if (autoVerify)
            setInputVerifier(verifier);
    }
    
    public boolean verify() {
        return verifier.shouldYieldFocus(this);
    }
    
    private class IPAddressVerifier extends InputVerifier {
        private String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        private String ipRegEx = "^(?:" + _255 + "\\.){3}" + _255 + "$";
        String message = null;
        boolean allowEmpty;

        public IPAddressVerifier(boolean allowEmpty) {
            this.allowEmpty = allowEmpty;
            //checkBounds = false;
            //message = "Please insert an integer value";
        }
                
        @Override
        public boolean shouldYieldFocus(JComponent input) {
            boolean inputOK = verify(input);
            makeItPretty(input);

            if (inputOK) {
                return true;
            }

            //Beep
            Toolkit.getDefaultToolkit().beep();
            
            //Pop up the message dialog.
            JOptionPane.showMessageDialog(null, //no owner frame
                                          message, //text to display
                                          "Invalid Value", //title
                                          JOptionPane.WARNING_MESSAGE);

            //Reinstall the input verifier.
            input.setInputVerifier(this);

            //Tell whoever called us that we don't want to yield focus.
            return false;
        }

        //This method checks input, but should cause no side effects.
        public boolean verify(JComponent input) {
            return checkField(input, false);
        }
        
        protected void makeItPretty(JComponent input) {
            checkField(input, true);
        }

        protected boolean checkField(JComponent input, boolean change) {
            boolean wasValid = true;
            JTextField jtf = (JTextField)input;
            int value;

            //Value was invalid.
            if (!(jtf.getText().trim().matches(ipRegEx) || (allowEmpty && jtf.getText().trim().equals("")))) {
                wasValid = false;
                message = "Please insert a valid ip address";
            }
            
            
            //per evitare che accetta 0.0.0.0
            /*if(jtf.getText().trim().equals("0.0.0.0")){
                wasValid = false;
                message = "Please insert a valid ip address";
            }*/

            if (!wasValid) {
                jtf.selectAll();
                borderToChange = true;
            } else borderToChange = false;

            if (wasValid && change) {
                jtf.setText(jtf.getText().trim());
            }
            repaint();
            
            return wasValid;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (borderToChange) {
            g.setColor(Color.RED);

            g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        }
    }

    
}

