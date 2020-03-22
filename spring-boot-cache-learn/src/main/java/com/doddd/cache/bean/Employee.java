package com.doddd.cache.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author doddd
 */
@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private Integer gender;
	@Column
	private Integer dId;
	

	
	

}
