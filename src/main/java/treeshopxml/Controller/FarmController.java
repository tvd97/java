package treeshopxml.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.Paginations;
import treeshopxml.Service.FarmService;
import treeshopxml.Service.PaginationService;

@Controller
public class FarmController extends BaseController {

	@Autowired
	private Paginations paginations;
	@Autowired
	private FarmService service;
	@Autowired
	 private PaginationService paginationService;

	@RequestMapping(value = { "/nha-giong" }, method = RequestMethod.GET)
	public ModelAndView farm(@RequestParam(name = "page", required = true) int page,HttpSession session) {
		shared.setViewName("farm/farm");
		paginations = paginationService.paginations(service.getAllFarm().size(), page, 9);
		shared.addObject("page", paginations);
		shared.addObject("farm", service.getAllFarm());
		return shared;
	}
	@RequestMapping(value = { "/nha-giong/thong-tin-nha-vuon" }, method = RequestMethod.GET)
	public ModelAndView detaiFarm(@RequestParam(name="id",required = true) int id,HttpSession session) {
		shared.setViewName("farm/detailFarm");
		return shared;
	}
	
}
