package edu.nju.desserthouse.dao;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.Order;
import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;
import edu.nju.desserthouse.model.stavo.CategoryOnlyStaVO;
import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;
import edu.nju.desserthouse.model.stavo.DisProductStaVO;
import edu.nju.desserthouse.model.stavo.DistrictYearRankVO;
import edu.nju.desserthouse.model.stavo.InValidAnalysis;
import edu.nju.desserthouse.model.stavo.ProductSalesStaVO;
import edu.nju.desserthouse.model.stavo.ProductTrendItemVO;
import edu.nju.desserthouse.model.stavo.ShopProductStaVO;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;
import edu.nju.desserthouse.model.stavo.ShopYearRankItemVO;

public interface OrderDao {
	// ��� ���й������۵Ĳ�ѯ�ͼ�¼���������
	public List<ProductSalesStaVO> getProductSalesStaVOList();

	// ���е����ܼ�
	public List<DisProductStaVO> getTotalDisProductStaVOList();

	// ÿ�������ܼ�
	public HashMap<String, List<DisProductStaVO>> getDisProSta();

	// ÿ�������ܼ�
	public List<ShopProductStaVO> getShopProductStaVOList();

	// ������Ʒ����ͳ�Ƶ���Щ����
	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList();

	public List<CateoryProductStaVO> getCateoryProductStaVOList();

	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid);

	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid);

	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid, int sid);

	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid, int sid);

	// ���ڵ���ͳ�Ƶķ���
	// ��ͳ��
	public List<ShopStaItemVO> getDayShopStaItemVOList();// ���е��� ��ͳ��

	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid);// ����ĳ���� ��ͳ��

	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid, int sid);// ����ĳ����
																			// ��ͳ��
	// ��ͳ��

	public List<ShopStaItemVO> getMonthShopStaItemVOList();// ���е��� ��ͳ��

	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid);// ����ĳ���� ��ͳ��

	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid, int sid);// ����ĳ����
																				// ��ͳ��
	// ��ʧ��������

	public InValidAnalysis getInvalidOrderAnalysis();// ���е���

	public InValidAnalysis getInvalidOrderAnalysis(int disid);// ����ĳ����

	public InValidAnalysis getInvalidOrderAnalysis(int disid, int sid);// ����ĳ����
	// ����ĳ��Ʒ��ͳ����Ϣ

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did);// ���е���
																		// ��ͳ��

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid);// ĳ����
																					// ��ͳ��

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid, int sid);// ĳ����
																							// ��ͳ��
	// �����������
	// ���� ���� ����

	public List<ShopYearRankItemVO> getShopYearRank();

	// ������������
	public List<DistrictYearRankVO> getDistrictYearRank();

	// �Զ����ɼƻ�
	// ��һ�¡��ֹۺͱ��۾�������һ��desc һ��asc ���뵱ǰ�·�
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month, String orderType);

	// ��һ�£�����
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month);

	// ��һ�ꡣ�ֹۺͱ��۾�������һ��desc һ��asc 
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid, String orderType);

	// ��һ�꣬����
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid);
	
	/*************************HCI************************/
	public List<Order> getMyOrderList(int cid);
}
