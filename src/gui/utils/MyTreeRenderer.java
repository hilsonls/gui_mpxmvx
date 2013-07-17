package gui.utils;

import gui.*;
import gui.components.JIDStringNode;
import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class MyTreeRenderer extends DefaultTreeCellRenderer {

    Icon iconObj;
    Icon iconSource;
    Icon iconLayout;
    MultiViewerPanel outer;

    public MyTreeRenderer(Icon iconObj, Icon iconSource, Icon iconLayout, MultiViewerPanel outer) {
        super();
        this.outer = outer;
        this.iconObj = iconObj;
        this.iconSource = iconSource;
        this.iconLayout = iconLayout;
        setBackgroundNonSelectionColor(StyleInterface.getInstance().getTreeBackgroundColor());
        setBackgroundSelectionColor(new Color(138, 163, 199));
    }

    public void setStatus(JIDStringNode nodo) {
        switch (nodo.getStatus()) {
            case JIDStringNode.FREE:
                this.setTextNonSelectionColor(Color.BLACK);
                break;
            case JIDStringNode.USED:
                this.setTextNonSelectionColor(Color.RED);
                break;
            case JIDStringNode.SELECTED:
                this.setTextNonSelectionColor(Color.YELLOW);
        }
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JIDStringNode nodo = (JIDStringNode) value;
        TreePath patta = tree.getPathForRow(row);
        if (patta != null) {
            if (nodo.getId() == -1) {
            } else {
                if (tree.getPathForRow(row).getPathComponent(1).toString().equals("Objects")) {
                    setLeafIcon(iconObj);
                } else if (tree.getPathForRow(row).getPathComponent(1).toString().equals("Sources")) {
                    setLeafIcon(iconSource);
                } else if (tree.getPathForRow(row).getPathComponent(1).toString().equals("Layouts")) {
                    setLeafIcon(iconLayout);
                }
            }
        }
        setStatus(nodo);
        //this.setTextNonSelectionColor(Color.pink);
        return super.getTreeCellRendererComponent(tree, nodo.getValue(), sel, expanded, leaf, row, hasFocus);
    }
}
