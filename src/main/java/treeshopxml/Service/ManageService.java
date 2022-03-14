package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.Manage.ManageDAO;
import treeshopxml.DTO.Manage.OrderById;
import treeshopxml.DTO.Manage.ProductManage;
import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Orders;
import treeshopxml.Service.Interface.IManage;

@Service
public class ManageService implements IManage {
	@Autowired
	ManageDAO dao;

	@Override
	public List<ProductManage> getBySpecies(String species) {
		// TODO Auto-generated method stub
		return dao.getBySpecies(species);
	}

	@Override
	public List<ProductManage> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public int getIdFarm(String user) {
		// TODO Auto-generated method stub
		return dao.getIdFarm(user);
	}

	@Override
	public String deleteItem(String id) {
		// TODO Auto-generated method stub
		return dao.deleteItem(id);
	}

	@Override
	public List<Orders> getOrderDisable() {
		// TODO Auto-generated method stub
		return dao.getOrderDisable();
	}

	@Override
	public List<OrderById> getOrderById(int id) {
		// TODO Auto-generated method stub
		return dao.getOrderById(id);
	}

	@Override
	public void accept(int id) {
		// TODO Auto-generated method stub
		dao.accept(id);
	}

	@Override
	public void reject(int id) {

		// TODO Auto-generated method stub
		dao.reject(id);
	}
	@Override
	public void addSpecies(String id,String name) {
		// TODO Auto-generated method stub
		dao.addSpecies(id,name);
	}
	@Override
	public List<Accounts> getListAccount() {
		// TODO Auto-generated method stub
		return dao.getListAccount();
	}

}
