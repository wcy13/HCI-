package edu.nju.desserthouse.model.stavo;

//��Ʒÿ�����������&�ܽ��
public class ProductTrendItemVO {
	public String date; 
	public int amount;
	public double total;
	public ProductTrendItemVO(){}
	public ProductTrendItemVO(String date, int amount, double total) {
		super();
		this.date = date;
		this.amount = amount;
		this.total = total;
	}
	
}
