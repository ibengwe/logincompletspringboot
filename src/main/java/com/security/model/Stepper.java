package com.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Stepper {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkNumber;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String gender;
    private String forcenumber;
    private String mobile;
    private String maritalStatus;
    private String address;
    private Date dateOnList;
    @ManyToOne
    private Section section;
    @ManyToOne
    private Region birthdayRegion;
    @ManyToOne
    private District birthdayDistrict;
}
