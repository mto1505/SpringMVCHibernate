package com.mycompany.springmvchibernate.Service.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.collection.spi.PersistentCollection;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;


@Component
public class ChiTietGioHangConvert {
	  	
		@Autowired
	    ModelMapper modelMapper;
	  
	    
	    public ChiTietGioHangConvert() {
			
		}

		public ChiTietGioHangDTO toDTO(ChiTietGioHang ChiTietGioHang) {
	    	/*modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.LOOSE);*/
	    	modelMapper.getConfiguration()
	           .setPropertyCondition(context -> 
	                 !(context.getSource() instanceof PersistentCollection)
	            );
	    	modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.LOOSE);
	        //modelMapper.addConverter(toStringDate);
	        ChiTietGioHangDTO ChiTietGioHangDTO = modelMapper.map(ChiTietGioHang, ChiTietGioHangDTO.class);
	        return ChiTietGioHangDTO;
	    }

	    public ChiTietGioHang toEntity(ChiTietGioHangDTO chiTietGioHangDTO) {
	    
	    	// After
	    	TypeMap<ChiTietGioHangDTO, ChiTietGioHang> typeMap = modelMapper.getTypeMap(ChiTietGioHangDTO.class, ChiTietGioHang.class);
	    	if (typeMap == null) { // if not  already added
	    		modelMapper.addMappings(new PropertyMap<ChiTietGioHangDTO ,ChiTietGioHang>() {
		    	    @Override
		    	    protected void configure() {
		    	        map().getId().setIdCtsp(source.getIdIdCtsp());
		    	        map().getId().setIdGh(source.getIdIdGh());
		    	    }            
		    	});
	    	}
	    	modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.LOOSE);	       // modelMapper.addConverter(toStringDate);
	       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
	        
	    	ChiTietGioHang ChiTietGioHang = modelMapper.map(chiTietGioHangDTO, ChiTietGioHang.class);
	        return ChiTietGioHang;
	    }

	    
	    public List<ChiTietGioHang> toEntitys(List<ChiTietGioHangDTO> ChiTietGioHangDTO) {
	      //modelMapper.addConverter(toStringDate);
	      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
	        List<ChiTietGioHang> ChiTietGioHang = modelMapper.map(ChiTietGioHangDTO, new TypeToken<List<ChiTietGioHang>>() {
	        }.getType());
	        return ChiTietGioHang;
	    }

	    public List<ChiTietGioHangDTO> toDTOs(List<ChiTietGioHang> ChiTietGioHang) {
	       // modelMapper.addConverter(toStringDate);
	    	modelMapper.getConfiguration()
	           .setPropertyCondition(context -> 
	                 (!(context.getSource() instanceof PersistentCollection)||((PersistentCollection)context.getSource()).wasInitialized())
	            ); 
	    	modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.LOOSE);
	    	/*modelMapper.addMappings(new PropertyMap<ChiTietGioHangDTO, ChiTietGioHang>() {
				@Override
				protected void configure() {
					// TODO Auto-generated method stub
					skip().setDanhGias(null);
					skip().setHinhAnhSps(null);
				}
			});*/
	  //  	modelMapper.addConverter(populateExistList);
	    	//modelMapper.addMappings(propertyMapToChiTietGioHangDTO);
	        ArrayList<ChiTietGioHangDTO> listChiTietGioHang = modelMapper.map(ChiTietGioHang, new TypeToken<List<ChiTietGioHangDTO>>() {
	        }.getType());
	        
	      //  List<ChiTietChiTietGioHangDTO> listCT=modelMapper.map(ChiTietGioHang,new TypeToken<List<ChiTietGioHangDTO>>() {}.getType());
	    
	        return listChiTietGioHang;
	    }
	    

	    
	    
}
