package sk.upjs.ics.todo;
//ako sa maju data namalovat na pozadie

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UlohaListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        Uloha u = (Uloha) value;
        if (jeSplnena(u) && !isSelected) {
//            comp.setBackground(Color.green);
            comp.setForeground(Color.red);
        }
        return comp;
    }

    private boolean jeSplnena(Uloha u) {
        return true;
    }

}
