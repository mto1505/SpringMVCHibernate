package com.mycompany.springmvchibernate.Service;

import java.util.List;

import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.Entity.TaiKhoan;



public interface ITaiKhoanService {
	 
		List<TaiKhoanDTO> findAll();

	    TaiKhoanDTO findOne(String id);

	    public void save(TaiKhoanDTO taiKhoanDTO);
	    
	    public void setActive(TaiKhoan taiKhoan);

	    public void delete(String[] ids);

	    public void delete(String id);

	    public TaiKhoanDTO update(TaiKhoanDTO xe);
	    //  public List<XeMayDTO>findAll(Pageable pageable);
	    public TaiKhoanDTO findOne(String ten,String sdt);

	    public TaiKhoanDTO findOneByUsernameAndActive(String ten,boolean active);
	    public TaiKhoanDTO findOneByKhachHangs_Email(String email);
}
