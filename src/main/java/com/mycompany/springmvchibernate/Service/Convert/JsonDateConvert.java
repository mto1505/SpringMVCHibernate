package com.mycompany.springmvchibernate.Service.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.Provider;

public class JsonDateConvert {
	
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
}
