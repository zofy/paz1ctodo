package sk.upjs.ics.todo;
//ako sa maju data namalovat na pozadie

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UlohaListCellRenderer implements ListCellRenderer<Uloha> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Uloha> list, Uloha uloha, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel ulohaLabel = new JLabel(uloha.getNazov());
        ulohaLabel.setOpaque(true);
        if (jeSplnena(uloha)) {
            ulohaLabel.setBackground(Color.green);
        }
        return ulohaLabel;
    }

    private boolean jeSplnena(Uloha uloha) {
        return true;
    }

}
