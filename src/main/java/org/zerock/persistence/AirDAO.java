package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zerock.domain.AirVO;


public interface AirDAO {

  public void create(AirVO vo) throws Exception;

  public List<AirVO> read(String uhome) throws Exception;

 
  public List<AirVO> listAll() throws Exception;

  
  

  

}
