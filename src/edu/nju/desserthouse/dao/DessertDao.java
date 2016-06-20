package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Dessert;

public interface DessertDao {
	/*
	 * �����ݿ��в���һ��Dessert
	 */
	public void save(Dessert dessert);
	/*
	 * ɾ��һ��DessertԪ��
	 */
	public void delete(int id);
	
	/*
	 * ����id����Dessert����,����ҵ��򷵻��������,���򷵻�null
	 */
	public Dessert find(int id);
	
	
	/*
	 * ����id����Dessert���һ����¼
	 */
	public void updateByDessertId(Dessert dessert);
	/*
	 * �������Ԫ��
	 */
	public List<Dessert> getAllDessertList();
	
	/***************************HCI���***********************************/
	//���ĳpcid��Ӧ����Ʒ�б�
	public List<Dessert> getCategoryRelatedDesserts(int pcid);
	public List<Dessert> getAllDessertListWithoutCake();
}
