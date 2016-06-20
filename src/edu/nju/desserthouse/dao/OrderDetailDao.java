package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.OrderDetail;
import edu.nju.desserthouse.model.hci.OrderDetailVO;

public interface OrderDetailDao {
	/*
	 * �����ݿ��в���һ��OrderDetail
	 */
	public void save(OrderDetail orderDetail);
	
	/*
	 * ����id����OrderDetail����,����ҵ��򷵻��������,���򷵻�null
	 */
	public OrderDetail find(int id);
	
	/*
	 * �������Ԫ��
	 */
	public List<OrderDetail> getAllOrderDetailList();
	/*
	 * ���oid��ӦԪ���б�
	 */
	public List<OrderDetailVO> getAllOrderDetailList(int oid);
	
}
