package treeshopxml.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.AccountDAO;
import treeshopxml.DTO.UserLogin;
import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Infomations;
import treeshopxml.Security.CryptMD5;
import treeshopxml.Service.Interface.IAccount;

@Service
public class AccountService implements IAccount {

	@Autowired
	private AccountDAO dao;
	@Autowired
	private CryptMD5 md5;

	@Override
	public boolean addAccount(Accounts accounts) {

		accounts.setPassword(md5.hashMd5(accounts.getPassword()));
		return dao.addAccount(accounts);
	}

	@Override
	public int Login(UserLogin login) {
		return dao.Login(login.getUsername(), md5.hashMd5(login.getPassword()));
	}

	@Override
	public int checkAccount(Accounts accounts) {

		return dao.checkAccount(accounts.getUsername());
	}

	@Override
	public String getUser(String username) {

		return dao.getUser(username);
	}

	@Override
	public Infomations getInfo(String username) {

		return dao.getInfo(username);
	}
	@Override
	public void changPassword(String username, String password) {
		// TODO Auto-generated method stub
		dao.changPassword(username, md5.hashMd5(password));
	}

}
