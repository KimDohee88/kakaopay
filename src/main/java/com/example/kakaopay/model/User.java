package com.example.kakaopay.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User{
	@Id
    @NotBlank
    @Size(min=3, max = 50)
    private String username;
    
    @NotBlank
    @Size(min=6, max = 100)
    private String password;

}