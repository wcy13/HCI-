package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Promotion;

public interface PromotionDao {
	/*
	 * �����ݿ��в���һ��Promotion
	 */
	public void save(Promotion promotion);
	/*
	 * �������Ԫ��
	 */
	public List<Promotion> getAllPromotionList();
	/*
	 * ����ĳ���ͻ�Ա�Ĵ�������
	 */
	public List<Promotion> findMemPromotion(int mid);
}
