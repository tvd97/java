package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.Manage.OrderById;
import treeshopxml.DTO.Manage.ProductManage;
import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Orders;

@Service
public interface IManage {
	public List<ProductManage> getBySpecies( String species);

	public List<ProductManage> getAll();

	public List<Orders> getOrderDisable();
	public List<Accounts> getListAccount();
	public void addSpecies(String id, String name);

	public int getIdFarm(String user);

	public String deleteItem(String id);

	public List<OrderById> getOrderById(int id);

	public void accept(int id);

	public void reject(int id);
}
