package treeshopxml.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import treeshopxml.DTO.Paginations;
import treeshopxml.DTO.products;

@Service
public interface IPaginations {
	public Paginations paginations(int data, int current, int limit);	
	public List<products> getProductPaginate(int start, int end);
}
