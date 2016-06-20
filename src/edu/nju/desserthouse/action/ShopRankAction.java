package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ShopRankVO;
import edu.nju.desserthouse.service.ShopRankService;

public class ShopRankAction extends BaseAction{
	
	@Autowired
	private ShopRankService shopRankService;
	private int choice;//����1������ͳ�ƣ�2������ͳ��


	public ShopRankService getShopRankService() {
		return shopRankService;
	}


	public void setShopRankService(ShopRankService shopRankService) {
		this.shopRankService = shopRankService;
	}


	public int getChoice() {
		return choice;
	}


	public void setChoice(int choice) {
		this.choice = choice;
	}


	@Override
	public String execute() throws Exception {
		//ÿ�������µ���Ʒ��Ϣ
		//����ͳ����Ϣ
		//��������͵��̣���õ��������̡����ࡢ��Ӧ�ķ���ͳ���б�ÿ�������Ӧ����Ʒͳ���б�
		
		System.out.println("choice:"+choice);
		ShopRankVO srvo = shopRankService.getShopRankVO(choice);
		request.setAttribute("srvo", srvo);
		request.setAttribute("choice", choice);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "shopRank";
		}else if(type.equals("ZJL")){
			return "shopRankZJL";
		}
		return "login";
	}
}
