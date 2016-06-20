package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DessertDao;
import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.ProductTrendItemVO;
import edu.nju.desserthouse.model.stavo.ProductTrendVO;
import edu.nju.desserthouse.service.ProductTrendService;

public class ProductTrendServiceImpl implements ProductTrendService{
	@Autowired
	private OrderDao orderDao;
	private DistrictDao districtDao;
	private ShopDao shopDao;
	private DessertDao dessertDao;
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
	public DessertDao getDessertDao() {
		return dessertDao;
	}
	public void setDessertDao(DessertDao dessertDao) {
		this.dessertDao = dessertDao;
	}
	@Override
	public ProductTrendVO getProductTrend(int sid, int disid, int did) {
		List<Dessert> dessertList = dessertDao.getAllDessertList();
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> shopList = new ArrayList<Shop>();
		List<Shop> sl = shopDao.getAllShopList();
		List<ProductTrendItemVO> ptiList;
		//���Ӹ���Ʒ���������ÿ��ƽ��������--������
		//ֻ��Ե����ܼ�
		if(disid==0){
			ptiList = orderDao.getProductTrendItemVOList(did);
			//shopֻ��һ���ܵ�
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("���е���");
			shopList.add(s);
			
		}else if(disid!=0&&sid==0){
			ptiList = orderDao.getProductTrendItemVOList(did,disid);
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
			
		}else{
			ptiList = orderDao.getProductTrendItemVOList(did,disid,sid);
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
			
		}
		ProductTrendVO ptvo = new ProductTrendVO(disList,shopList,dessertList,ptiList);
		return ptvo;
	}
	
}
