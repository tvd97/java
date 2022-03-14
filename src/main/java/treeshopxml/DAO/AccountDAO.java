package treeshopxml.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Infomations;

import treeshopxml.Entities.Mapper.AccountMapper;
import treeshopxml.Entities.Mapper.InfomationMapper;


@Repository
public class AccountDAO {
	@Autowired
	private JdbcTemplate _JdbcTemplate;

	public boolean addAccount(Accounts accounts) {
		String query = "INSERT INTO `accounts`(`username`, `password`, `name`, `status`) VALUES ('"
				+ accounts.getUsername() + "','" + accounts.getPassword() + "','" + accounts.getName() + "',"
				+ accounts.getStatus() + ")";
		if (_JdbcTemplate.update(query) > 0)
			return true;
		return false;
	}

	public int Login(String username, String password) {
		String query = "select * from accounts where username='" + username + "' and password='" + password + "'";
		try {
			Accounts accounts = _JdbcTemplate.queryForObject(query, new AccountMapper());
			if (null == accounts)
				return -1;
			return accounts.getStatus();
		} catch (Exception e) {
			return 0;
		}
		
	}

	public int checkAccount(String username) {
		String query = "SELECT * FROM accounts WHERE username='" + username + "'";
		List<Accounts> list = _JdbcTemplate.query(query, new AccountMapper());
		if (list.size() < 1)
			return 1;
		else
			return 0;
	}

	public String getUser(String username) {
		Infomations info;
		String query = "SELECT * FROM infomations where username='" + username + "'";
		try {
			info = _JdbcTemplate.queryForObject(query, new InfomationMapper());
			return info.getId();
		} catch (Exception e) {		
			return null;
		}
		
		
	}
	public Infomations getInfo(String username) {
		Infomations info;
		String query = "SELECT * FROM infomations where username='" + username + "'";
		try {
			info = _JdbcTemplate.queryForObject(query, new InfomationMapper());
			return info;
		} catch (Exception e) {
			return null;
		}
		
		
	}

	public void changPassword(String username, String password) {
		// TODO Auto-generated method stub
		String query = "UPDATE accounts SET password = '"+password+"' WHERE username='"+username+"'";
		try {
			_JdbcTemplate.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}
}
