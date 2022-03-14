package treeshopxml.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.Paginations;
import treeshopxml.DTO.UserLogin;
import treeshopxml.DTO.products;
import treeshopxml.Entities.Accounts;
import treeshopxml.Service.PaginationService;

@Controller(value = "user")
public class HomeController extends BaseController {
	@Autowired
	private PaginationService paginationService;
	@Autowired
	private Paginations paginations;

	@RequestMapping(value = { "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		shared.setViewName("home/index");
		shared.addObject("newproduct",service.newProduct());
		shared.addObject("rateproduct",service.rateProduct());
		shared.addObject("viewproduct",service.viewProduct());
		return shared;
	}
	@RequestMapping(value = { "/tim-kiem" }, method = RequestMethod.GET)
	public @ResponseBody List<products> search(@RequestParam("search") String search) {
		List<products>list = new ArrayList<products>(); 
		list=service.search(search);
		return list;
	}
	@RequestMapping(value = { "/dang-nhap" }, method = RequestMethod.GET)
	public ModelAndView Login() {

		shared.setViewName("home/login");
		shared.addObject("userregister", new Accounts());
		shared.addObject("userlogin", new UserLogin());
		return shared;
	}

}
