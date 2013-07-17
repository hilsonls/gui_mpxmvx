/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.remote;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */
 public class IpAddressCustomDialog extends JDialog implements ActionListener, PropertyChangeListener {
        private static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        private static final String IP_REGEX = "^(?:" + _255 + "\\.){3}" + _255 + "$";
        
        private String typedText = null;
        private JTextField textField;

        private JOptionPane optionPane;

        private String btnString1 = "Ok";
        private String btnString2 = "Cancel";

        /**
         * Returns null if the typed string was invalid;
         * otherwise, returns the string as the user entered it.
         */
        public String getValidatedText() {
            return typedText;
        }

        public IpAddressCustomDialog(Frame frame, String title, String msg, String value) {
            super(frame, true);
            //dd = parent;

            setTitle(title);

            //Array di componenti da visualizzare.
            textField = new JTextField();
            textField.setText(value);
            Object[] array = {msg, textField};

            //Array di stringhe usate per creare i pulsanti da visualizzare
            Object[] options = {btnString1, btnString2};

            optionPane = new JOptionPane(array,
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.YES_NO_OPTION,
                                        null,
                                        options,
                                        options[0]);

            setContentPane(optionPane);

            //Handle window closing correctly.
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                    public void windowClosing(WindowEvent we) {
                    /*
                     * Instead of directly closing the window,
                     * we're going to change the JOptionPane's
                     * value property.
                     */
                        optionPane.setValue(new Integer(
                                            JOptionPane.CLOSED_OPTION));
                }
            });

            //Ensure the text field always gets the first focus.
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent ce) {
                    textField.requestFocusInWindow();
                }
            });

            //Register an event handler that puts the text into the option pane.
            textField.addActionListener(this);

            //Register an event handler that reacts to option pane state changes.
            optionPane.addPropertyChangeListener(this);
        }

        /** This method handles events for the text field. */
        public void actionPerformed(ActionEvent e) {
            optionPane.setValue(btnString1);
        }

        /** This method reacts to state changes in the option pane. */
        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();

            if (isVisible()
             && (e.getSource() == optionPane)
             && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
                 JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
                Object value = optionPane.getValue();

                if (value == JOptionPane.UNINITIALIZED_VALUE) {
                    //ignore reset
                    return;
                }

                //Reset the JOptionPane's value.
                //If you don't do this, then if the user
                //presses the same button next time, no
                //property change event will be fired.
                optionPane.setValue(
                        JOptionPane.UNINITIALIZED_VALUE);

                if (btnString1.equals(value)) {
                    if (textField.getText().trim().matches(IP_REGEX)) {
                        //we're done; clear and dismiss the dialog
                        typedText = textField.getText().trim();
                        clearAndHide();
                    } else {
                        //text was invalid
                        textField.selectAll();
                        JOptionPane.showMessageDialog(IpAddressCustomDialog.this,
                                                      "Please insert a valid ip address",
                                                      "Invalid Value",
                                                      JOptionPane.WARNING_MESSAGE);
                                       
                        typedText = null;
                        textField.requestFocusInWindow();
                    }
                } else { 
                    typedText = null;
                    clearAndHide();
                }
            }
        }

        /** This method clears the dialog and hides it. */
        public void clearAndHide() {
            textField.setText(null);
            setVisible(false);
        }
    }