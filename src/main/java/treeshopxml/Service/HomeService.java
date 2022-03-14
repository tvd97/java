package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.*;
import treeshopxml.DTO.*;
import treeshopxml.Entities.Species;
import treeshopxml.Service.Interface.IHome;

@Service
public class HomeService implements IHome {

	@Autowired
	private productsDAO product;

	public List<products> getAllProducts() {
		// TODO Auto-generated method stub
		return product.getAllProducts();
	}

	@Autowired
	private speciesDAO species;

	public List<Species> getSpecies() {
		// TODO Auto-generated method stub
		return species.getListSpecies();
	}

	public List<products> getSlideProducts() {
		// TODO Auto-generated method stub
		return product.getSildeProducts();
	}
	

	public List<products> getProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return product.getProductsPaginate(start, end);
	}@Override
	public List<products> search(String search) {
		// TODO Auto-generated method stub
		return product.search(search);
	}

	@Override
	public List<products> newProduct() {
		// TODO Auto-generated method stub
		return product.newProduct();
	}
	@Override
	public List<products> rateProduct() {
		// TODO Auto-generated method stub
		return product.rateProduct();
	}
	@Override
	public List<products> viewProduct() {
		// TODO Auto-generated method stub
		return product.viewProduct();
	}


}
