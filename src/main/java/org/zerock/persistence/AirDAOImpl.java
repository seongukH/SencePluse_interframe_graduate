package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.AirVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class AirDAOImpl implements AirDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.AirMapper";

  
  public void create(AirVO vo) throws Exception {
    session.insert(namespace + ".create", vo);
  }

  
  public List<AirVO> read(String uhome) throws Exception {
    return session.selectList (namespace + ".read", uhome);
  }

  

  
  public List<AirVO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }


  

}
