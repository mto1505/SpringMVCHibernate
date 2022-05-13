package com.mycompany.springmvchibernate.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Service.IDanhMucService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/san-pham")
public class ProductAPI {
	
	@Autowired
	private ISanPhamService sanPhamService; 
	@Autowired
	private IDanhMucService danhMucService;
	
	@GetMapping("/detail")
    public ResponseEntity<List<ChiTietSanPhamDTO>> findAllProductDetail(){
		
		List<Loai> danhMuc=danhMucService.findAll();
		
		List<ChiTietSanPhamDTO> sanPhams=sanPhamService.findBySellMore(1);
		
		return ResponseEntity.ok(sanPhams);
		
	} 
	@GetMapping(value="/{id}")
	public ResponseEntity<List<SanPhamDTO>> findAllProduct(@PathVariable("id") int id){
		List<SanPhamDTO> list=sanPhamService.findSanPhamAndDetail(id);
		return ResponseEntity.ok(list);
	}
}
