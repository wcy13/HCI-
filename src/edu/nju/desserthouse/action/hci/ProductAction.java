package edu.nju.desserthouse.action.hci;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.action.BaseAction;
import edu.nju.desserthouse.service.DessertService;
/**
 * ��Ʒ��ҳ
 */
public class ProductAction extends BaseAction{
	@Autowired
	private DessertService dessertService;//���������Ʒ����Ʒ�����dao����չʾ
	
	public DessertService getDessertService() {
		return dessertService;
	}

	public void setDessertService(DessertService dessertService) {
		this.dessertService = dessertService;
	}

	@Override
	public String execute() throws Exception {
		return "product";
	}
	
}
