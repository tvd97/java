package treeshopxml.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import treeshopxml.DTO.Mapper.RoleAccMappper;
import treeshopxml.DTO.Mapper.RoleAccount;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String query = "select accounts.username, accounts.password,roleusers.role from roleusers,accounts where accounts,username='"
				+ username + "'";
		List<RoleAccount> role = jdbcTemplate.query(query, new RoleAccMappper());
		if (role.size() > 0) {
			RoleAccount users = role.get(0);
			List<GrantedAuthority> gran = new ArrayList<GrantedAuthority>();

			GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
			gran.add(authority);

			UserDetails details = new User(username, users.getPassword(), gran);

			return details;
		} else {
			new UserPrincipalNotFoundException("login fail");
		}
		return null;
	}

}
