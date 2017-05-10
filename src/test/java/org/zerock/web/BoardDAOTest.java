package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

 private static Logger logger= org.slf4j.LoggerFactory.getLogger(BoardDAOTest.class);
 
	
	@Inject
	private BoardDAO dao;

	@Test
	public void testCreate()throws Exception{
		BoardVO board= new BoardVO();
		
		board.setTitle("새로운글이 들어갑니다 ");
		board.setContent("새로운 글을 넣습니다");
		board.setWriter("user00");
		dao.create(board);
		
	}
	
	@Test
	public void testRead()throws Exception{
		
		logger.info(dao.read(1).toString());
		
	}
	
	
	@Test
	public void testUpdate()throws Exception{
	
		BoardVO board= new BoardVO();
		board.setBno(1);
		board.setTitle("수정한글이 들어갑니다 ");
		board.setContent("수정한 글을 넣습니다");
		board.setWriter("user123");
		dao.update(board);
		
	}
	
	@Test
	public void testDelete()throws Exception{
		dao.delete(1);
	}
	
	@Test
	public void testList()throws Exception{
		Criteria cri = new Criteria();
		dao.listAll(cri);
	}
	
	
	
	
	
	
}
