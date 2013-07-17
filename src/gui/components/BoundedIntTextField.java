/*
 * To change this template, choose Tools | Templates
 * and open the template in the
 
 editor.
 */

package gui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */
public class BoundedIntTextField extends JTextField {
    
    private boolean borderToChange = false;
    private boolean leadZero;
    private int maxLen;
    
    public BoundedIntTextField(int valore) {
        super(""+valore);
        maxLen = 0;
        leadZero = false;
        setInputVerifier(new MyVerifier());
    }
    
    public BoundedIntTextField(int valore, int min, int max) {
        this(valore, min, max, false);
    }

    public BoundedIntTextField(int valore, int min, int max, boolean leadZero) {
        super(""+valore);

        this.leadZero = leadZero;
        if (leadZero) {
            this.maxLen = Integer.toString(max).length();
        } else {
            this.maxLen = 0;
        }
        
        setInputVerifier(new MyVerifier(min, max));

        setText(Integer.toString(valore));

        /*if (leadZero) {
            String strValue = ""+valore;
            for (int i = Integer.toString(max).length()-strValue.length(); i>0; i--)
                    strValue = "0"+strValue;
            setText(strValue);
        }*/
    }
    
    @Override
    public void setText(String value) {
        if (leadZero) {
            for (int i = maxLen-value.length(); i>0; i--)
                    value = "0"+value;
        }
        super.setText(value);
    }
    
    class MyVerifier extends InputVerifier implements ActionListener {
        String message = null;
        
        private int min;
        private int max;
        private boolean checkBounds;

        public MyVerifier() {
            checkBounds = false;
            //message = "Please insert an integer value";
        }
        
        public MyVerifier(int min, int max) {
            this.min = min;
            this.max = max;
            this.checkBounds = true;
            //message = "Please insert an integer value between "+min +" and "+max;
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
            //Parse the value.
            try {
                value = Integer.parseInt(jtf.getText());
            } catch (NumberFormatException nfe) {
                message = "Please insert an integer value";
                jtf.selectAll();
                borderToChange = true;
                repaint();
                return false;
            }

            //Value was invalid.
            if (checkBounds && ((value < min) || (value > max))) {
                wasValid = false;
                if (value < min) {
                    message = "Please insert an integer value greater than "+(min-1);
                } else { //amount is greater than MAX_AMOUNT
                    message = "Please insert an integer value lower than "+(max+1);
                }
            }

            if (change && !wasValid) {
                jtf.selectAll();
                borderToChange = true;
            } else borderToChange = false;

            if (change && wasValid && leadZero) {
                jtf.setText(jtf.getText());
            }

            repaint();
            
            return wasValid;
        }

        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField)e.getSource();
            shouldYieldFocus(source); //ignore return value
            source.selectAll();
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
