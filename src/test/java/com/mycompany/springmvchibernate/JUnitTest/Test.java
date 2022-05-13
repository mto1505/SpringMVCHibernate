package com.mycompany.springmvchibernate.JUnitTest;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Repositories.ChiTietGioHangRepository;

/*@Component
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persistence-test.xml"})
@ActiveProfiles(profiles = "test")
@PropertySource("classpath:application.properties")*/
public class Test {
	
	@Autowired
	ChiTietGioHangRepository ctGioHangRepository;
	
	
		 public void testChiTietGioHangConvert() {
			 List<ChiTietGioHang> chiTietGioHangs=ctGioHangRepository.findByidIdGh(1);
			 System.out.println("chi tiet gio hang"+ chiTietGioHangs.toString());
		 }
	
}
