package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class mysqlUlohaDaO implements UlohaDao {

    JdbcTemplate temp;

    @Override
    public void upravit(Uloha u) {
        temp.update("UPDATE uloha SET nazov = ?,date = ?,ulohacol = ?,splnena = ? WHERE id = ?",
                u.getNazov(), u.getDate(), "njn", u.isSplnena(), u.getId());
    }

    public class UlohaMapper implements RowMapper<Uloha> {

        @Override
        public Uloha mapRow(ResultSet rs, int i) throws SQLException {
            Uloha u = new Uloha();
            u.setId(rs.getLong("id"));
            u.setNazov(rs.getString("nazov"));
            u.setDate(rs.getDate("date"));
            u.setSplnena(rs.getBoolean("splnena"));
            return u;
        }

    }

    public mysqlUlohaDaO() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/todo");
        dataSource.setUser("todo");
        dataSource.setPassword("todo");
        temp = new JdbcTemplate(dataSource);

    }

    @Override
    public void pridat(Uloha uloha) {
        String sql = "insert into uloha values(?,?,?,?,?)";
        temp.update(sql, null, uloha.getNazov(), uloha.getDate(), "fgehr", uloha.isSplnena());
    }

    @Override
    public List<Uloha> dajVsetky() {
        String sql = "select * from uloha";
        //BeanPropertyRowMapper<Uloha> mapper = BeanPropertyRowMapper.newInstance(Uloha.class);
        return temp.query(sql, new UlohaMapper());
    }

    @Override
    public void vymaz(Uloha u) {
        String sql = "delete from uloha where id=?";
        //temp.update("delete from uloha where id=?", u.getId());
        temp.update(sql, u.getId());
    }

}
