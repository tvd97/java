package treeshopxml.Service.Interface;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.UserLogin;
import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Infomations;
@Service
public interface IAccount {
	public void changPassword(String username, String passwork);
	public boolean addAccount(Accounts accounts);
	public int checkAccount(Accounts accounts);
	public int Login(UserLogin login);
	public String getUser(String username);
	public Infomations getInfo(String username);
	
}
