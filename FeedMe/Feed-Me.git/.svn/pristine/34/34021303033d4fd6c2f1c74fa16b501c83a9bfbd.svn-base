package com.journaldev.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "MENU")
public class Menu {
	@Id
	@Column(name = "MENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Meal> meal = new HashSet<Meal>();
	@OneToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

}
