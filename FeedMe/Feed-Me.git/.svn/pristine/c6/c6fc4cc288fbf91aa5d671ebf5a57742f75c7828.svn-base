package com.journaldev.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String mealName;
	private String discription;
	private Double price;
	private String type;
	private boolean isAvailable;
	@ManyToOne
	@JoinColumn(name ="MENU_ID")
	private Menu menu;
	

}
