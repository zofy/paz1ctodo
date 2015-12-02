package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlKategoriaDaO implements KategoriaDaO {

    JdbcTemplate temp;

    public MysqlKategoriaDaO() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/todo");
        dataSource.setUser("todo");
        dataSource.setPassword("todo");
        temp = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Kategoria> dajVsetky() {
        KategoriaRowCall kr = new KategoriaRowCall();
        temp.query("select * from kategoria\n"
                + "left join uloha on kategoria.id = kategoriaId;", kr);
        return kr.getK();
    }

}
