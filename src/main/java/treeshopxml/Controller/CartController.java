package treeshopxml.Controller;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.persistence.SharedCacheMode;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import treeshopxml.DTO.CartProduct;
import treeshopxml.DTO.UserLogin;
import treeshopxml.Entities.Orders;
import treeshopxml.Entities.detailOrders;
import treeshopxml.Service.AccountService;
import treeshopxml.Service.CartService;

@Controller
public class CartController extends BaseController {
	@Autowired
	UserLogin login;
	@Autowired
	CartService service;
	@Autowired
	AccountService account;
	@Autowired
	private List<CartProduct> list = null;

	@RequestMapping(value = { "/gio-hang" })
	public ModelAndView cart(HttpSession session) {
		shared.setViewName("/carts/cart");
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			if (account.getUser(login.getUsername()) != null) {
				if (service.checkCart(account.getUser(login.getUsername())) == 1) {
					shared.addObject("carts", service.getCart(login.getUsername()));
					list = service.getCart(login.getUsername());
					session.setAttribute("cCart", service.getCart(login.getUsername()).size());
					session.setMaxInactiveInterval(60 * 10);
				} else {
					service.addCart(account.getUser(login.getUsername()));
				}
				return shared;

			}
			return new ModelAndView("redirect:/tai-khoan");
		}
		return new ModelAndView("redirect:/dang-nhap");
	}

	@RequestMapping(value = { "/them" })
	public ModelAndView addProduct(@RequestParam("id_product") String id, @RequestParam(name = "count") int count,
			HttpSession session,HttpServletRequest request) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			if (account.getUser(login.getUsername()) != null) {
				if (service.checkCart(account.getUser(login.getUsername())) == 1) {
					list = service.getCart(login.getUsername());
					for (int i = 0; i < list.size(); i++) {
						if (!list.get(i).getId_product().equals(id)) {
							if (i == (list.size() - 1))
								service.addProduct(id, service.getId(account.getUser(login.getUsername())));
							continue;
						} else {
							service.editCart((list.get(i).getCount() + 1), list.get(i).getId());
							break;
						}

					}

				} else {
					service.addCart(account.getUser(login.getUsername()));
					service.addProduct(id, service.getId(account.getUser(login.getUsername())));
				}
				return new ModelAndView("redirect:"+request.getHeader("Referer"));

			}
			return new ModelAndView("redirect:/tai-khoan");

		}
		return new ModelAndView("redirect:/dang-nhap");
	}

	@RequestMapping(value = { "/chinh-sua" })
	public ModelAndView edit(@RequestParam("id") int id, @RequestParam("count") int count) {
		service.editCart(count, id);
		return new ModelAndView("redirect:/gio-hang");
	}

	@RequestMapping(value = { "/xoa" })
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session) {
		service.deleteProduct(id);
		return new ModelAndView("redirect:/gio-hang");

	}

	@RequestMapping(value = { "/thanh-toan" }, method = RequestMethod.GET)
	public ModelAndView checkout(HttpSession session, HttpServletRequest request) {
		shared.setViewName("/carts/checkout");
		shared.addObject("bill", new Orders());
		session.setAttribute("billitem", list);
		return shared;
	}

	@RequestMapping(value = { "/sua/order" }, method = RequestMethod.GET)
	public @ResponseBody List<CartProduct> Edit(@RequestParam("index") int index, @RequestParam("count") int count,
			HttpSession session) {
		list.get(index).setCount(count);
		session.setAttribute("end", list);
		return list;
	}

	@RequestMapping(value = { "/xoa/order" }, method = RequestMethod.GET)
	public @ResponseBody List<CartProduct> Delete(@RequestParam("index") int index, HttpSession session) {
		for (CartProduct item : list) {
			if (item.getId() == index) {
				list.remove(item);
			}
		}
		session.setAttribute("end", list);
		return list;
	}

	@RequestMapping(value = { "/hoan-tat-dat-hang" })
	public ModelAndView Success(HttpSession session, @RequestParam("name") String name,
			@RequestParam("address") String address, @RequestParam("phone") String phone,
			@RequestParam("note") String note) {
		shared.setViewName("/carts/finish");
		if (session.getAttribute("end") == null) {
			shared.addObject("order", list);
		} else {
			list = (List<CartProduct>) session.getAttribute("end");
			shared.addObject("order", session.getAttribute("end"));
		}
		Orders orders = new Orders();
		orders.setName(name);
		orders.setAddr(address);
		orders.setPhone(phone);
		orders.setNote(note);
		orders.setPayments(0);
		orders.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
		orders.setUser(account.getUser(login.getUsername()));

		List<detailOrders> detail = new ArrayList<detailOrders>();
		for (CartProduct item : list) {
			detailOrders items = new detailOrders();
			items.setSeedling(item.getId_product());
			items.setCount(item.getCount());
			items.setTotalPrice(item.getCount() * item.getPrice());
			detail.add(items);
		}
		service.addBillData(orders, detail);
		shared.addObject("data", orders);
		return shared;
	}

	@RequestMapping(value = "/lich-sua-mua-hang")
	public ModelAndView history(HttpSession session) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			if (account.getUser(login.getUsername()) != null) {
				shared.setViewName("/carts/history");
				shared.addObject("htr", service.getHistory(account.getUser(login.getUsername())));
				return shared;
			} else {
				shared.setViewName("redirect:/tai-khoan");
				return shared;
			}

		} else {
			shared.setViewName("redirect:/dang-nhap");
			return shared;
		}

	}
	@RequestMapping(value = "/lich-sua-mua-hang/chi-tiet")
	public ModelAndView historyitem(HttpSession session, @RequestParam("id") int id) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			shared.setViewName("/carts/historyitem");
			shared.addObject("htritem", service.getHistoryById(id));
			shared.addObject("itemhtr", service.getHistoryItems(id));
			return shared;
		} else {
			shared.setViewName("redirect:/dang-nhap");
			return shared;
		}

	}
	@RequestMapping(value = "/don-hang/huy")
	public ModelAndView HuyBill(HttpSession session, @RequestParam("id") int id) {
		login = (UserLogin) session.getAttribute("login");
		if (login != null) {
			shared.setViewName("redirect:/lich-sua-mua-hang");
			service.canclebill(id);
			return shared;
		} else {
			shared.setViewName("redirect:/dang-nhap");
			return shared;
		}

	}

}
