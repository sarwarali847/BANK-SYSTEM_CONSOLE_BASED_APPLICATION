package Bank;

import java.io.Serializable;

public class Bank_ implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name_;
	private String add_;
	private String contact_;
	private String username_;
	private String password_;
	private double amount_;
	public Bank_(String name_, String add_, String contact_, String username_, String password_, double amount_) {
		super();
		this.name_ = name_;
		this.add_ = add_;
		this.contact_ = contact_;
		this.username_ = username_;
		this.password_ = password_;
		this.amount_ = amount_;
	}
	
	
	
	public String getName_() {
		return name_;
	}



	public void setName_(String name_) {
		this.name_ = name_;
	}



	public String getAdd_() {
		return add_;
	}



	public void setAdd_(String add_) {
		this.add_ = add_;
	}



	public String getContact_() {
		return contact_;
	}



	public void setContact_(String contact_) {
		this.contact_ = contact_;
	}



	public String getUsername_() {
		return username_;
	}



	public void setUsername_(String username_) {
		this.username_ = username_;
	}



	public String getPassword_() {
		return password_;
	}



	public void setPassword_(String password_) {
		this.password_ = password_;
	}



	public double getAmount_() {
		return amount_;
	}



	public void setAmount_(double amount_) {
		this.amount_ = amount_;
	}



	@Override
	public String toString() {
		
		return "Name: "+name_+", Address: "+add_+", Contact: "+contact_+", Username: "+username_+", Password: "+password_+", Balance: "+amount_;
	}
}

