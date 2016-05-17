package gui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderPanel extends JPanel {
    
    private static final int MAX_H_SIZE = 20;
    private static final int MAX_V_SIZE = 100;

    private JSlider jSlider;
    private JTextField sliderField;
    private String prefisso;
    private String suffisso;
    private int numDecimals;
    private boolean isEditing;
    private Vector changeListeners;

    private class FieldListener extends FocusAdapter implements ActionListener {

        @Override
        public void focusGained(FocusEvent focusevent) {
            sliderField.selectAll();
        }

        @Override
        public void focusLost(FocusEvent focusevent) {
            controlla();
        }

        public void actionPerformed(ActionEvent actionevent) {
            controlla();
        }

        private void controlla() {
            try {
                String testo = sliderField.getText();
                String p = prefisso.trim();
                String s = suffisso.trim();

                if (!"".equals(p) && testo.startsWith(p)) {
                    testo = testo.substring(p.length());
                }
                if (!"".equals(s) && testo.endsWith(s)) {
                    testo = testo.substring(0, testo.length() - 1 - s.length());
                }

                testo = testo.trim();

                double testoDouble = Double.parseDouble(testo);
                testoDouble = testoDouble * Math.pow(10D, numDecimals);
                int i = (int) Math.round(testoDouble);
                
                if (i < jSlider.getMinimum()) {
                    i = jSlider.getMinimum();
                } else if (i > jSlider.getMaximum()) {
                    i = jSlider.getMaximum();
                }

                jSlider.setValue(i);

            } catch (Exception ex) {
                setTextField();
                return;
            }
            setTextField();
            fireChangeEvent();
        }
    }

    private class SliderListener extends FocusAdapter implements ChangeListener {

        @Override
        public void focusLost(FocusEvent focusevent) {
            isEditing = false;
        }

        public void stateChanged(ChangeEvent changeevent) {
            isEditing = jSlider.getValueIsAdjusting();
            setTextField();
            fireChangeEvent();
        }
    }

    public JSliderPanel(int decimals) {


        setOpaque(false);
        setLayout(new BorderLayout());
        
        prefisso = "";
        suffisso = "";
        isEditing = false;
        numDecimals = decimals;
        changeListeners = new Vector();

        sliderField = new JTextField();
        sliderField.setText("0");
        sliderField.setHorizontalAlignment(0);
        sliderField.setOpaque(false);

        jSlider = new JSlider();
        jSlider.setValue(0);
        jSlider.setMinimum(0);
        jSlider.setMaximum(1000);
        jSlider.setOpaque(false);


        SliderListener sliderlistener = new SliderListener();
        jSlider.addFocusListener(sliderlistener);
        jSlider.addChangeListener(sliderlistener);
        FieldListener fieldlistener = new FieldListener();
        sliderField.addFocusListener(fieldlistener);
        sliderField.addActionListener(fieldlistener);
        sliderField.setPreferredSize(new Dimension(40, 20));
        add(jSlider, "Center");
        add(sliderField, "East");
        
        Dimension d = getMaximumSize();
        d.height = MAX_H_SIZE;
        setMaximumSize(d);
    }


    public JSliderPanel(int min, int max, int value) {
        this(0);
        setRange(min, max);
        setValue(value);
    }

    public JSliderPanel(int min, int max, int value, int numDecimals) {
        this(numDecimals);
        setRange(min, max);
        setValue(value);
    }

    

    public JSliderPanel() {
        this(0);
    }

    public void setPrefisso(String s) {
        if (s == null) {
            prefisso = "";
        } else {
            prefisso = s;
        }
    }

    public void setSuffisso(String s) {
        if (s == null) {
            suffisso = "";
        } else {
            suffisso = s;
        }
    }

 

    public void setDoubleRange(double min, double max) {
        int val = jSlider.getValue();
        jSlider.setMinimum((int)(min * Math.pow(10D, numDecimals)));
        jSlider.setMaximum((int)(max * Math.pow(10D, numDecimals)));
        jSlider.setValue(val);
    }

    public void setRange(int min, int max) {
        setDoubleRange((double)min, (double)max);
    }

    public int getMinimum() {
        return jSlider.getMinimum();
    }

    public int getMaximum() {
        return jSlider.getMaximum();
    }

    public void setMaximum(int max) {
        setRange(jSlider.getMinimum(), max);
    }
    
    public void setDoubleMaximum(double max) {
        setDoubleRange((double)jSlider.getMinimum(), max);
    }
    
    public void setValue(int val) {
        jSlider.setValue((int)((double)val*Math.pow(10D, numDecimals)));
        setTextField();
    }

    public void setValue(double doubleVal) {
        jSlider.setValue((int)Math.round(doubleVal*Math.pow(10D, numDecimals)));
        setTextField();
    }

    public void setStringValue(String stringValue) {
        try {
            setValue(Integer.parseInt(stringValue));
        } catch (Exception exception) {
            try {
                setValue(Double.parseDouble(stringValue));
            } catch (Exception e) {
                // niente
            }
        }
    }

    public int getValue() {
        return jSlider.getValue();
    }

    public double getDoubleValue() {
        return (double)getValue()/Math.pow(10D, numDecimals);
    }

    public float getFloatValue() {
        return (float)(getValue()/Math.pow(10D, numDecimals));
    }

    public String getStringValue() {
        return "" + getValue();
    }

    public void setTextField() {
        if (numDecimals == 0) {
            sliderField.setText(prefisso + jSlider.getValue() + suffisso);
        } else {
            sliderField.setText(prefisso + (double)jSlider.getValue()/Math.pow(10D, numDecimals) + suffisso);
        }
    }


    public void setFieldEditable(boolean editable) {
        sliderField.setEditable(editable);
    }


    public boolean isEditing() {
        return isEditing;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        jSlider.setEnabled(enabled);
        sliderField.setEnabled(enabled);
    }

    @Override
    public void setVisible(boolean visible) {
        jSlider.setVisible(visible);
        sliderField.setVisible(visible);
        super.setVisible(visible);
    }


    private void fireChangeEvent() {
        ChangeEvent changeevent = new ChangeEvent(this);
        for (int i = 0; i < changeListeners.size(); i++) {
            ((ChangeListener) changeListeners.elementAt(i)).stateChanged(changeevent);
        }
    }

    public void addChangeListener(ChangeListener changelistener) {
        changeListeners.addElement(changelistener);
    }

    public void removeChangeListener(ChangeListener changelistener) {
        changeListeners.removeElement(changelistener);
    }
    
    public void setOrientation(int orientation) {
        jSlider.setOrientation(orientation);
        Dimension d = getMaximumSize();
        d.height = orientation == SwingConstants.VERTICAL ? MAX_V_SIZE : MAX_H_SIZE;
        setMaximumSize(d);
   }
    
    public JSlider getSlider() {
        return jSlider;
    }
}