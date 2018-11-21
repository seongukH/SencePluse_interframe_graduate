package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zerock.domain.AirVO;
import org.zerock.domain.AlarmVO;


public interface AlarmDAO {

  public void create(AlarmVO vo) throws Exception;

  public List<AlarmVO> read(String uhome) throws Exception;

 
  public void delete(String sno) throws Exception;

  
  public void updateStartAlarm(String hour, String minute) throws Exception;
  public void updateEndAlarm(String hour, String minute) throws Exception;

  

}
