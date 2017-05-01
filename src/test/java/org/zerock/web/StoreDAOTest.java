package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.StoreVO;
import org.zerock.persistence.StoreDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class StoreDAOTest {

	
	@Inject
	private StoreDAO dao;
	
	@Test
	public void testTime()throws Exception{
		
		dao.getTime();
		
	}
	
	@Test
	public void insertTest(){
		
		StoreVO vo = new StoreVO();
		vo.setSname("승규네 갈비집");
		vo.setLat(37.451222);
		vo.setLng(127.54548);
		vo.setInfo("만두중에 최고 ");
		
		dao.insertStore(vo);
		
	}
	
	
	
}
