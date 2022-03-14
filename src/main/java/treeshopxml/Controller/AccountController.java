package treeshopxml.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.UserLogin;
import treeshopxml.Service.AccountService;

@Controller
public class AccountController extends BaseController {
	@Autowired
	AccountService service;
	@Autowired
	UserLogin login;

	@RequestMapping(value = { "/tai-khoan" })
	public ModelAndView index(HttpSession session) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			shared.setViewName("/account/index");
			shared.addObject("info", service.getInfo(login.getUsername()));
			return shared;
		} else {
			return new ModelAndView("redirect:/dang-nhap");
		}

	}
	@RequestMapping(value = { "/tai-khoan/chinh-sua" })
	public ModelAndView edit(HttpSession session) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			shared.setViewName("/account/edit");
			shared.addObject("info", service.getInfo(login.getUsername()));
			return shared;
		} else {
			return new ModelAndView("redirect:/dang-nhap");
		}

	}
	@RequestMapping(value = { "/doi-mat-khau" }, method = RequestMethod.POST)
	public @ResponseBody String changPass(HttpSession session, HttpServletRequest request) {
		String oldpass = request.getParameter("oldpass");
		
		String newpass = request.getParameter("newpass");
		login = (UserLogin) session.getAttribute("login");
		if(oldpass.equals(login.getPassword()))
		{
			login.setPassword(newpass);
			service.changPassword(login.getUsername(), login.getPassword());
			return "Đổi thành công";
		}
		else 
		{
			return  "Sai mật khẩu";
		}
		
	}

}
