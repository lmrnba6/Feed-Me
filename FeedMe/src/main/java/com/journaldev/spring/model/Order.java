package com.journaldev.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name="ORDERS")
public class Order {
    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long orderId;
    @OneToOne
    private User user;
    @ManyToMany
    @JoinColumn(name="MEALS", table="ORDER_MEAL")
    private Set<Meal> meals = new HashSet<Meal>();
    @Column(name="PRICE")
    private Double price;
    @Column(name="COMMENT")
    private String comment;
    @Column(name="STATUS")
    private String status;
}
