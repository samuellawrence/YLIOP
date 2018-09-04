package com.arvato.jesy.lifematters.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.LastModifiedDate;

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
public class RfIdLog extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@Column(unique=true)
	private String rfIdCardNo;
	private String status;
	
	@LastModifiedDate
	private Date lastModified;
}
