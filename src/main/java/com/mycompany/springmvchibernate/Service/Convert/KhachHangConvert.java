/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Convert;

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.LoaiXe;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Service.Impl.KhachHangService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
/*@Component*/
public class KhachHangConvert {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IKhachHangService khachHangService;
    
    public KhachHangDTO toDTO(KhachHang KhachHang) {
        //modelMapper.addConverter(toStringDate);
        KhachHangDTO KhachHangDTO = modelMapper.map(KhachHang, KhachHangDTO.class);

        return KhachHangDTO;
    }

    public KhachHang toEntity(KhachHangDTO KhachHangDTO) {
       
       // modelMapper.addConverter(toStringDate);
       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        KhachHang KhachHang = modelMapper.map(KhachHangDTO, KhachHang.class);
        return KhachHang;
    }

    
    public List<KhachHang> toEntitys(List<KhachHangDTO> KhachHangDTO) {
      //modelMapper.addConverter(toStringDate);
      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        List<KhachHang> KhachHang = modelMapper.map(KhachHangDTO, new TypeToken<List<KhachHang>>() {
        }.getType());
        return KhachHang;
    }

    public List<KhachHangDTO> toDTOs(List<KhachHang> KhachHang) {
       // modelMapper.addConverter(toStringDate);
       
        List<KhachHangDTO> khachHang = modelMapper.map(KhachHang, new TypeToken<List<KhachHangDTO>>() {
        }.getType());
        return khachHang;
    }
    Converter<String, java.util.Date> toStringDate = new AbstractConverter<String, java.util.Date>() {
        @Override
        protected Date convert(String s) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date;
            try {
                date = dateFormat.parse(s);
                return date;
            } catch (ParseException ex) {
                Logger.getLogger(KhachHangConvert.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    };
    Provider<java.util.Date>javaDateProvider = new AbstractProvider<java.util.Date>() {
            @Override
            public java.util.Date get () {
                return new java.util.Date ();
            }
        };
    
    public List<KhachHangDTO> findAllKhachHangDTO()
            {
                return khachHangService.findAll();
            }
}
