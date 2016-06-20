package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.model.stavo.MemberStaVO;

public interface MemberDao {
	/*
	 * �����ݿ��в���һ��member��¼
	 */
	public void save(Member member);
	
	
	/*
	 * ����id����member����,����ҵ��򷵻��������,���򷵻�null
	 */
	public Member find(int id);
	
	
	/*
	 * ����id����member���һ����¼
	 */
	public void updateByUserid(Member member);
	/*
	 * �������Ԫ��
	 */
	public List<Member> getAllMemberList();
	/*
	 * ���ݿͻ��ȼ���month��ö�Ӧ���пͻ���ÿ������ͳ��
	 */
	public List<MemberMonthStaVO> getmmsList(int level,int month);
	/*
	 * ��Ա��������
	 */
	public  List<List<MemberStaVO>> getMemberSta();
	
}
