package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;

public interface PlanAutoGenerateService {
	//���ݵ��� ���ذ�Ҫ���õļƻ�(����������Ʒ-������⡪��������һ��������)
	//�����е�һ��list��ʾһ��ļƻ���list�е�һ����Ŀ��ʾһ����Ʒ�ļƻ�
	public List<List<AutoGeneratingPlanItem>> getAutoGeneratingPlan(int sid,int range,int type);
}
