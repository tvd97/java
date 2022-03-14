package treeshopxml.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.Service.CartService;
import treeshopxml.Service.HomeService;

@Controller
public class BaseController {
	@Autowired
	HomeService service;
	@Autowired
	CartService service2;
	public ModelAndView shared = new ModelAndView("shared/layout");
	@PostConstruct
	public  ModelAndView init()
	{
		shared.addObject("species", service.getSpecies());
		shared.addObject("slides", service.getSlideProducts());
		return shared;
	}
}
