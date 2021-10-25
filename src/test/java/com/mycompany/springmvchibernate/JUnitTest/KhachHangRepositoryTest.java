package com.mycompany.springmvchibernate.JUnitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.springmvchibernate.DTO.BoNhoDTO;
import com.mycompany.springmvchibernate.DTO.ChipDTO;
import com.mycompany.springmvchibernate.DTO.MauDTO;
import com.mycompany.springmvchibernate.DTO.RamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Dao.SanPhamDao;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.SanPham;



@Component
@ContextConfiguration(locations = "classpath:applicationContext-persistence-test.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
@Profile("test")
public class KhachHangRepositoryTest {
	
	@Autowired
	private EntityManagerFactory emf;
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SanPhamDao sanPhamDao;
	
	//@Test
	public void testAllSanPham() {
		// TODO Auto-generated method stub

		List<SanPham> listSanPham=em.createQuery("from SanPham").getResultList();
		System.out.println(listSanPham.size());
		System.out.println(listSanPham.get(0).getManHinh());
		System.out.println(listSanPham.get(0).getTen());
	/*	System.out.println(listSanPham.get(0).getChiTietSanPhams());
		List<ChiTietSanPham> listCTSP=(List<ChiTietSanPham>) em.find(SanPham.class,1).getChiTietSanPhams();
		Assert.assertNotEquals(0, listCTSP.size());
		Assert.assertNotNull(listCTSP);*/
		SanPham sp=em.find(SanPham.class,"1");
		 Assert.assertNotNull(sp);
		 Assert.assertNotNull(em);
	/*List<SanPham> listSanPham=em.createQuery("from SanPham").getResultList();
	System.out.println(listSanPham.size());
	Assert.assertEquals(listSanPham.size(), 2);*/
	
	/*System.out.println(listSanPham.get(0).getId());
			System.out.println(listSanPham.get(0).getManHinh());
			System.out.println(listSanPham.get(0).getName());*/
			/*System.out.println(listSanPham.get(0).getChiTietSanPhams());*/
		  // Assert.assertNotNull(listSanPham);
		   
		
		}
    //@Test
 
	public void testFindAllSanPham() {
	   List<SanPham> listSP=sanPhamDao.findAll();
	   Assert.assertNotNull(sanPhamDao);;
	}
   // @Test
    @Transactional(rollbackFor= {Exception.class})
	@Rollback(false)    
    public void insertSanPham()
    {
    	Loai loai2=em.find(Loai.class, "ip");
    	SanPham sp=new SanPham();
    	sp.setId(14);
    	sp.setCameraSau("4 camera sau");
    	sp.setCameraTruoc("1 camera Trước");
    	sp.setManHinh("Supper amoled full screen");
    	sp.setMoTa("Good product in the price range");
    	sp.setPinSac("5000 mah");	
    	sp.setSim("10 sim 10 song");    	
    	sp.setLoai(loai2);
    	
    	HinhAnhSP hinhAnh= new HinhAnhSP();
    	hinhAnh.setHinhAnh("url1/21231");
    	sp.addHinhAnh(hinhAnh);   

    	em.persist(sp);    
    	sp.setTen("iphone 12 promax");
    
    	
    	/*Loai loai=em.find(Loai.class, "ip");
    	
    	loai.setName("nokia");
    	
    	em.refresh(loai);
    	
    	System.out.println("sau khi refresh " +loai.getName());
    	
    	//System.out.println("Lazy loading test"+loai.getSanPhams().size());
    	
    	for(int i=0;i<10;i++)
    	{	
    		Loai loai2=em.find(Loai.class, "ip");
	    	
    		SanPham sp=new SanPham();
	    	sp.setId("ip1338h"+i);
	    	sp.setCameraSau("4 camera sau");
	    	sp.setCameraTruoc("1 camera Trước");
	    	sp.setManHinh("Supper amoled full screen");
	    	sp.setMoTa("Good product in the price range");
	    	sp.setPinSac("5000 mah");	
	    	sp.setSim("10 sim 10 song");    	
	    	//sp.setLoai(loai2);
	    	
	    	HinhAnhSP hinhAnh= em.find(HinhAnhSP.class, 13);
	    	sp.addHinhAnh(hinhAnh);   
	    	loai2.addSanPham(sp);
	    	em.persist(loai2);    
	    	sp.setName("iphone 12 promax");
	    	em.flush();
	    	SanPham sp2=em.find(SanPham.class,"ip1338h"+i);
	    	System.out.println("after flush"+ sp2.getName());
	    	System.out.println("before refresh "+ sp.getName());
	    	em.refresh(sp);
	    	System.out.println("after refresh "+sp.getName());
	    	
	    	try {
	    		int x=1/0;
	    		throw new Exception("rollback when exception occur");
	    	}
	    	catch(Exception e) {
	    		
	    	}
	    	//em.clear();
    	}
 */
    	
    	
    
    	
    }
    
   // @Test 
    public void findSanPham() {
 
   /* TypedQuery<SanPhamDTO> q=em.createQuery(""
    		+ "select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.id,s.cameraSau,s.cameraTruoc,s.manHinh,s.moTa,s.name,s.pinSac,s.sim,s.loai"
    		+ ")  from SanPham s join  s.chiTietSanPhams",SanPhamDTO.class);
    List<SanPhamDTO> sanPhamDTOs=q.getResultList();
    for (Iterator iterator = sanPhamDTOs.iterator(); iterator.hasNext();) {
		SanPhamDTO sanPhamDTO = (SanPhamDTO) iterator.next();
		System.out.println(sanPhamDTO.getChiTietSanPhams());
		System.out.println(sanPhamDTO.getLoai().getTen());*/
	
    /*	TypedQuery<SanPham> q=em.createQuery("from SanPham s",SanPham.class);
        List<SanPham> sanPhamDTOs=q.getResultList();
        for (Iterator iterator = sanPhamDTOs.iterator(); iterator.hasNext();) {
    		SanPham sanPhamDTO = (SanPham) iterator.next();
    		//System.out.println(sanPhamDTO.getChiTietSanPhams());
    		System.out.println(sanPhamDTO.getLoai().getName());*/
  
    }
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
    	String json="{\"id\":\"iphoneczzz\",\"manHinh\":\"amoledSupper\",\"name\":\"iphone 19\",\"sim\":\"khong co sim\",\"loai\":{\"id\":\"ip\"},\"chiTietSanPhams\":[{\"donGia\":\"100000\",\"soLuong\":\"10\",\"boNho\":{\"id\":\"1\"},\"chip\":{\"id\":\"1\"},\"mau\":{\"id\":\"1\"}},{\"donGia\":\"100000\",\"soLuong\":\"10\",\"boNho\":{\"id\":\"1\"},\"chip\":{\"id\":\"1\"},\"mau\":{\"id\":\"1\"}}]}";
    			
    	ObjectMapper objectMapper=new ObjectMapper();
    	
    	SanPhamDTO sanPhamDTO=objectMapper.readerFor(SanPhamDTO.class).readValue(json);
    	System.out.println(sanPhamDTO.getChiTietSanPhams().size());
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
