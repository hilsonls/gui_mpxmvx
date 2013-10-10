/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;

import javax.swing.JCheckBox;

/**
 *
 * @author Antonio
 */
public class JCheckBoxTransBG extends JCheckBox {

    public JCheckBoxTransBG (){
        super();
        this.setOpaque(false);
    }
    
    public JCheckBoxTransBG(String text) {
        super(text);
        setOpaque(false);
    }
}
