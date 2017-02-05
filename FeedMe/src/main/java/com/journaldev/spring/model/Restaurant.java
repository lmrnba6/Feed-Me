package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RESTAURANT")
public class Restaurant {
	@Id
	@Column(name = "RESTAURANT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PHONENUM1")
	private Long phoneNum1;
	@Column(name = "PHONENUM2")
	private Long phoneNum2;
	@Column(name = "HOMEDELIVERY")
	private boolean homeDelivery;
	@Column(name = "IS_DELIVERY_CHARGE")
	private boolean isDeliveryCharge;
	@Column(name = "DELIVERY_CHARGE")
	private String deliveryCharge;
	@Column(name = "DELIVERY_TIME")
	private String DeliveryTime;
	@Column(name = "OPENING")
	private String opening;
	@Column(name = "CLOSING")
	private String closing;
	@Column(name = "DISCRIPTION")
	private String discription;
	@Column(name = "ADDRESS")
	private String Address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ZIP")
	private Integer zip;
	@OneToOne
	@JoinColumn(name = "REST_CATEGORY_ID")
	private RestCategory restCategory;
	@Column(name = "OWNER_LASTNAME")
	private String ownerLastName;
	@Column(name = "OWNER_FIRSTNAME")
	private String ownerfirstName;

}
