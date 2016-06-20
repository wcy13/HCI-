package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ProductCategoryDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.ProductCategory;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.CategoryOnlyStaVO;
import edu.nju.desserthouse.model.stavo.CategoryStaVO;
import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;
import edu.nju.desserthouse.model.stavo.ProductOnlyStaVO;
import edu.nju.desserthouse.service.CategoryStaService;
import edu.nju.desserthouse.sort.CateoryProductStaVOSortByAmount;

public class CategoryStaServiceImpl implements CategoryStaService{
	@Autowired
	private OrderDao orderDao;
	private DistrictDao districtDao;
	private ShopDao shopDao;
	private ProductCategoryDao productCategoryDao;
	
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

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	@Override
	//��������category��������
	//����������е���Ʒͳ�ƣ�Ȼ���ٸ��hashmap���� ���category list��Ӧչʾ,չʾ�Ķ�������ϸ�ķ��࣬��˵���listҪ������
	public CategoryStaVO getCategorySta(int sid, int disid) {
		List<Shop> shopList = new ArrayList<Shop>();
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> sl = shopDao.getAllShopList();
		
		List<ProductCategory> pcList = productCategoryDao.getAllProductCategoryList();
		List<CategoryOnlyStaVO> coList;
		//to be ��һ������
		List<CateoryProductStaVO> cpList;
		//��������е����ܼ�
		if(disid==0){
			coList = orderDao.getCategoryOnlyStaVOList();
			cpList = orderDao.getCateoryProductStaVOList();
			//shopֻ��һ���ܵ�
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("���е���");
			shopList.add(s);
		}
		//ĳ�����ܼ�
		else if(disid!=0&&sid==0){
			coList = orderDao.getCategoryOnlyStaVOList(disid);
			cpList = orderDao.getCateoryProductStaVOList(disid);
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
		//ĳ�����ܼ�
		else{
			coList = orderDao.getCategoryOnlyStaVOList(disid,sid);
			cpList = orderDao.getCateoryProductStaVOList(disid,sid);
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
		//����
		Collections.sort(cpList, new CateoryProductStaVOSortByAmount());
		//����Ʒ�������
		HashMap<String,List<ProductOnlyStaVO>> cpMap = new HashMap<String,List<ProductOnlyStaVO>>();
		Iterator<ProductCategory> it = pcList.iterator();
		while (it.hasNext())
		{
			ProductCategory pc = it.next();
			if(pc.getPcid()!= 2){
				List<ProductOnlyStaVO> list = new ArrayList<ProductOnlyStaVO>();
				cpMap.put(pc.getPcname(), list);
			}else{
				it.remove();
			}

		}
		/* wrong
		for(ProductCategory pc:pcList){
			if(pc.getPcid()!= 2){
				List<ProductOnlyStaVO> list = new ArrayList<ProductOnlyStaVO>();
				cpMap.put(pc.getPcname(), list);
			}else{
				pcList.remove(pc);
			}
		}
		*/
		for(CateoryProductStaVO cpvo:cpList){
			ProductOnlyStaVO posvo = new ProductOnlyStaVO();
			posvo.did = cpvo.did;
			posvo.dname = cpvo.dname;
			posvo.amount = cpvo.amount;
			posvo.sum = cpvo.sum;
			cpMap.get(cpvo.pcname).add(posvo);
		}
		CategoryStaVO csvo = new CategoryStaVO(disList,shopList,pcList,coList,cpMap);
		return csvo;
	}

}
