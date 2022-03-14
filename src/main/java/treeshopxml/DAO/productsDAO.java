package treeshopxml.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import treeshopxml.DTO.products;
import treeshopxml.Entities.*;
import treeshopxml.Entities.Mapper.CommentMapper;
import treeshopxml.Entities.Mapper.SeedlingMapper;
import treeshopxml.DTO.Mapper.productMapper;

@Repository
public class productsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<products> getAllProducts() {
		List<products> list = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname, "
				+ "seedlings.viewcount, seedlings.promtionPrice, seedlings.img, seedlings.moreimg, seedlings.datecreate, "
				+ "seedlings.characteristic,(SELECT AVG(rate)FROM rates WHERE rates.seedling=seedlings.id)as rate FROM "
				+ "seedlings,farms,species WHERE seedlings.species=species.id and seedlings.farm=farms.id";
		try {
			list = jdbcTemplate.query(query, new productMapper());
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	public List<products> getProductsPaginate(int start, int end) {
		List<products> list = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,"
				+ "seedlings.viewcount, seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate, "
				+ "seedlings.characteristic,(SELECT AVG(rate)FROM rates WHERE rates.seedling=seedlings.id)as rate FROM "
				+ "seedlings,farms,species WHERE seedlings.species=species.id and seedlings." + "farm=farms.id  LIMIT "
				+ start + "," + end;
		list = jdbcTemplate.query(query, new productMapper());
		return list;
	}

	public List<products> getSildeProducts() {
		List<products> list = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,"
				+ "seedlings.viewcount, seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,"
				+ "seedlings.characteristic , (SELECT AVG(rate)FROM rates WHERE rates.seedling=seedlings.id)as rate FROM "
				+ "seedlings,farms,species WHERE seedlings.species=species.id and seedlings.farm=farms.id ORDER BY rand() LIMIT 10";
		list = jdbcTemplate.query(query, new productMapper());
		return list;
	}

	public products getProducts(String id) {
		// TODO Auto-generated method stub
		products rs = new products();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,"
				+ "seedlings.viewcount, seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,"
				+ "seedlings.characteristic , (SELECT AVG(rate)FROM rates WHERE rates.seedling=seedlings.id)as rate FROM "
				+ "seedlings,farms,species WHERE seedlings.species=species.id and seedlings.farm=farms.id and seedlings.id='"
				+ id + "'";
		rs = jdbcTemplate.queryForObject(query, new productMapper());
		return rs;
	}

	public List<products> productByCategory(String id) {
		// TODO Auto-generated method stub
		List<products> rs = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,"
				+ "seedlings.viewcount, seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,"
				+ " seedlings.characteristic , (SELECT AVG(rate)FROM rates WHERE rates.seedling=seedlings.id)as rate FROM "
				+ "seedlings,farms,species WHERE seedlings.species=species.id and seedlings.farm=farms.id and species.id='"
				+ id + "'";
		rs = jdbcTemplate.query(query, new productMapper());
		return rs;
	}

	public List<products> newProduct() {
		// TODO Auto-generated method stub
		List<products> rs = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,seedlings.viewcount, "
				+ "seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,seedlings.characteristic , (SELECT AVG(rate)FROM "
				+ "rates WHERE rates.seedling=seedlings.id)as rate FROM seedlings,farms,species WHERE seedlings.species=species.id and "
				+ "seedlings.farm=farms.id ORDER BY seedlings.datecreate DESC LIMIT 12";
		rs = jdbcTemplate.query(query, new productMapper());
		return rs;
	}

	public List<products> rateProduct() {
		// TODO Auto-generated method stub
		List<products> rs = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,seedlings.viewcount, "
				+ "seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,seedlings.characteristic , (SELECT AVG(rate)FROM "
				+ "rates WHERE rates.seedling=seedlings.id)as rate FROM seedlings,farms,species WHERE seedlings.species=species.id and "
				+ "seedlings.farm=farms.id ORDER BY rate DESC LIMIT 12";
		rs = jdbcTemplate.query(query, new productMapper());
		return rs;
	}

	public List<products> viewProduct() {
		// TODO Auto-generated method stub
		List<products> rs = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,seedlings.viewcount, "
				+ "seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,seedlings.characteristic , (SELECT AVG(rate)FROM "
				+ "rates WHERE rates.seedling=seedlings.id)as rate FROM seedlings,farms,species WHERE seedlings.species=species.id and "
				+ "seedlings.farm=farms.id ORDER BY seedlings.viewcount DESC LIMIT 12";
		rs = jdbcTemplate.query(query, new productMapper());
		return rs;
	}

	public void addViewProduct(String id, int count) {
		String query = "UPDATE `seedlings` SET viewcount=" + count + " WHERE id='" + id + "'";
		jdbcTemplate.execute(query);
	}

	public List<products> search(Object search) {
		List<products> list = new ArrayList<products>();
		String query = "SELECT seedlings.id, seedlings.name, species.name, farms.name, seedlings.price,seedlings.metaname,seedlings.viewcount, "
				+ "seedlings.promtionPrice, seedlings.img, seedlings.moreimg,seedlings.datecreate,seedlings.characteristic , (SELECT AVG(rate)FROM "
				+ "rates WHERE rates.seedling=seedlings.id)as rate FROM seedlings,farms,species WHERE seedlings.species=species.id and "
				+ "seedlings.farm=farms.id and seedlings.name LIKE N'%" + search + "%'";
		try {
			list = jdbcTemplate.query(query, new productMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public String getId() {
		Seedlings seedlings = jdbcTemplate.queryForObject("SELECT * FROM `seedlings` ORDER BY id DESC LIMIT 1",
				new SeedlingMapper());
		int id = (Integer.parseInt(seedlings.getId().toString()) + 1);
		return String.valueOf(id);

	}

	public int insertData(Seedlings seedlings) {
		String query = "INSERT INTO `seedlings`(`id`, `name`, `species`, `farm`, `price`, `metaname`, `viewcount`, `promtionPrice`, `img`, "
				+ "`moreimg`, `datecreate`, `characteristic`, `care`) VALUES ('" + seedlings.getId() + "',N'"
				+ seedlings.getName() + "'," + seedlings.getFarm() + "," + seedlings.getPrice() + ","
				+ seedlings.getMetaName() + ",0,null,'" + seedlings.getImg() + "',''" + seedlings.getMoreImg() + "','"
				+ seedlings.getDate() + "',N'" + seedlings.getCharacteristic() + "',N'" + seedlings.getCare() + "')";
		try {
			jdbcTemplate.execute(query);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public List<Comments> getComment(String id) {
		String query = "SELECT * FROM `comments` WHERE seedling='" + id + "'";
		List<Comments> list = new ArrayList<Comments>();
		try {
			list = jdbcTemplate.query(query, new CommentMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public void addComment(Comments comments) {
		// TODO Auto-generated method stub
		String query="INSERT INTO `comments`(`id`, `seedling`, `name`, `content`) VALUES (null,'"+comments.getSeedling()+
				"',N'"+comments.getName()+"',N'"+comments.getContent()+";";
		try {
			jdbcTemplate.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void addRate(Rates rates) {
		// TODO Auto-generated method stub
		String query="INSERT INTO `rates`(`id`, `seedling`, `rate`, `date`, `content`, `name`) VALUES (null,'"+rates.getIdSeedling()+"',"
		+rates.getRate()+",'"+rates.getDate()+"',N'"+rates.getContent()+"','"+rates.getName()+",";
		try {
			jdbcTemplate.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
