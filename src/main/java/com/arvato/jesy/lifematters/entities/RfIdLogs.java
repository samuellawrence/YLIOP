package com.arvato.jesy.lifematters.entities;

import java.sql.Date;

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
public class RfIdLogs extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private String rfId;
	private String status;
	
	@LastModifiedDate
	private Date lastModified;
}
