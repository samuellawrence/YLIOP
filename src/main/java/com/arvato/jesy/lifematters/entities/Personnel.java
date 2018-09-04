package com.arvato.jesy.lifematters.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Personnel extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String phoneNumber;
    private String emergencyContact;
    private String emergencyContactNumber;
    
    @OneToOne
    private RfIdLog rfLog;
    
}