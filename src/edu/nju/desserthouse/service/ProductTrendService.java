package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.ProductTrendVO;

public interface ProductTrendService {
	//������� �����̡���Ʒid�����ض�Ӧ����Ʒͳ�ƣ���Ȼ��Ҫ���ϵ��̡���������Ʒ�б�
	public ProductTrendVO getProductTrend(int sid,int disid,int did);
}
