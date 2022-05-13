package com.mycompany.springmvchibernate.DTO;



import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mycompany.springmvchibernate.AnnotationValidator.PasswordMatches;
import com.mycompany.springmvchibernate.Entity.AuthProvider;
import com.mycompany.springmvchibernate.Entity.VaiTro;
import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;

@PasswordMatches(field="password")
public class TaiKhoanDTO {

	private int id;
	
	@Size(min=8,max=50,message="User phải có chiều dài 8-50 kí tự")
	@NotNull
	private String username;
	
	
	@Size(min=8,max=50,message="Mật khẩu phải có chiều dài 8-50 kí tự")
	@NotNull
	private String password;
		
	private boolean active;
	
	private VerificationTokenEntity verificationCode;
	
	
	private String passwordConfirm;
	
	private KhachHangDTO khachHangs;
	
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	private String providerId;

	private String imageUrl;
	
	// bi-directional many-to-one association to KhachHang
	@Valid
	private VaiTro vaiTro;	
	
	public TaiKhoanDTO(int id, @Min(1) @Max(20) String username, @Min(8) @Max(50) String password,
			@Min(8) @Max(50) String passwordConfirm) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public VerificationTokenEntity getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(VerificationTokenEntity verificationCode) {
		this.verificationCode = verificationCode;
	}

	public TaiKhoanDTO() {

	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public String getPasswordConfirm() {
		return passwordConfirm;
	}




	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}




	public void setPassword(String password) {
		this.password = password;
	}







	public KhachHangDTO getKhachHangs() {
		return khachHangs;
	}




	public void setKhachHangs(KhachHangDTO khachHangs) {
		this.khachHangs = khachHangs;
	}




	public VaiTro getVaiTro() {
		return vaiTro;
	}




	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}
	
	

}
