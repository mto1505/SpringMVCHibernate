/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.JUnitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.springmvchibernate.Config.MvcConfig;
import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.GioHangDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;

import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHangPK;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.GioHang;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.ChiTietGioHangRepository;
import com.mycompany.springmvchibernate.Repositories.ChiTietSanPhamRepository;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
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
@Component
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context/applicationContext.xml","classpath:applicationContext-persistence-test.xml"})
@ActiveProfiles(profiles = "prod")
@PropertySource("classpath:application.properties")
public class TestJacksonUnitTest {
	@Value("${email}")
	private String active;
	
	//@Autowired
	ChiTietGioHangService chiTietGioHangService;
	KhachHangConvertTest khachHangConvert = new KhachHangConvertTest();
	
	ChiTietGioHangConvert chiTietGioHangConvert=new ChiTietGioHangConvert();
	//@Autowired
	ICTSanPhamService ctSanPhamService;
	//@Autowired
	SanPhamConvert sanPhamConvert;
	//@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	SanPhamRepository sanPhamRepository;
	//@Autowired
	ChiTietSanPhamRepository ctSanPhamRepository;
	@Autowired
	ChiTietGioHangRepository ctGioHangRepository;
	@PersistenceContext
	private EntityManager em;
	
	 @Autowired
	 ModelMapper modelMapper;
	 
	// @Test
	 public void testSanPhamBanChay()
	 {
		List listResult= sanPhamRepository.findBySellMore(5);
		System.out.println("Danh sach san pham:"+listResult.toString());
		assertEquals(11,listResult.size());
	 }
	 
	 @Test 
	 @Transactional
	@Rollback(false)  
	 public void xoaSanPhamCuaGioHang() {
		GioHang gioHang=em.find(GioHang.class,1);
		List<ChiTietGioHang> ctghs=gioHang.getChiTietGioHangs();
		gioHang.getChiTietGioHangs().remove(0);
		em.persist(gioHang);
		 em.flush();
	   /* TypedQuery<GioHang> q=em.createQuery(""
	    		+ "select distinct s from GioHang s  join fetch  s.chiTietGioHangs where id=:id",GioHang.class).setParameter("id", 1);
	    
	    List<GioHang> sanPhamDTOs=q.getResultList();
	    System.out.println("so luong gio hang:"+sanPhamDTOs.size()+ " id giỏ hàng: "+ sanPhamDTOs.get(0).getId());
	    GioHang gioHang=  sanPhamDTOs.get(0);
	    gioHang.getChiTietGioHangs().remove(0);
	    for (Iterator iterator = sanPhamDTOs.iterator(); iterator.hasNext();) {
	    	GioHang sanPhamDTO = (GioHang) iterator.next();
	   
			System.out.println("so luong san pham trong gio hang"+sanPhamDTO.getChiTietGioHangs().size());
			System.out.println("so luong san pham trong gio hang"+sanPhamDTO.getChiTietGioHangs().get(0).getChiTietSanPham().getSanPham().getTen());
			
		}
	    em.persist(gioHang);
	    em.flush();*/
	    
		//ctghs.remove(index)
		 
	 }
	// @Test
	 public void testChiTietGioHangConvert()
	 {
		/* List<ChiTietGioHangDTO> chiTietGioHangList=chiTietGioHangService.findByidIdGh(1);
			HashMap<String,ChiTietGioHangDTO> mapItems=(HashMap<String, ChiTietGioHangDTO>) chiTietGioHangList.stream().collect(Collectors.toMap(ChiTietGioHangDTO::getIdIdCtsp,Function.identity()));
			 Assert.assertNotNull(mapItems);*/
			/* modelMapper.getConfiguration()
         .setPropertyCondition(context -> 
               (!(context.getSource() instanceof PersistentCollection)||((PersistentCollection)context.getSource()).wasInitialized())
          ); 
		 List<ChiTietGioHang> chiTietGioHangs=ctGioHangRepository.findByidIdGh(1);
		 Assert.assertNotNull(chiTietGioHangs);
		 Assert.assertNotNull(chiTietGioHangConvert);
		 
		 ArrayList<ChiTietGioHangDTO> listChiTietGioHang = modelMapper.map(chiTietGioHangs, new TypeToken<List<ChiTietGioHangDTO>>() {
	        }.getType());
		//List<ChiTietGioHangDTO> chiTietGioHangDTOs=chiTietGioHangConvert.toDTOs(chiTietGioHangs);
		 Assert.assertNotNull(listChiTietGioHang);
		 System.out.println(listChiTietGioHang.get(0).getIdIdCtsp());
		 System.out.println(listChiTietGioHang.get(0).getChiTietSanPham().getId());*/
	 }
	 
