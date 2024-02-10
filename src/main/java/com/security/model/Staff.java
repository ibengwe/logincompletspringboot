package com.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Staff {
//    personal Information
    @Id
    private Integer checkNumber;
    private String forceNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private Date dateOnList;
    private Date dateBirthday;
    @ManyToOne
    private Region birthdayRegion;
    @ManyToOne
    private District birthdayDistrict;
    private String maritalStatus;
    private String section;
    private String mobile;

//    recognition details
    private String bodyBuild;
    private String hairStle;
    private String hairOnFace;
    private String eyes;
    private String height ;
    private String weight ;
    private String mark;
    private String bloodGroup;
    private String chest ;

//    Other details
    private String tribe;
    private String noOfChildren;
    private String successor;
    private String relationSuccessor;
    private String executiveOfficer;
    private String headMan;
    private String village ;
}
