package treeshopxml.DAO.Manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.DTO.Manage.ManageMapper;
import treeshopxml.DTO.Manage.OrderById;
import treeshopxml.DTO.Manage.OrderByIdMapper;
import treeshopxml.DTO.Manage.ProductManage;
import treeshopxml.Entities.Accounts;
import treeshopxml.Entities.Farms;
import treeshopxml.Entities.Orders;
import treeshopxml.Entities.Species;
import treeshopxml.Entities.Mapper.AccountMapper;
import treeshopxml.Entities.Mapper.FarmMapper;
import treeshopxml.Entities.Mapper.OrderMapper;

@Repository
public class ManageDAO {
	@Autowired
	JdbcTemplate _JdbcTemplate;

	public List<ProductManage> getAll() {
		String query = "SELECT s.id, s.name, species.name, s.price, s.metaname, s.viewcount, s.promtionPrice, s.img, s.moreimg, s.datecreate, "
				+ "s.characteristic, s.care FROM seedlings as s,species WHERE s.species=species.id ";
		List<ProductManage> list = _JdbcTemplate.query(query, new ManageMapper());
		return list;
	}

	public List<ProductManage> getBySpecies( String species) {
		String query = "SELECT s.id, s.name, species.name, s.price, s.metaname, s.viewcount, s.promtionPrice, s.img, s.moreimg, s.datecreate, s.characteristic, s.care FROM seedlings as s,species WHERE and species.id='" + species + "'";
		List<ProductManage> list = _JdbcTemplate.query(query, new ManageMapper());
		return list;
	}

	public int getIdFarm(String user) {
		String query = "SELECT * from farms where user='" + user + "'";
		Farms list = _JdbcTemplate.queryForObject(query, new FarmMapper());
		return list.getId();
	}

	public String deleteItem(String id) {
		String query = "DELETE FROM seedlings WHERE seedlings.id='" + id + "'";
		try {
			// jdbcTemplate.execute(query);
			return "Xóa thành công";
		} catch (Exception e) {
			// TODO: handle exception
			return "Có lỗi xảy ra ! vui lòng thử lại";
		}
	}

	public List<Orders> getOrderDisable() {
		String query = "SELECT * FROM `orders` WHERE status=0";
		try {
			List<Orders> list = new ArrayList<Orders>();
			list = _JdbcTemplate.query(query, new OrderMapper());
			return list;
		} catch (Exception e) {
			return null;
		}

	}
	public List<OrderById> getOrderById(int id) {
		String query = "SELECT detailorders.id, detailorders.orderid, seedlings.name, detailorders.count, detailorders.totalprice FROM "
				+ "detailorders,seedlings WHERE detailorders.orderid="+id+" AND seedlings.id=detailorders.seedling";
		try {
			List<OrderById> list = new ArrayList<OrderById>();
			list = _JdbcTemplate.query(query, new OrderByIdMapper());
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}

	public void accept(int id) {
		// TODO Auto-generated method stub
		try {
			_JdbcTemplate.execute("UPDATE `orders` SET status=1 WHERE id="+id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void reject(int id) {
		// TODO Auto-generated method stub
		try {
			_JdbcTemplate.execute("UPDATE `orders` SET status=-1 WHERE id="+id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void addSpecies(String id, String name) {
		// TODO Auto-generated method stub
		_JdbcTemplate.execute("INSERT INTO `species`(`id`, `name`, `metaname`) VALUES ('"+id+"',N'"+name+"',''");
	}

	public List<Accounts> getListAccount() {
		// TODO Auto-generated method stub
		List<Accounts> list= new ArrayList<Accounts>();
		try {
			list= _JdbcTemplate.query("select * from accounts", new AccountMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
