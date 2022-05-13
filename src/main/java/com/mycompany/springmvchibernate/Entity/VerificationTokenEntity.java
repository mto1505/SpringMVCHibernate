package com.mycompany.springmvchibernate.Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;

@Entity
@Table(name="Verification")
public class VerificationTokenEntity {
	private static final int EXPIRATION = 60 * 24;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="token")
    private String token;
  
    @OneToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name = "ID_TK")
    private TaiKhoan taiKhoan;
    
    @Column(name="expiryDate")
    private Date expiryDate;
   
    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
    public VerificationTokenEntity() {
		super();
	}

	public VerificationTokenEntity(final String token) {
        super();

        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public VerificationTokenEntity(final String token, final TaiKhoan user) {
        super();

        this.token = token;
        this.taiKhoan = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate =expiryDate;
	}
	public static int getExpiration() {
		return EXPIRATION;
	}

    
   
}
