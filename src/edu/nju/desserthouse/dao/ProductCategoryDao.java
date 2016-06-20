package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.ProductCategory;

/*
 * ��Ʒ�����
 * ��Ҫ��������ڲ鿴��Ʒʱ�����Ը�����Ʒ�ķ�����в鿴 ��ʱ����Ҫ��Ʒ�������ѡ��
 * �鿴ĳ�������С����
 * �鿴ĳ��С�������Ĵ���
 */
public interface ProductCategoryDao {
	/*
	 * ����id����ProductCategory����,����ҵ��򷵻��������,���򷵻�null
	 */
	public ProductCategory find(int id);
	/*
	 * �������Ԫ��
	 */
	public List<ProductCategory> getAllProductCategoryList();
	/*
	 * ���ĳ�������������Ԫ��
	 */
	public List<ProductCategory> getAllChildrenProductCategoryList(int ppcid);
	/*
	 * ����id����ProductCategory��Ӧ�ĸ������,����ҵ��򷵻��������,���򷵻�null
	 */
	public ProductCategory findParent(int pcid);
	/*
	 * ����������ϲ㸸��Ԫ��
	 */
	public List<ProductCategory> getAllParentProductCategoryList();
}
