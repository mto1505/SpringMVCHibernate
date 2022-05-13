package com.mycompany.springmvchibernate.Service.Convert;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;

@Component
public class KhachHangConverter {
	@Autowired
    ModelMapper modelMapper;
  
    
 

	public KhachHangConverter() {
		
	}

	public KhachHangDTO toDTO(KhachHang KhachHang) {
    	/*modelMapper.getConfiguration()
    	  .setMatchingStrategy(MatchingStrategies.LOOSE);*/
    	modelMapper.getConfiguration()
           .setPropertyCondition(context -> 
                 !(context.getSource() instanceof PersistentCollection)
            );
    	
        //modelMapper.addConverter(toStringDate);
        KhachHangDTO KhachHangDTO = modelMapper.map(KhachHang, KhachHangDTO.class);
        return KhachHangDTO;
    }

    public KhachHang toEntity(KhachHangDTO KhachHangDTO) {
    
    	// After
    	TypeMap<KhachHangDTO, KhachHang> typeMap = modelMapper.getTypeMap(KhachHangDTO.class, KhachHang.class);
    	/*if (typeMap == null) { // if not  already added
    		modelMapper.addMappings(new PropertyMap<KhachHangDTO ,KhachHang>() {
	    	    @Override
	    	    protected void configure() {
	    	        map().getId().setIdCtsp(source.getIdIdCtsp());
	    	        map().getId().setIdGh(source.getIdIdGh());
	    	    }            
	    	});
    	}*/
    	modelMapper.getConfiguration()
    	  .setMatchingStrategy(MatchingStrategies.STRICT);	       // modelMapper.addConverter(toStringDate);
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
    	modelMapper.getConfiguration()
           .setPropertyCondition(context -> 
                 (!(context.getSource() instanceof PersistentCollection)||((PersistentCollection)context.getSource()).wasInitialized())
            ); 
    	/*modelMapper.getConfiguration()
    	  .setMatchingStrategy(MatchingStrategies.STANDARD);*/
    	/*modelMapper.addMappings(new PropertyMap<KhachHangDTO, KhachHang>() {
			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				skip().setDanhGias(null);
				skip().setHinhAnhSps(null);
			}
		});*/
  //  	modelMapper.addConverter(populateExistList);
    	//modelMapper.addMappings(propertyMapToKhachHangDTO);
        ArrayList<KhachHangDTO> listKhachHang = modelMapper.map(KhachHang, new TypeToken<List<KhachHangDTO>>() {
        }.getType());
        
      //  List<ChiTietKhachHangDTO> listCT=modelMapper.map(KhachHang,new TypeToken<List<KhachHangDTO>>() {}.getType());
    
        return listKhachHang;
    }
}
