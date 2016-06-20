package edu.nju.desserthouse.model.hci;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;

//һ�������б�һ�������б�һ�������͵����б��hashmap��Ϊ����
public class ShopListVO {
	public List<Shop> shopList;
	public List<District> districtList;
	public HashMap<Integer,List<Shop>> dpMap;
	public ShopListVO(){}
	public ShopListVO(List<Shop> shopList, List<District> districtList, HashMap<Integer, List<Shop>> dpMap) {
		super();
		this.shopList = shopList;
		this.districtList = districtList;
		this.dpMap = dpMap;
	}
	
}
