package org.bet.football.mybetleague.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "bet")
public class Bet  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	@NotNull
	private Date createdate;
	
	@Column
	@NotNull
	private String betname;
	@Column
	@NotNull
	private Date betdate;
	@Column
	@NotNull
	private int betmoney;
	@Column
	@NotNull
	private String betplayer;
	@Column
	@NotNull
	private int idbetlist;

	public Bet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param value the id to set
	 */
	public Bet setId(final int value) {
		id = value;
		return this;
	}

	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * @param value the createdate to set
	 */
	public Bet setCreatedate(final Date value) {
		createdate = value;
		return this;
	}

	/**
	 * @return the betname
	 */
	public String getBetname() {
		return betname;
	}

	/**
	 * @param value the betname to set
	 */
	public Bet setBetname(final String value) {
		betname = value;
		return this;
	}

	/**
	 * @return the betdate
	 */
	public Date getBetdate() {
		return betdate;
	}

	/**
	 * @param value the betdate to set
	 */
	public Bet setBetdate(final Date value) {
		betdate = value;
		return this;
	}

	/**
	 * @return the betmoney
	 */
	public int getBetmoney() {
		return betmoney;
	}

	/**
	 * @param value the betmoney to set
	 */
	public Bet setBetmoney(final int value) {
		betmoney = value;
		return this;
	}

	/**
	 * @return the betplayer
	 */
	public String getBetplayer() {
		return betplayer;
	}

	/**
	 * @param value the betplayer to set
	 */
	public Bet setBetplayer(final String value) {
		betplayer = value;
		return this;
	}

	/**
	 * @return the idbetlist
	 */
	public int getIdbetlist() {
		return idbetlist;
	}

	/**
	 * @param value the idbetlist to set
	 */
	public Bet setIdbetlist(final int value) {
		idbetlist = value;
		return this;
	}

}
