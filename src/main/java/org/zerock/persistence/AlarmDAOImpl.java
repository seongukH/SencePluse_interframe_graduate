package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.AirVO;
import org.zerock.domain.AlarmVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class AlarmDAOImpl implements AlarmDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.AlarmMapper";

  
  public void create(AlarmVO vo) throws Exception{
	    session.insert(namespace + ".create", vo);

  }

  public List<AlarmVO> read(String uhome) throws Exception{
	    return session.selectList (namespace + ".read", uhome);

  }

 
  public void delete(String sno) throws Exception{
	  session.delete(namespace + ".delete",  sno);
  }
  
  
  public void updateStartAlarm(String hour, String minute) throws Exception{
	  Map<String, Object> paramMap = new HashMap<String, Object>();
	  paramMap.put("hour", hour);
	  paramMap.put("minute", minute);
	  
	  session.update(namespace + ".updateStartAlarm", paramMap);
  }

public void updateEndAlarm(String hour, String minute) throws Exception{
	  Map<String, Object> paramMap = new HashMap<String, Object>();
	  paramMap.put("hour", hour);
	  paramMap.put("minute", minute);
	  session.update(namespace + ".updateEndAlarm", paramMap);
  }


}
