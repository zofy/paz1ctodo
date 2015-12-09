package sk.upjs.ics.todo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.springframework.dao.support.DaoSupport;
import sun.security.krb5.internal.tools.Ktab;

public class KategoriaTableModel extends AbstractTableModel {

    private KategoriaDaO kat = new MysqlKategoriaDaO();
    private UlohaDao ud = UlohaDaOFactory.INSTANCE.getUlohaDao();
    final int pocetStlpcov = 2;

    @Override
    public int getRowCount() {
        return kat.dajVsetky().size();
    }

    @Override
    public int getColumnCount() {
        return pocetStlpcov;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategoria k = null;
        if (rowIndex == 0) {
            k = new Kategoria();
            k.setNazov("Vsetko a nic");
            List<Uloha> vu = new ArrayList<>();
            k.setUlohy(ud.dajVsetky());
            return "Vsetko a nic";
        } else {
            k = kat.dajVsetky().get(rowIndex - 1);
        }
        switch (columnIndex) {
            case STLPEC_NAZOV:
                return k.getNazov();
            case POCET_ULOH:
                return k.getUlohy().size();
            default:
                return "pre pripad nudze";
        }

    }
    private static final int POCET_ULOH = 1;
    private static final int STLPEC_NAZOV = 0;
    private static final String[] nazvyStlpoc = {"Nazov", "Pocet uloh"};
    private static final int riadok_pre_vsetky_ulohy = 1;

    @Override
    public String getColumnName(int column) {
        return nazvyStlpoc[column];
    }

    public Kategoria getKategoria(int idx) {
        Kategoria k = null;
        if (idx == 0) {
            k = new Kategoria();
            k.setNazov("Vsetko a nic");
            List<Uloha> vu = new ArrayList<>();
            k.setUlohy(ud.dajVsetky());
            return k;
        } else {
            return kat.dajVsetky().get(idx);
        }
    }
}
