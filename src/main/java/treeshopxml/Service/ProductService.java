package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.RateDAO;
import treeshopxml.DAO.productsDAO;
import treeshopxml.DTO.products;
import treeshopxml.Entities.Comments;
import treeshopxml.Entities.Rates;
import treeshopxml.Entities.Seedlings;
import treeshopxml.Service.Interface.IProduct;

@Service
public class ProductService implements IProduct {
	@Autowired
	private productsDAO dao;
	@Autowired
	private RateDAO rate;

	@Override
	public products getProduct(String id) {
		// TODO Auto-generated method stub
		return dao.getProducts(id);
	}
	public List<products> productByCategory(String id) {
		// TODO Auto-generated method stub
		return dao.productByCategory(id);
	}
	@Override
	public List<Rates> getRateProduct(String id) {
		// TODO Auto-generated method stub
		return rate.getRateProduct(id);
	}

	@Override
	public void addViewProducts(String id,int count) {
		// TODO Auto-generated method stub
		dao.addViewProduct(id, count);
	}
	@Override
	public List<products> allProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}
	@Override
	public int insertData(Seedlings seedlings) {
		// TODO Auto-generated method stub
		return dao.insertData(seedlings);
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return dao.getId();
	}
	@Override
	public List<Comments> getComment(String id) {
		// TODO Auto-generated method stub
		return dao.getComment(id);
	}
	@Override
	public void addComment(Comments comments) {
		// TODO Auto-generated method stub
		dao.addComment(comments);
	}
	@Override
	public void addRate(Rates rates) {
		// TODO Auto-generated method stub
		dao.addRate(rates);
	}
}
