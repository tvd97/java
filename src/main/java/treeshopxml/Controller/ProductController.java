package treeshopxml.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.Paginations;
import treeshopxml.DTO.UserLogin;
import treeshopxml.Entities.Comments;
import treeshopxml.Entities.Rates;
import treeshopxml.Service.PaginationService;
import treeshopxml.Service.ProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	ProductService service;
	@Autowired
	PaginationService paginationService;
	@Autowired
	private Paginations paginations;
	@Autowired
	UserLogin login;

	@RequestMapping(value = { "/san-pham/{id}" }, method = RequestMethod.GET)
	public ModelAndView productbyCategory(@PathVariable String id) {
		if (service.productByCategory(id).size() == 0) {
			shared.setViewName("/home/blank");
		} else {
			shared.addObject("product", service.productByCategory(id));
			shared.setViewName("/home/category");
		}
		return shared;
	}

	@RequestMapping(value = { "/san-pham/tat-ca" }, method = RequestMethod.GET)
	public ModelAndView allProduct(@RequestParam(name = "page", required = false) int page) {
		if (String.valueOf(page) == null)
			page = 1;
		shared.setViewName("/home/category");
		paginations = paginationService.paginations(service.allProduct().size(), page, 15);
		shared.addObject("page", paginations);

		shared.addObject("product",
				paginationService.getProductPaginate(paginations.getStart(), paginations.getLimit()));

		return shared;
	}

	@Autowired
	List<Comments> cmt;
	@Autowired
	List<Rates> rate;

	@RequestMapping(value = { "/san-pham/chi-tiet-san-pham/{id}" }, method = RequestMethod.GET)
	public ModelAndView product(@PathVariable String id) {
		shared.addObject("product", service.getProduct(id));
		rate = service.getRateProduct(id);
		cmt= service.getComment(id);
		shared.addObject("rate", rate);
		shared.addObject("comment", cmt);
		service.addViewProducts(id, service.getProduct(id).getViewCount() + 1);
		shared.setViewName("/home/product");
		return shared;
	}

	@RequestMapping(value = { "/danh-gia" }, method = RequestMethod.GET)
	public @ResponseBody List<Rates> rate(HttpServletRequest request, HttpServletResponse rs) {
		Rates rates = new Rates();
		rates.setName(request.getParameter("name"));
		rates.setIdSeedling(request.getParameter("id_product"));
		rates.setRate(Float.parseFloat(request.getParameter("rate")));
		rates.setContent(request.getParameter("comment"));
		rates.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		service.addRate(rates);
		rate.add(rates);
		return rate;
	}

	@RequestMapping(value = { "/binh-luan" }, method = RequestMethod.GET)
	public @ResponseBody List<Comments> Comment(HttpServletRequest request, HttpServletResponse rs) {
		Comments comments = new Comments();
		comments.setSeedling(request.getParameter("id_product"));
		comments.setContent(request.getParameter("comment"));
		comments.setName(request.getParameter("name"));
		service.addComment(comments);
		cmt.add(comments);
		return cmt;
	}
}
