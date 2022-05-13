package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.springmvchibernate.AnnotationValidator.EmailValid;
import com.mycompany.springmvchibernate.AnnotationValidator.PhoneValid;
import com.mycompany.springmvchibernate.AnnotationValidator.ValidReCaptcha;


public class KhachHangDTO {
	

	private int id;
	
	private String diaChi;
	
	@EmailValid(message="Email không đúng định dạng")
	private String email;
	
	@Size(min=1,max=50,message="Họ và tên không được trống")
	@NotNull // có thể rỗng, nhưng ko thể null
	private String hoVaTenDem;
	@NotNull
	@PhoneValid(message="Số điện thoại không đúng")
	private String soDienThoai;
	
	@Size(min=1,max=20,message="Tên không được trống")
	@NotNull
	private String ten;
	
	private GioHangDTO gioHang;
	@Valid
	private TaiKhoanDTO taiKhoan;
	
	@NotNull(message="Vui lòng xác thực")
	@NotBlank(message="Vui lòng chọn vào ô vuông")
    @ValidReCaptcha
    private String reCaptchaResponse;
	
	public KhachHangDTO() {
		
	}

	

	public KhachHangDTO(int id, String diaChi, String email, String hoVaTenDem,
			 String soDienThoai,  String ten,TaiKhoanDTO taiKhoan
		) {
		
		this.id = id;
		this.diaChi = diaChi;
		this.email = email;
		this.hoVaTenDem = hoVaTenDem;
		this.soDienThoai = soDienThoai;
		this.ten = ten;
		this.taiKhoan = taiKhoan;
		
	}



	public String getReCaptchaResponse() {
		return reCaptchaResponse;
	}

	public void setReCaptchaResponse(String reCaptchaResponse) {
		this.reCaptchaResponse = reCaptchaResponse;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHoVaTenDem() {
		return hoVaTenDem;
	}


	public void setHoVaTenDem(String hoVaTenDem) {
		this.hoVaTenDem = hoVaTenDem;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public GioHangDTO getGioHang() {
		return gioHang;
	}


	public void setGioHang(GioHangDTO gioHang) {
		this.gioHang = gioHang;
	}


	public TaiKhoanDTO getTaiKhoan() {
		return taiKhoan;
	}


	public void setTaiKhoan(TaiKhoanDTO taiKhoan) {
		this.taiKhoan = taiKhoan;
	}



	
}
