package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerClientDao;
import fr.adaming.model.ConseillerClientele;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ConseillerClientTest {

	@Autowired
	private IConseillerClientDao consClDao;

	private ConseillerClientele consCl;

	@Before
	public void beforeTest() {
		this.consCl = new ConseillerClientele(1, "c@c", "c", true);
	}

	@Test
	@Transactional
	public void getConsClientByMailTest() {

		ConseillerClientele consexp = consClDao.getConsClientByMail("c@c");

		assertEquals(consexp.toString(), consCl.toString());
	}
}
