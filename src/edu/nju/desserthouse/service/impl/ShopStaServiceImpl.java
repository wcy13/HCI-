package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.InValidAnalysis;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;
import edu.nju.desserthouse.model.stavo.ShopStaVO;
import edu.nju.desserthouse.service.ShopStaService;

public class ShopStaServiceImpl implements ShopStaService{
	@Autowired
	private OrderDao orderDao;
	private DistrictDao districtDao;
	private ShopDao shopDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public DistrictDao getDistrictDao() {
		return districtDao;
	}
	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	@Override
	public ShopStaVO getShopSta(int sid, int disid, int choice) {
		List<Shop> shopList = new ArrayList<Shop>();
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> sl = shopDao.getAllShopList();
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		InValidAnalysis inValidAnalysis ;
		//ֻ��Ե����ܼ�
		if(disid==0){
			inValidAnalysis = orderDao.getInvalidOrderAnalysis();
			//shopֻ��һ���ܵ�
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("���е���");
			shopList.add(s);
			if(choice==0){
				//choice==0������ͳ��
				ssiList = orderDao.getDayShopStaItemVOList();
			}else if(choice == 1){
				//choice==1������ͳ��
				ssiList = orderDao.getMonthShopStaItemVOList();
			}
		}else if(disid!=0&&sid==0){
			inValidAnalysis = orderDao.getInvalidOrderAnalysis(disid);
			//shop��Ӧ������ĵ���
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("���е���");
			shopList.add(s);
			for(Shop shop:sl){
				if(shop.getDisid()==disid){
					shopList.add(shop);
				}
			}
			//���ĳ�����ܼ�
			if(choice==0){
				//��ͳ��
				ssiList = orderDao.getDayShopStaItemVOList(disid);
			}else if(choice == 1){
				//choice==1������ͳ��
				ssiList = orderDao.getMonthShopStaItemVOList(disid);
			}
		}else{
			inValidAnalysis = orderDao.getInvalidOrderAnalysis(disid,sid);
			//shop��Ӧ������ĵ���
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("���е���");
			shopList.add(s);
			for(Shop shop:sl){
				if(shop.getDisid()==disid){
					shopList.add(shop);
				}
			}
			//���ĳ�����ܼ�
			if(choice==0){
				//��ͳ��
				ssiList = orderDao.getDayShopStaItemVOList(disid, sid);
			}else if(choice == 1){
				//choice==1������ͳ��
				ssiList = orderDao.getMonthShopStaItemVOList(disid, sid);
			}
		}
		ShopStaVO ssvo = new ShopStaVO(disList,shopList,ssiList,inValidAnalysis);
		return ssvo;
	}
	
}
