package edu.nju.desserthouse.model.hci;

import java.util.List;

import edu.nju.desserthouse.model.ProductCategory;

/**
 * ��Ʒ����鿴����Ϊ������
 * һ�����ǳ��˵���֮���һ������
 * ��һ�����ǵ�������µĶ������࣬����չʾ��ʱ�������д�ϵ��� ����������ʾ�����µĶ�������
 * @author Administrator
 *
 */
public class CategoryShowVO {
	public List<ProductCategory> topCategoryList;
	public List<ProductCategory> cakeCategoryList;
	
	public CategoryShowVO(){}
	public CategoryShowVO(List<ProductCategory> topCategoryList, List<ProductCategory> cakeCategoryList) {
		super();
		this.topCategoryList = topCategoryList;
		this.cakeCategoryList = cakeCategoryList;
	}
	
	
}