	// @Test
	public void findByTenLoaiAndFetchChiTiet()
		{	
			Assert.assertNotNull(sanPhamRepository);
			String tenLoai="Iphone";
			List<SanPham> sanPham=sanPhamRepository.findByTenLoaiAndFetchChiTiet(tenLoai);
			Assert.assertNotNull(sanPham.get(0).getHinhAnhSps());
			Assert.assertNotNull(sanPham);
			System.out.println(sanPham.get(0).getHinhAnhSps().get(0).getHinhAnh());
			System.out.println(sanPham.size());
			System.out.println(sanPham.get(0).getChiTietSanPhams().size());
		
		//	System.out.println(sanPham.get(0).getChiTietSanPhams().get(0).getDonGia());
		}
	// @Test
	 public void testFindCTSPBySanPham()
	 {

		 List<ChiTietSanPhamDTO> list=ctSanPhamService.findAllByIdSanPham(1008);
		 assertNotNull(list);
		 System.out.println(list.size());
		 System.out.println(list.get(0).getSanPham().getManHinh());
	 }
	 
	//@Test
	public void testFindAllSanPham()
	{
		List<SanPham> sanPhams=sanPhamRepository.findAllAndFetchChiTiet();
		assertNotNull(sanPhams);
		System.out.println(sanPhams.get(0).getChiTietSanPhams().get(0).getBoNho().getDungLuong());
		List<SanPhamDTO> listDTO=sanPhamConvert.toDTOs(sanPhams);
		
		assertNotNull(listDTO);
	
		System.out.println("Gía chi tiêt san phẩm "+listDTO.get(0).getChiTietSanPhams().get(0).getDonGia());
		
	}
	 
	//@Test
	public void testFindSanPhamDTO()
	{
		List<SanPham> listSp=sanPhamRepository.findAll();
		List<SanPhamDTO> sanPhamDTOs=sanPhamService.findAll();
		System.out.println(listSp.get(0).getLoai().getTen());
		System.out.println(sanPhamDTOs.get(0).getLoai().getTen());
		assertNotNull(sanPhamDTOs);
	}
	 
