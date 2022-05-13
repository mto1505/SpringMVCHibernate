package com.mycompany.springmvchibernate.Entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    
	    @Column(nullable = false)
	    private String email;

	    private String imageUrl;

	    @Column(nullable = false)
	    private Boolean emailVerified = false;

	    @JsonIgnore
	    private String password;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private AuthProvider provider;

	    private String providerId;

	    // Getters and Setters (Omitted for brevity)
}
