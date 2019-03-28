package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })

public class VoyageDaoTest {
	
	// transformation uml en java
	private IGeneriqueDao<Voyage> vDao;
	private IVoyageDao voyDao;

	// setters
	@Autowired
	public void setVoyageDao(IGeneriqueDao<Voyage> voyageDao) {
		this.vDao = voyageDao;
		voyageDao.setClazz(Voyage.class);
	}

	// Vérifier la taille de la liste retournée
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeVoyageDao() {

		int tailleTheo = 3;

		// récupérer la taille de la liste
		int tailleReelle = voyDao.afficherListeVoyageDao().size();

		assertEquals(tailleTheo, tailleReelle);
	}

	// Vérifier l'ajout d'un voyage par taille de liste de BdD
	@Test
	@Transactional
	@Rollback(true)
	public void testAddVoyage1() {

		Voyage voyageTest = new Voyage(new Date(), new Date(), true, 10, 20);

		int tailleReelle = 3;

		vDao.ajout(voyageTest);
		
		assertEquals(tailleReelle+1, voyDao.afficherListeVoyageDao().size());
	}
}
