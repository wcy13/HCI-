package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ShopStaVO;
import edu.nju.desserthouse.service.ShopStaService;

public class ShopStaAction extends BaseAction{
	
	@Autowired
	private ShopStaService shopStaService;
	private int sid;
	private int disid;
	private int choice;//����1������ͳ�ƣ�2������ͳ��

	public ShopStaService getShopStaService() {
		return shopStaService;
	}

	public void setShopStaService(ShopStaService shopStaService) {
		this.shopStaService = shopStaService;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getDisid() {
		return disid;
	}

	public void setDisid(int disid) {
		this.disid = disid;
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
		
		System.out.println("sid:"+sid+";disid:"+disid+";choice:"+choice);
		ShopStaVO ssvo = shopStaService.getShopSta(sid, disid, choice);
		request.setAttribute("ssvo", ssvo);
		request.setAttribute("sid", sid);
		request.setAttribute("disid", disid);
		request.setAttribute("choice", choice);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "shopSta";
		}else if(type.equals("ZJL")){
			return "shopStaZJL";
		}
		return "login";
	}
}
