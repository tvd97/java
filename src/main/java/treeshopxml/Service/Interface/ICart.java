package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.CartProduct;
import treeshopxml.Entities.Orders;
import treeshopxml.Entities.detailOrders;

@Service
public interface ICart {
	public void addCart(String user);

	public void editCart(int count, int id);

	public int checkCart(String user);

	public List<CartProduct> getCart(String user);

	public void addProduct(String id, int cart);

	public int getId(String user);

	public void deleteProduct(int id);

	public List<Orders> getHistory(String user);

	public List<detailOrders> getHistoryItems(int id);

	public Orders getHistoryById(int id);

	public void addBillData(Orders orders, List<detailOrders> detail);

	public void canclebill(int id);
}
