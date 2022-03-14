package treeshopxml.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "admin")
public class HomeController  {

	@RequestMapping(value = {"/admin/home"},method = RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView  view= new ModelAndView("admin/index");
		return view;
	}
}
