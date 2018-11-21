package org.zerock.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zerock.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
	public List<MemberVO> listAll();
	public List<MemberVO> search(String searchType, String word);
	public void delete(String userId);
	public MemberVO read(Integer userNo) throws Exception;
	
	public boolean loginCheck(MemberVO vo, HttpSession session);
	public MemberVO viewMember(MemberVO vo);
	
	public void updateMember(MemberVO vo);
}
