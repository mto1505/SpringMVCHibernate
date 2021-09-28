package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO2;

public interface ISanPhamService {
	
		public void save(XeMayDTO2 xe);	
	    public void delete(String [] ids);    
	    public void delete(String id);
	    public XeMayDTO2 update(XeMayDTO2 xe);
	    public List<XeMayDTO>findAll(Pageable pageable);
	    public List<XeMayDTO>findAll();
	    int getTotalItem();
	    XeMayDTO findById(String id);
	    public XeMayDTO2 findOneByBienSo(String bienso);
	    public List<XeMayDTO2> findAllByListBienSoAndTen(List bienSo,String name);
}
