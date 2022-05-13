/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.JUnitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHangPK;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.ChiTietGioHangRepository;
import com.mycompany.springmvchibernate.Repositories.ChiTietSanPhamRepository;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Convert.ChiTietGioHangConvert;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConvertTest;
import com.mycompany.springmvchibernate.Service.Convert.SanPhamConvert;
import com.mycompany.springmvchibernate.Service.Impl.ChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.Impl.SanPhamService;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.collection.spi.PersistentCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MinhTo
 */
/*@Component
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persistence-test.xml",} )
@ActiveProfiles(profiles = "test")
@PropertySource("classpath:application.properties")*/
public class TestSpringAOPUnitTest {
	@Value("${email}")
	private String active;
	@Autowired
	ChiTietGioHangService chiTietGioHangService;
	KhachHangConvertTest khachHangConvert = new KhachHangConvertTest();
	
	ChiTietGioHangConvert chiTietGioHangConvert=new ChiTietGioHangConvert();
	
	@Autowired
	SanPhamConvert sanPhamConvert;
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	ChiTietSanPhamRepository ctSanPhamRepository;
	@Autowired
	ChiTietGioHangRepository ctGioHangRepository;
	@PersistenceContext
	private EntityManager em;
	
	 @Autowired
	 ModelMapper modelMapper;
	 
	
	public void sanPhamServiceAOP()
	{
		int value =sanPhamService.getTotalItem();
		System.out.println("result in test :"+value);
	}


}
