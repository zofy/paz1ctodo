package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class mysqlUlohaDaO implements UlohaDao {

    JdbcTemplate temp;

    public mysqlUlohaDaO() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:myslq://localhost/todo");
        dataSource.setUser("todo");
        dataSource.setPassword("todo");
        temp = new JdbcTemplate(dataSource);

    }

    @Override
    public void pridat(Uloha uloha) {
        String sql = "insert into uloha values(?,?,?,?)";
        temp.update(sql, null, uloha.getNazov(), uloha.getDate(), "fgehr");
    }

    @Override
    public List<Uloha> dajVsetky() {
        String sql = "select * from uloha";
        BeanPropertyRowMapper<Uloha> mapper = BeanPropertyRowMapper.newInstance(Uloha.class);
        return temp.query(sql, mapper);
    }

}
