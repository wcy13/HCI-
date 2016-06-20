package edu.nju.desserthouse.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;
import edu.nju.desserthouse.service.PlanAutoGenerateService;

public class PlanAutoGenerateServiceImpl implements PlanAutoGenerateService{
	@Autowired
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<List<AutoGeneratingPlanItem>> getAutoGeneratingPlan(int sid, int range, int type) {
		List<List<AutoGeneratingPlanItem>> agpList;
		Calendar cal = Calendar.getInstance();
	    int month = cal.get(Calendar.MONTH) ;
		if(range==0){
			//��һ������
			if(type==0){
				//�ֹ����ɷ�ʽ
				agpList = orderDao.getMonthExtreamAutoGeneratingPlan(sid, month, "desc");
			}else if(type==1){
				//�������ɷ�ʽ
				agpList = orderDao.getMonthExtreamAutoGeneratingPlan(sid, month, "asc");
			}else{
				//�������ɷ�ʽ
				agpList = orderDao.getMonthExtreamAutoGeneratingPlan(sid, month);
			}
		}else{
			//��һ������
			if(type==0){
				//�ֹ����ɷ�ʽ
				agpList = orderDao.getYearExtreamAutoGeneratingPlan(sid, "desc");
			}else if(type==1){
				//�������ɷ�ʽ
				agpList = orderDao.getYearExtreamAutoGeneratingPlan(sid, "asc");
			}else{
				//�������ɷ�ʽ
				agpList = orderDao.getYearExtreamAutoGeneratingPlan(sid);
			}
		}
		return agpList;
	}
	
	
}
