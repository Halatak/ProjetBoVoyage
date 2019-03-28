package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerMarkDao;
import fr.adaming.model.ConseillerMarketing;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ConseillerMarkTest {
	
	@Autowired
	private IConseillerMarkDao consMarkDao;
	
	private ConseillerMarketing consMark;
	
	@Before
	public void beforeTest(){
		this.consMark=new ConseillerMarketing(1,"a@a","a",true);
	}
	
	@Test
	@Transactional
	public void getConsMarkByMailTest(){

		ConseillerMarketing consexp=consMarkDao.getConsMarkByMail("a@a");
		
		assertEquals(consexp.toString(), consMark.toString());
	}
}
