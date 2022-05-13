package com.mycompany.springmvchibernate.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.UserDetailCustom;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.IChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.IChiTietSanPhamService;
import com.mycompany.springmvchibernate.Service.Impl.ChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.Impl.ChiTietSanPhamService;
import static java.util.function.Function.identity;

@Controller
@RequestMapping("/cart")
public class ControllerCart {

	@Autowired
	IChiTietGioHangService chiTietGioHangService;
	@Autowired
	ICTSanPhamService chiTietSanPhamService;
	@RequestMapping("/add")
	public String addCartItem(@RequestParam(name = "idCTSP") Integer idCTSP,@RequestParam(name = "quality",defaultValue="1") Integer soLuong, HttpSession session) {
		
		UserDetailCustom user =(UserDetailCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//if(user!=null) 
		String idString=idCTSP.toString();
		HashMap<Integer, ChiTietGioHangDTO> cartItems = (HashMap<Integer, ChiTietGioHangDTO>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			//Lay gio hang trong db
			List<ChiTietGioHangDTO> chiTietGioHangList=chiTietGioHangService.findByidIdGh(user.getIdGH());
			HashMap<Integer,ChiTietGioHangDTO> mapItems=(HashMap<Integer, ChiTietGioHangDTO>) chiTietGioHangList.stream().collect(Collectors.toMap(ChiTietGioHangDTO::getIdIdCtsp,Function.identity()));
			cartItems = mapItems;
		}
	
		ChiTietSanPhamDTO chiTietSanPham = chiTietSanPhamService.findOneById(idCTSP);
		if (chiTietSanPham != null) {
			//chiTietGioHangService.save(chiTietGioHang);
			if (cartItems.containsKey(idCTSP)) {	
				ChiTietGioHangDTO chiTietGioHang = cartItems.get(idCTSP);
				
				chiTietGioHang.setChiTietSanPham(chiTietSanPham);
				chiTietGioHang.setIdIdGh(user.getIdGH());
				chiTietGioHang.setIdIdCtsp(idCTSP);
				chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + soLuong);
				chiTietGioHangService.save(chiTietGioHang);
				cartItems.put(idCTSP, chiTietGioHang);
			}
			else {
				ChiTietGioHangDTO chiTietGioHang =new ChiTietGioHangDTO();
				chiTietGioHang.setSoLuong(soLuong);
				chiTietGioHang.setIdIdGh(user.getIdGH());
				chiTietGioHang.setChiTietSanPham(chiTietSanPham);
				chiTietGioHang.setIdIdCtsp(idCTSP);
				cartItems.put(idCTSP, chiTietGioHang);
				chiTietGioHangService.save(chiTietGioHang);
			}
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartNum", cartItems.size());
		session.setAttribute("myCartTotal", totalPrice(cartItems));
		return "redirect:/home";
		
	}
	/*@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String processDelete(@ModelAttribute("chiTietGioHang") ChiTietGioHangDTO idCtsp,HttpSession session)
	{
		
		UserDetailCustom user =(UserDetailCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//if(user!=null) 
		String idString=idCtsp.toString();
		HashMap<Integer, ChiTietGioHangDTO> cartItems = (HashMap<Integer, ChiTietGioHangDTO>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			//Lay gio hang trong db
			List<ChiTietGioHangDTO> chiTietGioHangList=chiTietGioHangService.findByidIdGh(user.getIdGH());
			HashMap<Integer,ChiTietGioHangDTO> mapItems=(HashMap<Integer, ChiTietGioHangDTO>) chiTietGioHangList.stream().collect(Collectors.toMap(ChiTietGioHangDTO::getIdIdCtsp,Function.identity()));
			cartItems = mapItems;
		}
	
		ChiTietSanPhamDTO chiTietSanPham = chiTietSanPhamService.findOneById(idCtsp.getIdIdCtsp());
		if (chiTietSanPham != null) {
			//chiTietGioHangService.save(chiTietGioHang);
			if (cartItems.containsKey(idCtsp.getIdIdCtsp())) {	
				ChiTietGioHangDTO chiTietGioHang = cartItems.remove(idCtsp.getIdIdCtsp());
				chiTietGioHangService.deleteByIdGhAndIdCtsp(user.getIdGH(), idCtsp.getIdIdCtsp());
				
			}
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartNum", cartItems.size());
		session.setAttribute("myCartTotal", totalPrice(cartItems));
		return "redirect:/home";
		
	}*/
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String processDelete(@RequestParam("idIdCtsp")Integer idCtsp,HttpSession session)
	{
		
		UserDetailCustom user =(UserDetailCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//if(user!=null) 
		
		HashMap<Integer, ChiTietGioHangDTO> cartItems = (HashMap<Integer, ChiTietGioHangDTO>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			//Lay gio hang trong db
			List<ChiTietGioHangDTO> chiTietGioHangList=chiTietGioHangService.findByidIdGh(user.getIdGH());
			HashMap<Integer,ChiTietGioHangDTO> mapItems=(HashMap<Integer, ChiTietGioHangDTO>) chiTietGioHangList.stream().collect(Collectors.toMap(ChiTietGioHangDTO::getIdIdCtsp,Function.identity()));
			cartItems = mapItems;
		}
	
		ChiTietSanPhamDTO chiTietSanPham = chiTietSanPhamService.findOneById(idCtsp);
		if (chiTietSanPham != null) {
			//chiTietGioHangService.save(chiTietGioHang);
			if (cartItems.containsKey(idCtsp)) {	
				 cartItems.remove(idCtsp);
				chiTietGioHangService.deleteByIdGhAndIdCtsp(user.getIdGH(), idCtsp);
			}
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartNum", cartItems.size());
		session.setAttribute("myCartTotal", totalPrice(cartItems));
		return "redirect:/home";
		
	}
		
		
	
	 public double totalPrice(HashMap<Integer, ChiTietGioHangDTO> cartItems) {
	        int count = 0;
	        for (Map.Entry<Integer,ChiTietGioHangDTO> list : cartItems.entrySet()) {
	            count += list.getValue().getChiTietSanPham().getDonGia() * list.getValue().getSoLuong();
	        }
	        return count;
	    }
}
