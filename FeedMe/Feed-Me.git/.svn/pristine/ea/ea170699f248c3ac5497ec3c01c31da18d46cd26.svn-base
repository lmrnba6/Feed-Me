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
@Table(name="CREDIT_CARD")
@Setter @Getter
public class CreditCard {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long creditId;
    @Column(name="number")
    private Long number;
    @Column(name="cvv")
    private Integer cvv;
    @Column(name="month")
    private Integer month;
    @Column(name="year")
    private Integer year;
    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;


}
