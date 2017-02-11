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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SHOPPINGCART")
public class ShoppingCart {

	@Id
	@Column(name = "CART_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "CART_MEAL" , joinColumns = {
			@JoinColumn(name = "MEAL_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "CART_ID",
					nullable = false, updatable = false) })
	private Set<Meal> meals = new HashSet<Meal>();

	@Column(name = "price")
	private Double price;

	@Column(name = "size")
	private Integer size;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

}
