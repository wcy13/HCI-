package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.CategoryStaVO;
import edu.nju.desserthouse.service.CategoryStaService;

public class CategoryStaAction extends BaseAction{
	
	@Autowired
	private CategoryStaService categoryStaService;
	private int sid;
	private int disid;
	
	public CategoryStaService getCategoryStaService() {
		return categoryStaService;
	}

	public void setCategoryStaService(CategoryStaService categoryStaService) {
		this.categoryStaService = categoryStaService;
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

	@Override
	public String execute() throws Exception {
		//ÿ�������µ���Ʒ��Ϣ
		//����ͳ����Ϣ
		//��������͵��̣���õ��������̡����ࡢ��Ӧ�ķ���ͳ���б�ÿ�������Ӧ����Ʒͳ���б�
		
		System.out.println("sid:"+sid+";disid:"+disid);
		CategoryStaVO csvo = categoryStaService.getCategorySta(sid, disid);
		request.setAttribute("csvo", csvo);
		request.setAttribute("sid", sid);
		request.setAttribute("disid", disid);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "categorySta";
		}else if(type.equals("ZJL")){
			return "categoryStaZJL";
		}
		return "login";
	}
}
