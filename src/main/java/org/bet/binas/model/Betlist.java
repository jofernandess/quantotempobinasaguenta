package org.bet.binas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "betList")
public class Betlist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Column
	private String betname;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param value
	 *            the id to set
	 */
	public Betlist setId(final int value) {
		id = value;
		return this;
	}

	/**
	 * @return the betname
	 */
	public String getBetname() {
		return betname;
	}

	/**
	 * @param value
	 *            the betname to set
	 */
	public Betlist setBetname(final String value) {
		betname = value;
		return this;
	}

}
