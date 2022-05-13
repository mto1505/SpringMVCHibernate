package com.mycompany.springmvchibernate.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.DTO.UserDetailCustom;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Service.IChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.IHinhAnh;
import com.mycompany.springmvchibernate.Service.Impl.ChiTietGioHangService;

@Component
public class ShoppingCartHandlerInterceptor implements HandlerInterceptor {
	@Autowired
	IChiTietGioHangService chiTietGioHangService;
	@Autowired
	IHinhAnh hinhAnhService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		UserDetailCustom user=null;
		if(authentication!=null)
		{
			if(authentication.getPrincipal() instanceof UserDetails)
			{
				user = (UserDetailCustom) authentication.getPrincipal();
			}
			
		}
		
		if (user != null) {
			HashMap<Integer, ChiTietGioHangDTO> cartItems = (HashMap<Integer, ChiTietGioHangDTO>) session
					.getAttribute("myCartItems");
			if (cartItems == null) {
				// Lay gio hang trong db
				List<ChiTietGioHangDTO> chiTietGioHangList = chiTietGioHangService.findByidIdGh(user.getIdGH());
				HashMap<Integer, ChiTietGioHangDTO> mapItems = (HashMap<Integer, ChiTietGioHangDTO>) chiTietGioHangList
						.stream().collect(Collectors.toMap(ChiTietGioHangDTO::getIdIdCtsp, Function.identity()));
				cartItems = mapItems;
				for(Map.Entry<Integer,ChiTietGioHangDTO> item:cartItems.entrySet())
				{
					
					ChiTietGioHangDTO value=item.getValue();
					List<HinhAnhSP> hinhAnhs=hinhAnhService.findAllByIdSanPham(value.getChiTietSanPham().getSanPham().getId());
					List<HinhAnhDTO> hinhAnhDTOs=new ArrayList<HinhAnhDTO>();
					for(HinhAnhSP hinhAnh:hinhAnhs)
					{
						hinhAnhDTOs.add(new HinhAnhDTO(hinhAnh.getHinhAnh()));
					}
					value.getChiTietSanPham().getSanPham().setHinhAnhSps(hinhAnhDTOs);
				}
				
				session.setAttribute("myCartItems", cartItems);
				session.setAttribute("myCartNum", cartItems.size());
				session.setAttribute("myCartTotal", totalPrice(cartItems));
			}
		}
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
	public double totalPrice(HashMap<Integer, ChiTietGioHangDTO> cartItems) {
        int count = 0;
        for (Map.Entry<Integer,ChiTietGioHangDTO> list : cartItems.entrySet()) {
            count += list.getValue().getChiTietSanPham().getDonGia() * list.getValue().getSoLuong();
        }
        return count;
    }

}
