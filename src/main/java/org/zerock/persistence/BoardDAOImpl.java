package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	
	@Inject
	SqlSession sess;
	
	private static final String namespace="org.zerock.persistence.BoardDAO";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		sess.insert(namespace+".create",vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return sess.selectOne(namespace+".read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sess.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sess.delete(namespace+".delete",bno);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sess.selectList(namespace+".listAll");
	}

}
