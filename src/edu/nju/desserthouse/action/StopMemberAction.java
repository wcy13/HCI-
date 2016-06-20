package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class StopMemberAction extends BaseAction {
	@Autowired
	private MemberService memberService;
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		Member member = memberService.findMemberById(id);
		member.setState(3);
		memberService.updateMember(member);
		session.setAttribute("member", member);
		return "stoppedMember";
	}
}
