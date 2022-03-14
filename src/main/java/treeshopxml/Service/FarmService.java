package treeshopxml.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treeshopxml.DAO.FarmDAO;
import treeshopxml.DTO.*;
import treeshopxml.Entities.Farms;
import treeshopxml.Service.Interface.IFarm;

@Service
public class FarmService implements IFarm {

	@Autowired
	FarmDAO dao;
	@Override
	public List<Farms> getAllFarm() {
		// TODO Auto-generated method stub
		return dao.getAllFarm();
	}
	@Override
	public List<farms> Farm() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
