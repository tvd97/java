package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.*;
import treeshopxml.Entities.Farms;

@Service
public interface IFarm {

	public List<Farms> getAllFarm();
	public List<farms> Farm();
	
}
