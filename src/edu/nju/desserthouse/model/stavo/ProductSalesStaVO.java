package edu.nju.desserthouse.model.stavo;
//ProductStaService�������Ʒͳ��ʱ�����ݿ��л�õ����ݼ���Ŀ
//����-����-��Ʒ-����-����-���
public class ProductSalesStaVO {
	public String district;
	public String shop;
	public int sid;
	public String product;
	public int pid;
	public String category;
	public int amount;
	public double sum;
	
	public ProductSalesStaVO(){}
	public ProductSalesStaVO(String district, String shop, int sid, String product, int pid, String category,
			int amount, double sum) {
		super();
		this.district = district;
		this.shop = shop;
		this.sid = sid;
		this.product = product;
		this.pid = pid;
		this.category = category;
		this.amount = amount;
		this.sum = sum;
	}
	
}
