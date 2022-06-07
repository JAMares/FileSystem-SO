/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.filesystem;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.ListCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;


/**
 *
 * @author Aozhen
 */
public class FileSystemListRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
        if(value instanceof Directory){
            label.setIcon(render.getDefaultClosedIcon());
        }
        if(value instanceof Files){
            label.setIcon(render.getDefaultLeafIcon());
        }
        
        return label;
    }
}