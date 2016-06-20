package edu.nju.desserthouse.model;
import java.io.Serializable;

/*
 * ��ʱ����ӹ��ڴ˵�DAO ���Ǿ�ͨ��orderDao���в���
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderdetail")
public class OrderDetail implements Serializable{
	@Id
	private int odid;
	private int oid;
	private int did;
	private double price;
	private int amount;
	public OrderDetail(){}
	public OrderDetail(int odid, int oid, int did, double price, int amount) {
		super();
		this.odid = odid;
		this.oid = oid;
		this.did = did;
		this.price = price;
		this.amount = amount;
	}
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
