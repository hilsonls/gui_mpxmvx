/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * classe che rappresenta un nodo di un JTree generico
 * ha la caratteristica di avere una coppia id (int) valore (string)
 * quando l'id non è specificato viene settato  a -1
 * 
 * @author antonio
 */
public class JIDStringNode extends DefaultMutableTreeNode {
    
    private int id;
    private String value;
    
    //
    private int status;
    
    public static final int FREE = 0;
    public static final int USED = 1;
    public static final int SELECTED = 2;
    
    
    public JIDStringNode(Object obj){
        super(obj);
        this.id = -1;
        this.value = obj.toString();
    }
    
    public JIDStringNode(Object obj, boolean childPermitted){
        super(obj, childPermitted);
        this.id = -1;
        this.value = obj.toString();
    }

    public JIDStringNode(int id, String value) {
        
        super();
        this.id = id;
        this.value = value;
        setUserObject(this.value);
        
    }
       
    public JIDStringNode(int id, String value, int status) {
        
        super();
        this.id = id;
        this.value = value;
        this.status = status;
        setUserObject(this.value);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public JIDStringNode getChildNodeByID(int id) {
       
        JIDStringNode found = null;
        for (Enumeration e = this.children(); e.hasMoreElements();) {
            JIDStringNode node = (JIDStringNode) e.nextElement();
            if(node.getId()==id){
                found = node;
            }
        }
        return found;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
