package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.DisProductStaVO;
import edu.nju.desserthouse.model.stavo.ProductStaVO;
import edu.nju.desserthouse.model.stavo.ShopProductStaVO;
import edu.nju.desserthouse.service.ProductStaService;
import edu.nju.desserthouse.sort.DisProductStaVOSortByAmount;

public class ProductStaServiceImpl implements ProductStaService{
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
	public ProductStaVO getProductStaVO() {
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> shopList = shopDao.getAllShopList();
		//���е������ܼ�,ֻ��Ҫ������Ʒ���ܼ���Ϣ����,������sql�����
		List<DisProductStaVO> tdpList = orderDao.getTotalDisProductStaVOList();
		Collections.sort(tdpList, new DisProductStaVOSortByAmount());
		for(DisProductStaVO vo:tdpList){
			System.out.println(vo.pid+" "+vo.product+" "+vo.amount);
		}
		
		//ÿ���������ܼ� ����Ҫ��Ʒ��Ϣ�͵���,string��ʾ������
		HashMap<String,List<DisProductStaVO>> dpMap = orderDao.getDisProSta();
		
		//test
		for (Entry<String, List<DisProductStaVO>> entry : dpMap.entrySet()) {
			System.out.println(entry.getKey());
			List<DisProductStaVO> l = entry.getValue();
			for(DisProductStaVO psvo:l){
				System.out.println(psvo.category+" "+psvo.pid+" "+psvo.amount+" "+psvo.sum);
			}
		}
		//test end
		
		//ÿ�����̵��ܼ� ����Ҫ��Ʒ��Ϣ�͵��̣�string��ʾ������
		List<ShopProductStaVO> spList = orderDao.getShopProductStaVOList();
		HashMap<String, List<DisProductStaVO>> spMap = new HashMap<String, List<DisProductStaVO>>();
		for(Shop s:shopList){
			List<DisProductStaVO> l= new ArrayList<DisProductStaVO>();
			spMap.put(s.getSname(),l);
		}
		for(ShopProductStaVO obj:spList){
			DisProductStaVO dpsvo = new DisProductStaVO();
			dpsvo.pid = obj.pid;
			dpsvo.product = obj.product;
			dpsvo.category = obj.category;
			dpsvo.amount =  obj.amount;
			dpsvo.sum = obj.sum;
			spMap.get(obj.shop).add(dpsvo);
		}
		for(ShopProductStaVO obj:spList){
			Collections.sort(spMap.get(obj.shop), new DisProductStaVOSortByAmount());
		}
		//test
		for (Entry<String, List<DisProductStaVO>> entry : spMap.entrySet()) {
			System.out.println(entry.getKey());
			List<DisProductStaVO> l = entry.getValue();
			for(DisProductStaVO psvo:l){
				System.out.println(psvo.category+" "+psvo.pid+" "+psvo.amount+" "+psvo.sum);
			}
		}
		//test end
		
		ProductStaVO psvo = new ProductStaVO(disList,shopList,tdpList,dpMap,spMap);
		return psvo;
	}
	
}
