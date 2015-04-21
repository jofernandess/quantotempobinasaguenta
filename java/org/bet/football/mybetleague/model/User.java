/**
 * 
 */
package org.bet.football.mybetleague.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

/**
 * @author Joao
 *
 */
@Entity
@XmlRootElement
@Table(name = "User")
public class User implements Serializable {

	/**
	 * Default value included to remove warning.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int userId;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@NotNull
	private DateTime createDate;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updateDate;

	@Column(columnDefinition = "enum('admin', 'manager', 'user', 'unknown') default 'user'")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column
	@NotNull
	@Size(min = 1, max = 25, message = "1-25 letters and spaces")
	private String username;

	@Column
	@NotNull
	@NotEmpty
	@Email(message = "Invalid format")
	private String email;
	@Column
	private String password;
	@Column
	private String givenName;
	@Column
	private String familyName;
	@Column
	private String salt;

	@NotNull
	@Column(name = "status", columnDefinition = "BIT default b'0'", length = 1)
	private boolean status;

	@Column
	private Date dateOfBirth;

	@NotNull
	@Column(columnDefinition = "enum('MALE','FEMALE','OTHER')")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column
	private String address;
	@Column
	private String address2;
	@Column
	private String zipCode;

	@Column
	private String token;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @return the createDate
	 */
	public DateTime getCreateDate() {
		return createDate;
	}

	/**
	 * @return the updateDate
	 */
	public DateTime getUpdateDate() {
		return updateDate;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the firstName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @return the lastName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
