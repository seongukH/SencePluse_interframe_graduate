package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.NewsVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class NewsDAOImpl implements NewsDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.NewsMapper";

  

  
  public List<NewsVO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }


  

}
