package sk.upjs.ics.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.jdbc.core.RowCallbackHandler;

public class KategoriaRowCall implements RowCallbackHandler {

    Long predosleId;
    List<Kategoria> zoznamK = new LinkedList<Kategoria>();

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        if (zmeniloSa(id, predosleId)) {
            predosleId = id;
            Kategoria k = new Kategoria();
            k.setId(id);
            k.setNazov(rs.getString(2));
            zoznamK.add(k);

            Uloha u = new Uloha();
            u.setId(rs.getLong(3));
            u.setNazov(rs.getString(4));
            u.setDate(rs.getDate(5));
            u.setSplnena(rs.getBoolean(6));

            k.getUlohy().add(u);
        } else {
            Uloha u = new Uloha();
            u.setId(rs.getLong(3));
            u.setNazov(rs.getString(4));
            u.setDate(rs.getDate(5));
            u.setSplnena(rs.getBoolean(6));

            zoznamK.get(zoznamK.size() - 1).getUlohy().add(u);
        }
    }

    private boolean zmeniloSa(Long id, Long predosleId) {
        if (predosleId == null) {
            return true;
        } else {
            return predosleId != id;
        }
    }
    // dat zoznam kat

    List<Kategoria> getK() {
        return zoznamK;
    }

}
