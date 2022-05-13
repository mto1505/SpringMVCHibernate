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

import com.mycompany.springmvchibernate.DTO.BoNhoDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.LoaiDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Service.ISanPhamService;

@Component
public class SanPhamConvert {
	  	
		@Autowired
	    public ModelMapper modelMapper;
	    
	    public SanPhamDTO toDTO(SanPham SanPham) {
	    	/*modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.LOOSE);*/
	    	modelMapper.getConfiguration()
	           .setPropertyCondition(context -> 
	                 !(context.getSource() instanceof PersistentCollection)
	            );
	        //modelMapper.addConverter(toStringDate);
	        SanPhamDTO SanPhamDTO = modelMapper.map(SanPham, SanPhamDTO.class);
	        return SanPhamDTO;
	    }

	    public SanPham toEntity(SanPhamDTO SanPhamDTO) {
	      // modelMapper.addConverter(toStringDate);
	       //  modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
	        SanPham SanPham = modelMapper.map(SanPhamDTO, SanPham.class);
	        return SanPham;
	    }

	    
	    public List<SanPham> toEntitys(List<SanPhamDTO> SanPhamDTO) {
	      //modelMapper.addConverter(toStringDate);
	      //modelMapper.getTypeMap(String.class, Date.class).setProvider(javaDateProvider);
	        List<SanPham> SanPham = modelMapper.map(SanPhamDTO, new TypeToken<List<SanPham>>() {
	        }.getType());
	        return SanPham;
	    }

	    public List<SanPhamDTO> toDTOs(List<SanPham> sanPham) {
	       // modelMapper.addConverter(toStringDate);
	    	modelMapper.getConfiguration()
	           .setPropertyCondition(context -> 
	                 (!(context.getSource() instanceof PersistentCollection)||((PersistentCollection)context.getSource()).wasInitialized())
	            ); 
	    	modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.STANDARD);
	    	/*modelMapper.getConfiguration()
	    	  .setMatchingStrategy(MatchingStrategies.STANDARD);*/
	    	/*modelMapper.addMappings(new PropertyMap<SanPhamDTO, SanPham>() {
				@Override
				protected void configure() {
					// TODO Auto-generated method stub
					skip().setDanhGias(null);
					skip().setHinhAnhSps(null);
					
				}
			});*/
	  //  	modelMapper.addConverter(populateExistList);
	    	//modelMapper.addMappings(propertyMapToSanPhamDTO);
	        ArrayList<SanPhamDTO> listSanPham = modelMapper.map(sanPham, new TypeToken<List<SanPhamDTO>>() {
	        }.getType());
	        
	      //  List<ChiTietSanPhamDTO> listCT=modelMapper.map(sanPham,new TypeToken<List<SanPhamDTO>>() {}.getType());
	    
	        return listSanPham;
	    }
	    
	    Condition<SanPham, SanPhamDTO> conditionChiTietIsNull = new Condition<SanPham, SanPhamDTO>() {

			@Override
			public boolean applies(MappingContext<SanPham, SanPhamDTO> context) {
				// TODO Auto-generated method stub
				return context.getSource().getChiTietSanPhams()==null;
			}
	        
	    };
	    
	    PropertyMap<SanPham, SanPhamDTO> propertyMapToSanPhamDTO=new PropertyMap<SanPham, SanPhamDTO>() {

			@Override
			protected void configure() {
				// TODO Auto-generated method stub\
				when(conditionChiTietIsNull).map().setChiTietSanPhams(null);
				
			}
		
	    };
	    
	    
	   Converter<SanPham,SanPhamDTO> populateExistList=new Converter<SanPham, SanPhamDTO>() {

		@Override
		public SanPhamDTO convert(MappingContext<SanPham, SanPhamDTO> context) {
			// TODO Auto-generated method stub
	
			LoaiDTO loaiDTO=new LoaiDTO();
			loaiDTO.setId(context.getSource().getLoai().getId());
			loaiDTO.setTen(context.getSource().getLoai().getTen());
			context.getDestination().setCameraSau(context.getSource().getCameraSau());
			context.getDestination().setCameraTruoc(context.getSource().getCameraTruoc());
			context.getDestination().setId(context.getSource().getId());
			context.getDestination().setLoai(loaiDTO);
			context.getDestination().setManHinh(context.getSource().getManHinh());
			context.getDestination().setMoTa(context.getSource().getMoTa());
			context.getDestination().setTen(context.getSource().getTen());
			context.getDestination().setPinSac(context.getSource().getPinSac());
			context.getDestination().setSim(context.getSource().getSim());
			if(!context.getSource().getChiTietSanPhams().isEmpty())
			{	List<ChiTietSanPhamDTO> list;
				for (ChiTietSanPham ct:context.getSource().getChiTietSanPhams()) {
					/*BoNhoDTO bn=new BoNhoDTO(ct.getBoNho().getId(), ct.getBoNho().getDungLuong());
					ChiTietSanPhamDTO chiTietSanPhamDTO=new ChiTietSanPhamDTO();
					
					chiTietSanPhamDTO.setId(ct.getId());
					chiTietSanPhamDTO.setBoNho(bn);*/
					//list.add(new ChiTietSanPhamDTO(ct.getId(), ct.getDonGia(), ct.getSoLuong(), bn, null,null,null));
					
				}
					
				
			
				
				
			}
			return null;
		}};
	
	   
	   
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
