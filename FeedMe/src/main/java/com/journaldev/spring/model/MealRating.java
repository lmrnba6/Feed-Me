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
@Setter @Getter
@Table(name="MEAL_RATING")
public class MealRating {
    @Id
    @Column(name="MEAL_RATING_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long mealRatingId;
    @OneToOne
    @JoinColumn(name="MEAL")
    private Meal meal;
    @Column(name="RATINGVALUE")
    private Integer ratingValue;
    @Column(name="RATEDATE")
    private Date rateDate;
    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;

}
