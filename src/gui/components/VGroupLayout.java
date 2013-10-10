package gui.components;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author michael
 */
public class VGroupLayout extends GroupLayout {
    static final int DEFAULT_INDENT = 20;
    static final int UNRELATED_VGAP_MAX = 20;
    
    private ParallelGroup hgroup;
    private SequentialGroup vgroup;

    /**
     * @param host
     * @see GroupLayout
     */
    public VGroupLayout(Container host) {
        super(host);
        setAutoCreateGaps(true);
        setAutoCreateContainerGaps(true);
        hgroup = createParallelGroup(GroupLayout.Alignment.LEADING);
        setHorizontalGroup(hgroup);
        vgroup = createSequentialGroup();
        setVerticalGroup(vgroup);
    }
    
    /**
     * Add a new component. Each new component gets added in the vertical
     * axis, starting from the top.
     * @param comp  the component to add.
     */
    public void add(Component comp) {
        hgroup.addComponent(comp, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        vgroup.addComponent(comp);
    }
    
    /**
     * Add a new component, indenting it
     * @param comp the component to add.
     */
    public void addIndent(Component comp) {
        SequentialGroup hg = createSequentialGroup();
        hg.addContainerGap(DEFAULT_INDENT, DEFAULT_INDENT);
        hg.addComponent(comp);
        hgroup.addGroup(hg);
        vgroup.addComponent(comp);
    }
    
    /**
     * Add a new row of components.
     * @param hcomp array of components to add to the new row.
     */
    public void addRow(Component[] hcomp) {
        SequentialGroup hg = createSequentialGroup();
        ParallelGroup vg = createParallelGroup(GroupLayout.Alignment.BASELINE);
        for (Component c : hcomp) {
            hg.addComponent(c);
            vg.addComponent(c);
        }
        hgroup.addGroup(hg);
        vgroup.addGroup(vg);
    }

    /**
     * Add a 2-dimensional array (grid) of components. This aligns all the
     * components onto a grid, their relative position determined by the
     * position in the array.
     * @param grid 2-d array of components to add (grid[row][column]).
     * A larger than normal vertical gap can be inserted between selected
     * rows by passing a row of null components between the 2 other rows.
     */
    public void addGrid(Component[][] grid) {
        addGrid(0, grid);
    }

    /**
     * Add a 2-dimensional array (grid) of components indented.
     * @param grid 2-d array of components to add (grid[row][column]).
     * A larger than normal vertical gap can be inserted between selected
     * rows by passing a row of null components between the 2 other rows.
     */
    public void addGridIndent(Component[][] grid) {
        addGrid(DEFAULT_INDENT, grid);
    }

    private void addGrid(int indent, Component[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        SequentialGroup hg = createSequentialGroup();
        if (indent > 0) {
            hg.addContainerGap(indent, indent);
        }
        
        // horizontal traversal:
        // a new horizontal sequential group consisting of a set of parallel
        // groups, one for each column 
        for (int col = 0; col < numCols; col++) {
            ParallelGroup pg = createParallelGroup();
            for (int row = 0; row < numRows; row++) {
                if (grid[row][col] != null) {
                    pg.addComponent(grid[row][col]);
                }
            }
            hg.addGroup(pg);
        }
        hgroup.addGroup(hg);

        // vertical traversal: 
        // the existing vertical sequential group consisting of a set of parallel
        // groups, one for each row 
        for (int row = 0; row < numRows; row++) {
            if (grid[row][0] == null) {
                addGap();
            } else {
                ParallelGroup pg = createParallelGroup(Alignment.BASELINE);
                for (int col = 0; col < numCols; col++) {
                    pg.addComponent(grid[row][col]);
                }
                vgroup.addGroup(pg);
            }
        }
        
    }

    /**
     * Add a gap after the last / before the next component to be added. This
     * adds an unrelated type gap in the vertical direction.
     */
    public void addGap() {
        vgroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,
                GroupLayout.DEFAULT_SIZE, UNRELATED_VGAP_MAX);
    }
    

}
