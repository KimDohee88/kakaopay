package com.example.kakaopay.message.request;

import javax.validation.constraints.NotBlank;

public class LoginForm {

    @NotBlank
    private String password;
    
    @NotBlank
    private String username;
    
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