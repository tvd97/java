package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.products;
import treeshopxml.Entities.Species;

@Service
public interface IHome {
	public List<products> getAllProducts();
	public List<Species> getSpecies();
	public List<products> getSlideProducts();		
	public List<products> getProductPaginate(int start,int end);
	public List<products> newProduct();
	public List<products> rateProduct();
	public List<products> viewProduct();
	public List<products> search(String search);
	
}
