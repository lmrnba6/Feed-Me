package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "REST_CATEGORY")
public class RestCategory {
	@Id
	@Column(name = "REST_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restCategoryId;
	@Column(name = "NAME")
	private String name;
}
