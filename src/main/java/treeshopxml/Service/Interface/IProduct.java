package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.products;
import treeshopxml.Entities.Comments;
import treeshopxml.Entities.Rates;
import treeshopxml.Entities.Seedlings;

@Service
public interface IProduct {
	public products getProduct(String id);

	public List<products> productByCategory(String id);

	public void addViewProducts(String id, int count);

	public List<Rates> getRateProduct(String id);

	public List<products> allProduct();

	public int insertData(Seedlings seedlings);

	public String getId();

	public List<Comments> getComment(String id);
	public void addRate(Rates rates);
	public void addComment(Comments comments);
}
