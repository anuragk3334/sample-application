package com.example.anurag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	
	@Id
	@GeneratedValue
	@JsonIgnoreProperties
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;

}
