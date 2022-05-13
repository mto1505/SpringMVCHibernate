package com.mycompany.springmvchibernate.Event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;

public class OnRegistrationCompleteEvent extends ApplicationEvent{

	private KhachHang khachHang;
	private String appUrl;
	private Locale locale;
	public OnRegistrationCompleteEvent(KhachHang khachHang, String appUrl, Locale locale) {
		super(khachHang);
		this.khachHang = khachHang;
		this.appUrl = appUrl;
		this.locale = locale;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public String getAppUrl() {
		return appUrl;
	}
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	

}
