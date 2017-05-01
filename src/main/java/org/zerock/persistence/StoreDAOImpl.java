package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.StoreVO;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Inject
	SqlSession sess;
	
	private static final String namespace="org.zerock.persistence.StoreDAO";
	
	
	@Override
	public String getTime() {
		return sess.selectOne(namespace+".getTime");
	}


	@Override
	public void insertStore(StoreVO vo) {
		sess.insert(namespace+".insert",vo);
		
	}


	@Override
	public StoreVO readStore(int sno) throws Exception {
		
		return (StoreVO)sess.selectOne(namespace+".selectStore",sno);
	}


	@Override
	public StoreVO readWithsname(int sno, String sname) throws Exception {
		
		Map<String,Object> paramMap= new HashMap<String,Object>();
		paramMap.put("sno", sno);
		paramMap.put("sname", sname);
		
		
		return sess.selectOne(namespace+".selectWithsname",paramMap);
	}

}
