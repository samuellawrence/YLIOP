package com.arvato.jesy.lifematters.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personnel extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String rfId;

    public Personnel() {
        super();
    }

    public Personnel(Long id, String name, String rfId) {
        super();
        this.name = name;
        this.rfId = rfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfId() {
        return rfId;
    }

    public void setRfIdNumber(String rfId) {
        this.rfId = rfId;
    }

}