package treeshopxml.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.DTO.CartProduct;
import treeshopxml.DTO.Mapper.CartProductMapper;
import treeshopxml.Entities.Carts;
import treeshopxml.Entities.Orders;
import treeshopxml.Entities.detailOrders;
import treeshopxml.Entities.Mapper.CartMapper;
import treeshopxml.Entities.Mapper.OrderMapper;
import treeshopxml.Entities.Mapper.detailOrderMapper;

@Repository
public class CartDAO {
	@Autowired
	JdbcTemplate _JdbcTemplate;

	public void addCart(String user) {
		String query = "INSERT INTO `carts`(`id`, `user`) VALUES (null,'" + user + "')";
		try {
			_JdbcTemplate.execute(query);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addProduct(String id, int cart) {
		String query = "INSERT INTO `detailcarts`(`id`, `cart`, `seedling`, `count`, `status`) VALUES (null," + cart
				+ ",'" + id + "',1,0)";

		_JdbcTemplate.execute(query);

	}

	public void deleteCart(int id) {

		String query = "DELETE FROM detailcarts WHERE id=" + id;
		try {
			_JdbcTemplate.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void editCart(int count, int id) {
		String query;
		if (count == 0) {
			query = "DELETE FROM `detailcarts` WHERE id=" + id;
		} else {
			query = "UPDATE detailcarts SET count=" + count + " WHERE detailcarts.id=" + id;
		}

		_JdbcTemplate.execute(query);
	}

	public int checkCart(String user) {

		String query = "select * from carts where user='" + user + "'";
		List<Carts> list = _JdbcTemplate.query(query, new CartMapper());
		if (list.size() > 0) {
			return 1;
		}
		return 0;
	}

	public List<CartProduct> getCart(String user) {

		String query = "SELECT detailcarts.id,seedlings.name,seedlings.price,detailcarts.count, detailcarts.count* seedlings.price as total ,"
				+ "detailcarts.status,seedlings.img,seedlings.id FROM detailcarts,carts,infomations,seedlings WHERE detailcarts.cart=carts.id "
				+ "AND carts.user=infomations.id AND seedlings.id=detailcarts.seedling  and detailcarts.status=0 AND infomations.username='"
				+ user + "'";
		List<CartProduct> list = new ArrayList<CartProduct>();
		try {
			list = _JdbcTemplate.query(query, new CartProductMapper());
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	public int getId(String user) {
		String query = "select * from carts where user='" + user + "'";
		Carts carts = _JdbcTemplate.queryForObject(query, new CartMapper());
		return (Integer) carts.getId();
	}

	public List<Orders> getHistory(String user) {
		List<Orders> list = new ArrayList<Orders>();
		String query = "SELECT * FROM `orders` WHERE  user='" + user + "'";
		try {
			list = _JdbcTemplate.query(query, new OrderMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public Orders getHistoryById(int id) {
		Orders list = new Orders();
		String query = "SELECT * FROM `orders` where id=" + id ;
		try {
			list = _JdbcTemplate.queryForObject(query, new OrderMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public List<detailOrders> getHistoryItems(int id) {
		// TODO Auto-generated method stub
		List<detailOrders> list;
		String query = "SELECT detailorders.id, `orderid`, seedlings.name, `count`, `totalprice` FROM detailorders,seedlings WHERE seedlings.id=detailorders.seedling and orderid="
				+ id;
		try {
			list = _JdbcTemplate.query(query, new detailOrderMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public void addBillData(Orders orders, List<detailOrders> detail) {
		// TODO Auto-generated method stub

		Orders od = _JdbcTemplate.queryForObject("SELECT * FROM `orders` ORDER BY id DESC LIMIT 1", new OrderMapper());
		orders.setId(od.getId() + 1);
		String query = "INSERT INTO orders(id,name,date,status,address,phone,note,user,payments) VALUES("
				+ orders.getId() + ",N'" + orders.getName() + "'," + "'" + orders.getDate() + "',0,N'"
				+ orders.getAddr() + "','" + orders.getPhone() + "',N'" + orders.getNote() + "','" + orders.getUser()
				+ "',0)";
		String query2 = "INSERT INTO `detailorders`(`id`, `orderid`, `seedling`, `count`, `totalprice`) VALUES";
		for (detailOrders item : detail) {
			query2 += "(null," + (od.getId() + 1) + ",'" + item.getSeedling() + "'," + item.getCount() + ","
					+ item.getTotalPrice() + "),";
		}
		String exe = query2.substring(0, query2.length() - 1);
		
			_JdbcTemplate.execute(query);
			_JdbcTemplate.execute(exe);
		
	}

	public void canclebill(int id) {
		// TODO Auto-generated method stub
		String query="UPDATE orders SET status=-2 WHERE id="+id;
		try {
			_JdbcTemplate.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

}
