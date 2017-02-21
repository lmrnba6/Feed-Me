package com.journaldev.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "MEAL")
public class Meal {

	@Id
	@Column(name = "MEAL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long meal_id;
	@Column(name = "MEAL_NAME")
	private String mealName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	@Column(name = "MEAL_IMAGE_URL")
	private String mealImageUrl;
	@ManyToOne
	@JoinColumn(name ="MENU_ID")
	private Menu menu;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<ShoppingCart> cart = new HashSet<>();
	
	

}
