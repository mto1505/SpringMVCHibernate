package com.mycompany.springmvchibernate.Service.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;

import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;

@Component
public class DonDatHangConvert {

    @Autowired
  public ModelMapper modelMapper;
  
    
    public DonDatHangDTO toDTO(DonDatHang DonDatHang) {
        //modelMapper.addConverter(toStringDate);
    	modelMapper.getConfiguration()
        .setPropertyCondition(context -> 
              !(context.getSource() instanceof PersistentCollection)
         );
    	 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DonDatHangDTO DonDatHangDTO = modelMapper.map(DonDatHang, DonDatHangDTO.class);

        return DonDatHangDTO;
    }

    public DonDatHang toEntity(DonDatHangDTO donDatHangDTO) {
    	ModelMapper modelMapper2=new ModelMapper();
    	
     modelMapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
       // modelMapper.addConverter(toStringDate);
       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        DonDatHang khachHang = modelMapper2.map(donDatHangDTO, DonDatHang.class);
        return khachHang;
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
    	modelMapper.getConfiguration()
        .setPropertyCondition(context -> 
              !(context.getSource() instanceof PersistentCollection)
         );
    	ModelMapper modelMapper2=new ModelMapper();
    	modelMapper2.getConfiguration()
        .setPropertyCondition(context -> 
              !(context.getSource() instanceof PersistentCollection)
         );
        modelMapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<DonDatHangDTO> dondathang = modelMapper2.map(dondathangs, new TypeToken<List<DonDatHangDTO>>() {
        }.getType());
        return dondathang;
    }
    
    
 
}
