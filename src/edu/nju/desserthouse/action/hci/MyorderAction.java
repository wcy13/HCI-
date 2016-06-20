package edu.nju.desserthouse.action.hci;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.action.BaseAction;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.hci.MyorderVO;
import edu.nju.desserthouse.service.MyorderService;

public class MyorderAction extends BaseAction{
	@Autowired
	private MyorderService myorderService;
	
	public MyorderService getMyorderService() {
		return myorderService;
	}

	public void setMyorderService(MyorderService myorderService) {
		this.myorderService = myorderService;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession(true);
		Member m = (Member) session.getAttribute("memberInfo");
		//��øÿͻ�������order��ÿ��oid��Ӧ��orderdetail������dessert����չʾ��
		//һ��List<Order>��һ��hashmap<oid,List<OrderDetail>>
		MyorderVO movo = myorderService.getMyorderVO(m.getCid());
		request.setAttribute("movo", movo);
		return "myorder";
	}
	
}
