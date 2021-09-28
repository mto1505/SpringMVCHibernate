/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.JUnitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConvert;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author MinhTo
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml",})
@ActiveProfiles(profiles = "test")
@PropertySource("classpath:application-test.properties")

public class TestJacksonUnit {

  private Logger logger = Logger.getLogger(TestJacksonUnit.class);
   /* KhachHangConvert khachHangConvert = new KhachHangConvert();

    @Autowired
    private IKhachHangService khachHangService;
*/
    @Test
    public void whenDeserializeDateWithJackSon() throws IOException {
        String json = "{\"id\":1,\"ten\":\"MinhTo\",\"sdt\":\"093939323\",\"gioitinh\":\"Nam\",\"ngaySinh\":\"15-04-2000\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        KhachHangDTO khachHangDTO = objectMapper.readerFor(KhachHangDTO.class).readValue(json);
        System.out.println("Khach DTO is " + khachHangDTO.getNgaySinh());

        logger.info("This is an info log entry");
        logger.error("This is an error log entry");

       /* KhachHang khachHang = khachHangConvert.toEntity(khachHangDTO);
        System.out.println("Khach Hang Teen= " + khachHang.getTen());

        Assert.assertEquals("15-04-2000", df.format(khachHang.getNgaySinh()));
*/
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
    @Test
    public void loadFile() 
    { 	
    	TestJacksonUnit app=new TestJacksonUnit();
    	Properties prop = app.loadPropertiesFile("test.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
