package edu.nju.desserthouse.model.stavo;
/*
 * ������Ʒͳ��VO
 * ���е����ܼƺ;���ÿ�������ܼƶ��ô�
 */
public class DisProductStaVO {
	public String product;
	public int pid;
	public String category;
	public int amount;
	public double sum;
	public DisProductStaVO(){}
	public DisProductStaVO(String product, int pid, String category, int amount, double sum) {
		super();
		this.product = product;
		this.pid = pid;
		this.category = category;
		this.amount = amount;
		this.sum = sum;
	}
	
}
