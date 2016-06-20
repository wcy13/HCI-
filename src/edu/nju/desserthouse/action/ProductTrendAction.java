package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ProductTrendVO;
import edu.nju.desserthouse.service.ProductTrendService;

public class ProductTrendAction extends BaseAction {

	@Autowired
	private ProductTrendService productTrendService;
	private int sid;
	private int disid;
	private int did = 1;

	public ProductTrendService getProductTrendService() {
		return productTrendService;
	}

	public void setProductTrendService(ProductTrendService productTrendService) {
		this.productTrendService = productTrendService;
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

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public String execute() throws Exception {
		// ÿ�������µ���Ʒ��Ϣ
		// ����ͳ����Ϣ
		// ��������͵��̣���õ��������̡����ࡢ��Ӧ�ķ���ͳ���б�ÿ�������Ӧ����Ʒͳ���б�

		System.out.println("sid:" + sid + ";disid:" + disid+";did:"+did);
		ProductTrendVO ptvo = productTrendService.getProductTrend(sid, disid, did);
		request.setAttribute("ptvo", ptvo);
		request.setAttribute("sid", sid);
		request.setAttribute("disid", disid);
		request.setAttribute("did", did);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "productTrend";
		}else if(type.equals("ZJL")){
			return "productTrendZJL";
		}
		return "login";
	}
}
