package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.CartDAO;
import treeshopxml.DTO.CartProduct;
import treeshopxml.Entities.Orders;
import treeshopxml.Entities.detailOrders;
import treeshopxml.Service.Interface.ICart;

@Service
public class CartService implements ICart {
	@Autowired
	CartDAO dao;

	@Override
	public void addCart(String user) {
		// TODO Auto-generated method stub
		dao.addCart(user);
	}

	@Override
	public void editCart(int count,int id) {
		// TODO Auto-generated method stub
		dao.editCart(count, id);
	}

	@Override
	public int checkCart(String user) {
		// TODO Auto-generated method stub
		return dao.checkCart(user);
	}

	@Override
	public List<CartProduct> getCart(String user) {
		// TODO Auto-generated method stub
		return dao.getCart(user);
	}

	@Override
	public void addProduct(String id, int cart) {
		// TODO Auto-generated method stub
		dao.addProduct(id, cart);
	}
	@Override
	public int getId(String user) {
		// TODO Auto-generated method stub
		return dao.getId(user);
	}
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		dao.deleteCart(id);
	}
	@Override
	public List<Orders> getHistory(String user) {
		// TODO Auto-generated method stub
		return dao.getHistory(user);
	}

	public List<detailOrders> getHistoryItems(int id) {
		// TODO Auto-generated method stub
		return dao.getHistoryItems( id);
	}
	public Orders getHistoryById(int id)
	{
		return dao.getHistoryById(id);
	}
	@Override
	public void addBillData(Orders orders, List<detailOrders> detail) {
		// TODO Auto-generated method stub
		dao.addBillData( orders, detail);
	}
	@Override
	public void canclebill(int id) {
		// TODO Auto-generated method stub
		dao.canclebill( id);
	}

}