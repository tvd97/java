package treeshopxml.Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.UserLogin;
import treeshopxml.DTO.Manage.ProductManage;
import treeshopxml.Entities.Seedlings;
import treeshopxml.Service.AccountService;
import treeshopxml.Service.FarmService;
import treeshopxml.Service.ManageService;
import treeshopxml.Service.ProductService;

@Controller
@RequestMapping(value = { "/quan-ly/" })
public class ManageController extends BaseController {
	@Autowired
	ManageService service;
	@Autowired
	AccountService accountService;
	@Autowired
	FarmService service2;
	@Autowired
	ProductService service3;
	@Autowired
	UserLogin login;

	@RequestMapping(value = { "/san-pham/tat-ca", "/" })
	public ModelAndView Index(HttpSession session) {

		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
		if (login.getUsername().equals("admin")) {
			List<ProductManage> data = service.getAll();
			shared.addObject("data", data);

			shared.setViewName("/manage/index");

		} else {
			shared.setViewName("403");
		}
		}else {
			shared.setViewName("redirect:dang-nhap");
		}
		return shared;

	}

	@RequestMapping(value = "/san-pham/xoa")
	public ModelAndView Delete(@RequestParam("id") String id, HttpServletRequest request, HttpSession session,
			ModelMap map) {
		if (login.getUsername().equals("admin")) {
			String message = service.deleteItem(id);
			shared.addObject("mess", message);
			shared.setViewName("redirect:" + request.getHeader("referer"));
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@RequestMapping(value = "/san-pham/chinh-sua")
	public ModelAndView Edit(@RequestParam("id") String id, HttpServletRequest request, HttpSession session,
			ModelMap map) {
		if (login.getUsername().equals("admin")) {
			shared.addObject("edit", new Seedlings());
			shared.setViewName("/manage/edit");
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@PostMapping
	@RequestMapping(value = "/san-pham/chinh-sua", method = RequestMethod.POST)
	public ModelAndView Edit(@ModelAttribute("edit") Seedlings seedlings, HttpSession session) {
		shared.addObject("edit", new Seedlings());
		shared.setViewName("/manage/edit");
		return shared;
	}

	@RequestMapping(value = "/tai-khoan")
	public ModelAndView Account(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (login.getUsername().equals("admin")) {
			shared.setViewName("/manage/account");
			shared.addObject("account",service.getListAccount());
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@RequestMapping(value = "/danh-muc")
	public ModelAndView category(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (login.getUsername().equals("admin")) {
			shared.setViewName("/manage/category");
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@GetMapping(value = "/them")
	public ModelAndView additem(HttpSession session) {
		if (login.getUsername().equals("admin")) {
			shared.setViewName("/manage/additem");
			shared.addObject("model", new Seedlings());
			shared.addObject("farm", service2.getAllFarm());
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@Autowired
	ServletContext context;

	@PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView add(@ModelAttribute("model") Seedlings model, HttpSession session, BindingResult result) {
		if (!model.getImage().isEmpty() || model.getMoreImage().length < 0) {
			String path = context.getRealPath(File.separator + "WEB-INF" + File.separator + "content" + File.separator
					+ "image" + File.separator + model.getImage().getOriginalFilename());
			String moreimg = "";
			try {
				if (!new File(path).exists()) {
					model.getImage().transferTo(new File(path));
				}

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (MultipartFile file : model.getMoreImage()) {
				if (!file.isEmpty()) {
					String mpath = context.getRealPath(File.separator + "WEB-INF" + File.separator + "content"
							+ File.separator + "image" + File.separator + file.getOriginalFilename());
					try {
						file.transferTo(new File(mpath));
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					moreimg += file.getOriginalFilename() + ",";
				}
			}
			model.setId(service3.getId());
			model.setImg(model.getImage().getOriginalFilename());
			model.setMoreImg(moreimg);
			model.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}

		shared.setViewName("redirect:/quan-ly/san-pham/tat-ca");
		return shared;
	}

	@RequestMapping(value = "/don-hang/chua-duyet")
	public ModelAndView listbill(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (login.getUsername().equals("admin")) {
			shared.setViewName("/manage/listbill");
			shared.addObject("data", service.getOrderDisable());
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@RequestMapping(value = "/don-hang/chi-tiet")
	public ModelAndView listbill(@RequestParam("id") int id, HttpSession session, ModelMap map) {
		if (login.getUsername().equals("admin")) {
			shared.setViewName("/manage/itembill");
			shared.addObject("data", service.getOrderById(id));
			shared.addObject("id", id);
		} else {
			shared.setViewName("403");
		}
		return shared;
	}

	@GetMapping("/don-hang/nhan-don")
	public String accept(@RequestParam("id") int id) {
		service.accept(id);
		return "redirect:/quan-ly/don-hang/chua-duyet";
	}

	@GetMapping("/don-hang/huy-don")
	public String reject(@RequestParam("id") int id) {
		service.reject(id);
		return "redirect:/quan-ly/don-hang/chua-duyet";
	}

}
