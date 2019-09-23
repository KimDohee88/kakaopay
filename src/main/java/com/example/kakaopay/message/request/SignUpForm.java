package com.example.kakaopay.message.request;

import javax.validation.constraints.NotBlank;

public class SignUpForm {
	
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public void setUsername(String username) {
        this.username = username;
    }
}