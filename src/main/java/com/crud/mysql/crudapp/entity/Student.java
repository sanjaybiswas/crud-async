package com.crud.mysql.crudapp.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String enrlid;
	private String name;
	
	@Embedded
	private Address address;
	
	 
	/**
	 * Returns the identifier of the entity.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	private String courseName;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = {
			@JoinColumn(name= "student_id",referencedColumnName = "id")
	},inverseJoinColumns = {
			@JoinColumn(name="course_id", referencedColumnName = "id")
	})
	private Set<Course> course;
	
	
	

}
