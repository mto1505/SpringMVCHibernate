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

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;

import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;

@Component
public class DonDatHangConvert {

    @Autowired
    ModelMapper modelMapper;
  
    
    public DonDatHangDTO toDTO(DonDatHang DonDatHang) {
        //modelMapper.addConverter(toStringDate);
        DonDatHangDTO DonDatHangDTO = modelMapper.map(DonDatHang, DonDatHangDTO.class);

        return DonDatHangDTO;
    }

    public DonDatHang toEntity(DonDatHangDTO DonDatHangDTO) {
       
       // modelMapper.addConverter(toStringDate);
       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        DonDatHang KhachHang = modelMapper.map(DonDatHangDTO, DonDatHang.class);
        return KhachHang;
    }

    
    public List<DonDatHang> toEntitys(List<DonDatHangDTO> DonDatHangDTO) {
      //modelMapper.addConverter(toStringDate);
      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        List<DonDatHang> KhachHang = modelMapper.map(DonDatHangDTO, new TypeToken<List<DonDatHang>>() {
        }.getType());
        return KhachHang;
    }

    public List<DonDatHangDTO> toDTOs(List<DonDatHang> dondathangs) {
       // modelMapper.addConverter(toStringDate);
       
        List<DonDatHangDTO> khachHang = modelMapper.map(dondathangs, new TypeToken<List<DonDatHangDTO>>() {
        }.getType());
        return khachHang;
    }
    
    
 
}
