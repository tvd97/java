package treeshopxml.Controller;

import javax.persistence.SharedCacheMode;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.UserLogin;
import treeshopxml.Entities.Accounts;
import treeshopxml.Service.AccountService;

@Controller
public class LoginController extends BaseController {
	@Autowired
	private AccountService service;
	@Autowired
	UserLogin userlogin;

	@RequestMapping(value = { "/dang-nhap" }, method = RequestMethod.POST)
	public @ResponseBody ModelAndView Login(@ModelAttribute("userlogin") UserLogin user, HttpSession session) {
		int status = service.Login(user);
		if (1 == status) {
			session.setAttribute("login", userlogin = user);
			session.setMaxInactiveInterval(60 * 10);
			if (user.getUsername() == "admin") {
				shared.setViewName("redirect:/quan-ly/");
			} else
				shared.setViewName("redirect:/trang-chu");
		} else {
			shared.setViewName("home/login");
			shared.addObject("userregister", new Accounts());
			shared.addObject("userlogin", new UserLogin());
			shared.addObject("errorLogin", "Sai toàn khoản hoặc mật khẩu");
		}
		return shared;

	}

	@RequestMapping(value = { "/dang-ky" }, method = RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("userregister") Accounts accounts, HttpSession session) {
		accounts.setStatus(1);
		int test = service.checkAccount(accounts);
		if (1 == test) {

			if (service.addAccount(accounts) == true) {
				userlogin.setUsername(accounts.getUsername());
				userlogin.setPassword(accounts.getPassword());
				shared.setViewName("/account/edit");
				session.setAttribute("login", userlogin);
			}

			else {

				shared.addObject("error", "Đăng ký không thành công");
				shared.setViewName("home/login");
			}
		} else {
			shared.setViewName("redirect:/dang-nhap");
			shared.addObject("error", "Tài khoản đã tồn tại");
		}
		return shared;
	}

	@RequestMapping(value = "/dang-xuat")
	public ModelAndView Logout(HttpSession session) {
		session.removeAttribute("login");
		session.removeAttribute("cCart");

		return new ModelAndView("redirect:/dang-nhap");
	}
}
