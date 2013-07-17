

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
 * @author diobubu
 */

public class NotEmptyTextField extends JTextField {
    
    private boolean borderToChange = false;
    private NotEmptyVerifier verifier;
    
    public NotEmptyTextField(String errorMessage){
        super();
        verifier = new NotEmptyVerifier(errorMessage);
        setInputVerifier(verifier);
    }
    
    public NotEmptyTextField(){
        super();
        verifier = new NotEmptyVerifier();
        setInputVerifier(verifier);
    }
    
    public boolean verify() {
        return verifier.shouldYieldFocus(this);
    }
    
    private class NotEmptyVerifier extends InputVerifier {
        
        String message = null;

        public NotEmptyVerifier() {
            message = "The field cannot be empty";
            
        }
        
        public NotEmptyVerifier(String errorMessage) {
            message = errorMessage;
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
            

            //Value was invalid.
            if (jtf.getText().trim().equals("")) {
                wasValid = false;
               
            }
            
        

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

