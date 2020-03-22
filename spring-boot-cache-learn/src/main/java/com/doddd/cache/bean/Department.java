package com.doddd.cache.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author doddd
 */
@Entity
@Table(name = "department")
@Data
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String departmentName;
	
	

	
	

}
