package com.mycompany.springmvchibernate.Service.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
@Component
public class ChiTietSanPhamConvert {
	@Autowired
    ModelMapper modelMapper;
  
    
    public ChiTietSanPhamDTO toDTO(ChiTietSanPham SanPham) {
        //modelMapper.addConverter(toStringDate);
    	modelMapper.getConfiguration()
        .setPropertyCondition(context -> 
              !(context.getSource() instanceof PersistentCollection)
         ); 
        ChiTietSanPhamDTO ChiTietSanPhamDTO = modelMapper.map(SanPham, ChiTietSanPhamDTO.class);
        return ChiTietSanPhamDTO;
    }

    public ChiTietSanPham toEntity(ChiTietSanPhamDTO ChiTietSanPhamDTO) {
       
       // modelMapper.addConverter(toStringDate);
       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        ChiTietSanPham SanPham = modelMapper.map(ChiTietSanPhamDTO, ChiTietSanPham.class);
        return SanPham;
    }

    
    public List<ChiTietSanPham> toEntitys(List<ChiTietSanPhamDTO> ChiTietSanPhamDTO) {
      //modelMapper.addConverter(toStringDate);
      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
        List<ChiTietSanPham> SanPham = modelMapper.map(ChiTietSanPhamDTO, new TypeToken<List<ChiTietSanPham>>() {
        }.getType());
        return SanPham;
    }

    public List<ChiTietSanPhamDTO> toDTOs(List<ChiTietSanPham> sanPham) {
       // modelMapper.addConverter(toStringDate);
    	modelMapper.getConfiguration()
  	  .setMatchingStrategy(MatchingStrategies.STANDARD);
    	
    	modelMapper.getConfiguration()
        .setPropertyCondition(context -> 
              (!(context.getSource() instanceof PersistentCollection)||((PersistentCollection)context.getSource()).wasInitialized())
         ); 
    	//modelMapper.addMappings(propertyMapToChiTietSanPhamDTO);
        ArrayList<ChiTietSanPhamDTO> listChiTietSanPham = modelMapper.map(sanPham, new TypeToken<List<ChiTietSanPhamDTO>>() {
        }.getType());
        return listChiTietSanPham;
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
                Logger.getLogger(SanPhamConvert.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