	//@Test
	public void test() {
		/*System.out.println("hello unit test");
		List<SanPham> sanPhams=transactionManager.createQuery("select * from San_Pham").getResultList();
		assertEquals(sanPhams.get(1).getLoai().getId(), "ip");*/
	}
    public TestJacksonUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    	

    }  
   public Properties loadPropertiesFile(String filePath) {
    	
        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
          
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of whenDeserializeDateWithJackSon method, of class TestJacksonUnit.
     */
   @Test
    public void loadFile() 
    { 	
    	TestJacksonUnitTest app=new TestJacksonUnitTest();
    	Properties prop = app.loadPropertiesFile("test.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println(active);
    }
   // @Test
    public void testWhenDeserializeDateWithJackSon() throws Exception {
//        System.out.println("whenDeserializeDateWithJackSon");
//        TestJacksonUnit instance = new TestJacksonUnit();
//        instance.whenDeserializeDateWithJackSon();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");


//        List<KhachHangDTO> listKhachHangDTO = new ArrayList<>();
//        listKhachHangDTO.add(new KhachHangDTO(1, "Minh", "0939444000", "Nam", new Date()));
//        when(khachHangService.findAll()).thenReturn(listKhachHangDTO);
//        List<KhachHangDTO> result = khachHangConvert.findAllKhachHangDTO();
//
//        assertEquals(result.size(), 1);

         String json = "{\"id\":\"1\",\"ten\":\"MinhTo\",\"sdt\":\"093939323\",\"gioitinh\":\"Nam\",\"ngaySinh\":\"2000-01-30\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        KhachHangDTO2 khachHangDTO = objectMapper.readerFor(KhachHangDTO2.class).readValue(json);
        System.out.println("Khach DTO "+ df.format(khachHangDTO.getNgaySinh()));
        Assert.assertEquals("30-01-2000", df.format(khachHangDTO.getNgaySinh()));
     

//        KhachHang khachHang = khachHangConvert.toEntity(khachHangDTO);
//        System.out.println("Khach Hang Teen= " + khachHang.getTen());

        //Assert.assertEquals("15-04-2000", df.format(khachHang.getNgaySinh()));
    }
    
 //   @Test
    public void testConvertJsonToEntity() throws IOException
    {
    /*	String json="{\"bienSo\":\"13123213\",\"tenXe\":\"sh mode\",\"khachHang\":{\"ten\":\"BuiMinhTo\"},\"loaiXe\":{\"tenLoai\":\"SH\"}}";
    	  ObjectMapper objectMapper = new ObjectMapper();
    	XeMayDTO2 xeMayDTO=objectMapper.readerFor(XeMayDTO2.class).readValue(json);
    				
    	System.out.println("bienSo"+xeMayDTO.getBienSo());
    	System.out.println("tenXe"+xeMayDTO.getTenXe());
    	System.out.println("tenKhachHang"+xeMayDTO.getKhachHang().getTen());
    	System.out.println("tenLoaiXe"+xeMayDTO.getLoaiXe().getTenLoai());
    	Assert.assertEquals(xeMayDTO.getLoaiXe().getTenLoai(), "SH");
    		*/
    	
    }
    
 // @Test 
    public void findSanPham() {
 
    TypedQuery<SanPhamDTO> q=em.createQuery(""
    		+ "select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.id,s.cameraSau,s.cameraTruoc,s.manHinh,s.moTa,s.name,s.pinSac,s.sim,s.loai"
    		+ ")  from SanPham s join  s.chiTietSanPhams",SanPhamDTO.class);
    List<SanPhamDTO> sanPhamDTOs=q.getResultList();
    
    for (Iterator iterator = sanPhamDTOs.iterator(); iterator.hasNext();) {
		SanPhamDTO sanPhamDTO = (SanPhamDTO) iterator.next();
		System.out.println(sanPhamDTO.getChiTietSanPhams());
		System.out.println(sanPhamDTO.getLoai().getTen());
	}
    /*	TypedQuery<SanPham> q=em.createQuery("from SanPham s",SanPham.class);
        List<SanPham> sanPhamDTOs=q.getResultList();
        for (Iterator iterator = sanPhamDTOs.iterator(); iterator.hasNext();) {
    		SanPham sanPhamDTO = (SanPham) iterator.next();
    		//System.out.println(sanPhamDTO.getChiTietSanPhams());
    		System.out.println(sanPhamDTO.getLoai().getName());*/
  
    }
    
    @Transactional
    @Rollback(false)
    //@Test
    public void insertSanPhamTest() throws IOException
    {
    	/*String json="\"id\":\"ipmax\","
    			+ "\"manHinh\":\"amoledSupper\","
    			+"\"ten\":\"iphone 19\","
    			+"\"sim\":\"khong co sim\","
    			+"\"loai\":"
    			+ "	{\"id\":\"ip\"},"
    			+ "\"chiTietSanPham\":"
    			+ 	"{\"donGia\":\"100000\","
    			+ 	"\"soLuong\":\"10\","
    			+ 	"\"boNho\":"
    			+ 		"{\"id\":\"1\"},"
    			+ 	"\"chip\":"
    			+ "		{\"id\":\"1\"},"
    			+   "\"mau\":"
    			+ 		"{\"id\":\"1\"}"	
    		
    			+ 	"}";*/
    	
    	String json="{\"id\":\"iphonecC4X\",\"manHinh\":\"amoledSupper\",\"name\":\"iphone 19\",\"sim\":\"khong co sim\",\"loai\":{\"id\":\"ip\"},\"chiTietSanPhams\":[{\"donGia\":\"100000\",\"soLuong\":\"10\",\"boNho\":{\"id\":\"1\"},\"chip\":{\"id\":\"1\"},\"mau\":{\"id\":\"1\"}},{\"donGia\":\"100000\",\"soLuong\":\"10\",\"boNho\":{\"id\":\"1\"},\"chip\":{\"id\":\"1\"},\"mau\":{\"id\":\"1\"}}]}";
    			
    	ObjectMapper objectMapper=new ObjectMapper();
    	
    	SanPhamDTO sanPhamDTO=objectMapper.readerFor(SanPhamDTO.class).readValue(json);
    	System.out.println(sanPhamDTO.getChiTietSanPhams().size());
    	
    /*	
    	SanPham sanPham=modelMapper.map(sanPhamDTO, SanPham.class);
    	//ChiTietSanPham chiTietSanPham=modelMapper.map(sanPhamDTO.getChiTietSanPhams(),ChiTietSanPham.class);
    	em.persist(sanPham);
   
    	assertEquals(2, sanPham.getChiTietSanPhams().size());
    	
    	//em.persist(sanPham);
    	
    	List<ChiTietSanPhamDTO> liChiTietSanPhamDTOs=sanPhamDTO.getChiTietSanPhams();
    	for (Iterator iterator = liChiTietSanPhamDTOs.iterator(); iterator.hasNext();) {
			ChiTietSanPhamDTO chiTietSanPhamDTO = (ChiTietSanPhamDTO) iterator.next();
			chiTietSanPhamDTO.setSanPham(sanPhamDTO);
			ChiTietSanPham chiTietSanPham=modelMapper.map(chiTietSanPhamDTO,ChiTietSanPham.class);	
			System.out.println(chiTietSanPham.getSanPham().getId());
			//chiTietSanPham.setSanPham(sanPham);
			em.persist(chiTietSanPham);
    	}
    	
    	
    	System.out.println(sanPham.getId());
    	System.out.println(sanPham.getManHinh());
    	System.out.println(sanPham.getSim());
    	System.out.println(sanPham.getTen());
    	System.out.println(sanPham.getLoai().getId());
    	System.out.println(sanPham.getChiTietSanPhams().get(0).getBoNho().getId());*/

    
    	/*private String id;

    	private BigDecimal donGia;

    	private int soLuong;

    	private BoNhoDTO boNho;

    	private ChipDTO chip;

    	private MauDTO mau;

    	private RamDTO ram;

    	private SanPhamDTO sanPham;
*/
    }


}
