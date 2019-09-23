package com.example.kakaopay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internetbankinguse")
@IdClass(IbkPK.class)
public class InternetBankingUse {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String year;
	
	@Id
	@Column(name = "device_id")
	private Integer deviceid;
	
	@Column(name = "device_name" , nullable = false)
	private String devicename;
	
	private String rate;
	
	private String totalrate;

}

@Data
class IbkPK implements Serializable {
	private String year;
	private Integer deviceid;
}