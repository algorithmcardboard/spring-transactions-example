package in.rajegannathan.spring.transactions.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;

	public int getCountOfUsers(){
		return this.jdbcTemplate.queryForInt("select count(*) from user");
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
