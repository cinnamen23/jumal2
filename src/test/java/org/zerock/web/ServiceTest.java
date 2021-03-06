package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ServiceTest {

	@Inject
	private BoardService service;
	
	
	@Test
	public void getlistTest()throws Exception{
		Criteria cri = new Criteria();
		service.listAll(cri);
		
	}
	
	
	 
}
