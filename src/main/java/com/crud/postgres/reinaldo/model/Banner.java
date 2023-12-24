package com.crud.postgres.reinaldo.model;
import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import org.hibernate.annotations.CreationTimestamp;

import com.crud.postgres.reinaldo.enums.BannerInformationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
@Entity
@Table(name = "banner")
public class Banner {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String imageBanner;

    @Enumerated(EnumType.STRING)
    private BannerInformationType purchaseInformation;

    @Column
    private String site;

    @Column
    private String userCreate;

    @Column
    private String title;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_at")
    private Date createdAt;

    public  Banner(){

    }
}
