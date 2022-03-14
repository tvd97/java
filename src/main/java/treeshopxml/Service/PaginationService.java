package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.productsDAO;
import treeshopxml.DTO.Paginations;
import treeshopxml.DTO.products;
import treeshopxml.Service.Interface.*;
@Service
public class PaginationService implements IPaginations {
	@Autowired
	productsDAO products;
	@Override
	public Paginations paginations(int data, int current, int limit) {
		Paginations page = new Paginations();
		page.setCurrentPage(current);
		page.setLimit(limit);
		page.setTotalPage(setTotalPage(data, limit));
		page.setCurrentPage(checkCurrentPage(current, page.getTotalPage()));
		page.setStart(finsStart(page.getCurrentPage(),limit));
		page.setEnd(findEnd(page.getStart(),limit,data));
		return page;
	}

	

	private int findEnd(int start, int limit, int data) {
		// TODO Auto-generated method stub
		return (start+limit<data)? (start+limit-1):data;
	}



	private int finsStart(int curenPage, int limit) {
		// xac dinh vi tri  bat dau trang
		// TODO Auto-generated method stub
		return (curenPage-1)*limit;
	}

	private int checkCurrentPage(int current, int totalPage) {
		if (current < 1)
			return 1;
		if (current > totalPage)
			return totalPage;
		return current;
	}

	private int setTotalPage(int data, int limit) {
		// TODO Auto-generated method stub
		int page = 0;
		page = data / limit;
		page = (page * limit < data) ? page + 1 : page;
		return page;
	}
	public List<products> getProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return products.getProductsPaginate(start, end);
	}
}
