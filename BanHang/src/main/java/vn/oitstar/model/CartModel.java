package vn.oitstar.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")

public class CartModel implements Serializable {

	private String id;
	private AccountModel buyer;
	private Date buydate;
	public CartModel() {
		super();
	}
	public CartModel(String id, AccountModel buyer, Date buydate) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.buydate = buydate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AccountModel getBuyer() {
		return buyer;
	}
	public void setBuyer(AccountModel buyer) {
		this.buyer = buyer;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	@Override
	public String toString() {
		return "CartModel [id=" + id + ", buyer=" + buyer + ", buydate=" + buydate + "]";
	}
	
}
