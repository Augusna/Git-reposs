package entity;

import java.sql.Date;

public class FinancingProduct {
	private String id;
	private Integer risk;
	private String income;
	private Date saleStarting;
	private Date saleEnd;
	private Date end;
	public FinancingProduct() {
		super();
	}
	public FinancingProduct(Integer risk, String income, Date saleStarting, Date saleEnd, Date end) {
		super();
		this.risk = risk;
		this.income = income;
		this.saleStarting = saleStarting;
		this.saleEnd = saleEnd;
		this.end = end;
	}
	public FinancingProduct(String id, Integer risk, String income, Date saleStarting, Date saleEnd, Date end) {
		super();
		this.id = id;
		this.risk = risk;
		this.income = income;
		this.saleStarting = saleStarting;
		this.saleEnd = saleEnd;
		this.end = end;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getRisk() {
		return risk;
	}
	public void setRisk(Integer risk) {
		this.risk = risk;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public Date getSaleStarting() {
		return saleStarting;
	}
	public void setSaleStarting(Date saleStarting) {
		this.saleStarting = saleStarting;
	}
	public Date getSaleEnd() {
		return saleEnd;
	}
	public void setSaleEnd(Date saleEnd) {
		this.saleEnd = saleEnd;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "FinancingProduct [id=" + id + ", risk=" + risk + ", income=" + income + ", saleStarting=" + saleStarting
				+ ", saleEnd=" + saleEnd + ", end=" + end + "]";
	}
	
	
}
