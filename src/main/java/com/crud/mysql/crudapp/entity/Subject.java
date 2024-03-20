package com.crud.mysql.crudapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
//@Scope("singleton")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Subject extends AbstractEntity {
	
	private String name;	
	
}
