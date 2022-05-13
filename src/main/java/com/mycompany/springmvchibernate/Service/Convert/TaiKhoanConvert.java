package com.mycompany.springmvchibernate.Service.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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


import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;

import com.mycompany.springmvchibernate.Entity.TaiKhoan;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;

@Component
public class TaiKhoanConvert {

    @Autowired
    ModelMapper modelMapper;
  
    
    public TaiKhoanDTO toDTO(TaiKhoan TaiKhoan) {
        //modelMapper.addConverter(toStringDate);
        TaiKhoanDTO TaiKhoanDTO = modelMapper.map(TaiKhoan, TaiKhoanDTO.class);

        return TaiKhoanDTO;
    }

    public TaiKhoan toEntity(TaiKhoanDTO TaiKhoanDTO) {
       
       // modelMapper.addConverter(toStringDate);
       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        TaiKhoan KhachHang = modelMapper.map(TaiKhoanDTO, TaiKhoan.class);
        return KhachHang;
    }

    
    public List<TaiKhoan> toEntitys(List<TaiKhoanDTO> TaiKhoanDTO) {
      //modelMapper.addConverter(toStringDate);
      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        List<TaiKhoan> KhachHang = modelMapper.map(TaiKhoanDTO, new TypeToken<List<TaiKhoan>>() {
        }.getType());
        return KhachHang;
    }

    public List<TaiKhoanDTO> toDTOs(List<TaiKhoan> TaiKhoans) {
       // modelMapper.addConverter(toStringDate);
       
        List<TaiKhoanDTO> khachHang = modelMapper.map(TaiKhoans, new TypeToken<List<TaiKhoanDTO>>() {
        }.getType());
        return khachHang;
    }
    
    
 
}
