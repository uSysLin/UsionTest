package com.usion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "handset")
public class Handset extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    private Long id;
    @Column(name = "dev_id", nullable = false, length = 50)
    @Field
    private String devId;                    // required
    @Column(name = "inner_id", nullable = false, length = 50)
    @Field
    private String innerId;                    // required
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getInnerId() {
		return innerId;
	}
	public void setInnerId(String innerId) {
		this.innerId = innerId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

   
}
