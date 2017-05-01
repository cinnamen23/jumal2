package org.zerock.persistence;

import org.zerock.domain.StoreVO;

public interface StoreDAO {
	
	public String getTime();
	
	public void insertStore(StoreVO vo);

	public StoreVO readStore(int sno)throws Exception;
	
	public StoreVO readWithsname(int sno,String sname)throws Exception;
	
}
