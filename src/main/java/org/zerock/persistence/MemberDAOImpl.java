package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"org.zerock.mapper.MemberMapper";
	
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}
	
	@Override
	public MemberVO loginCheck(MemberVO vo){
		
		return sqlSession.selectOne(namespace+".loginCheck", vo);
		//String name = sqlSession.selectOne(namespace+".loginCheck", vo);
        //return (name == null) ? false : true;
	}
	
	@Override
	public List<MemberVO> listAll(){
		return sqlSession.selectList(namespace+".listAll");
       
	}
	
	@Override
	public List<MemberVO> search(String searchType, String word){
		return sqlSession.selectList(namespace+"search");
	}
	
	@Override
	public void delete(String userId){
		sqlSession.delete(namespace+".delete", userId);
	}
	@Override
	  public MemberVO read(Integer userNo) throws Exception {
	    return sqlSession.selectOne(namespace + ".read", userNo);
	  }
	
	@Inject
    MemberDAO memberDao;
	
	
	@Override
    public boolean loginCheck(MemberVO vo, HttpSession session) {
        boolean result = memberDao.loginCheck(vo, session);
        if (result) { // true일 경우 세션에 등록
            MemberVO vo2 = viewMember(vo);
            // 세션 변수 등록
            session.setAttribute("userId", vo2.getUid());
            session.setAttribute("userName", vo2.getUname());
        } 
        return result;
    }
	@Override
	public MemberVO viewMember(MemberVO vo) {
        return memberDao.viewMember(vo);
    }
	
	public void updateMember(MemberVO vo) {
		sqlSession.selectOne(namespace + ".updateMember", vo);
	}

	

	
}














