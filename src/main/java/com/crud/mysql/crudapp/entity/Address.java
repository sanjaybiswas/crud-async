package com.crud.mysql.crudapp.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

	private String city;
	private String Street;
	private String zipcode;
	
	
	
}
