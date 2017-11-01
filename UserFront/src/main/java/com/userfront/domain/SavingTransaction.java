package com.userfront.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SavingTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="saving_trans_date")
	private Date date;
	private String description;
	private String type ;
	private String status;
	private double amount;
	private BigDecimal availableBalanbce; 
	@ManyToOne
	@JoinColumn(name="saving_account_id")
	private SavingsAccount savingAccount;
	
	public SavingTransaction(Date date, String description, String type, String status, double amount,
			BigDecimal availableBalanbce, SavingsAccount savingAccount) {
		super();
		this.date = date;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.availableBalanbce = availableBalanbce;
		this.savingAccount = savingAccount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public BigDecimal getAvailableBalanbce() {
		return availableBalanbce;
	}
	public void setAvailableBalanbce(BigDecimal availableBalanbce) {
		this.availableBalanbce = availableBalanbce;
	}
	public SavingsAccount getSavingAccount() {
		return savingAccount;
	}
	public void setSavingAccount(SavingsAccount savingAccount) {
		this.savingAccount = savingAccount;
	}
	
	public SavingTransaction() {}

}
