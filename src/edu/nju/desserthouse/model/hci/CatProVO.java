package edu.nju.desserthouse.model.hci;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.ProductCategory;
//��������ȥ�����������
//������Ʒ����
//������Ʒ�б�
//��Ʒ�������Ʒ��hashmap
public class CatProVO {
	public List<ProductCategory> productCategoryList;
	public List<Dessert> dessertList;
	public HashMap<Integer,List<Dessert>> cpMap;
	public CatProVO(){}
	public CatProVO(List<ProductCategory> productCategoryList, List<Dessert> dessertList,
			HashMap<Integer, List<Dessert>> cpMap) {
		super();
		this.productCategoryList = productCategoryList;
		this.dessertList = dessertList;
		this.cpMap = cpMap;
	}
	
}
