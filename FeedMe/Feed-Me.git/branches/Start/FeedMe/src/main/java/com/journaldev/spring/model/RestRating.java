package com.journaldev.spring.model;

import java.sql.Date;

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
@Table(name = "REST_RATING")
public class RestRating {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restRatingId;
	@Column(name = "RATING_VALUE")
	private Integer ratingValue;
	@Column(name = "RATE_DATE")
	private Date rateDate;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@Column(name = "REVIEW")
	private String review;
	@OneToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

}
