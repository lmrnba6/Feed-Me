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
@Table(name="FEEDBACK")
@Setter @Getter
public class FeedBack {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long feedBackId;
    @Column(name="SUBJECT")
    private String subject;
    @Column(name="COMMENT")
    private String comment;
    @Column(name="FEEDBACK_DATE")
    private Date feedBackDate;
    @OneToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;
    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;

}
