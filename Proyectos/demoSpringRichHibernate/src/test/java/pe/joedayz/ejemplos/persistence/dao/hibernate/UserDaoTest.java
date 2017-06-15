package pe.joedayz.ejemplos.persistence.dao.hibernate;

import pe.joedayz.ejemplos.persistence.dao.IUserDao;
import pe.joedayz.ejemplos.persistence.entity.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;


@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	User user = new User();
	private static String userName = "one4Test";
	private static String firstName = "Hilde";
	private static String lastName = "Halde";
	
	@Resource
    private IUserDao userDao;

	@BeforeClass
	public void contextInit(){
		user.setId(null);
		user.setSex(Boolean.TRUE);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail("hilde@gmx.de");
		user.setUserName(userName);
		user.setPassword("reiz");
		user.setEnabled(Boolean.TRUE);
		userDao.makePersistent(user);
	}

	@Test
    public void testfindPersisted(){
		user = userDao.getByUserName(userName);
		assertNotNull(user);
		assertNotNull(user.getId());
	}

	@Test(dependsOnMethods = {"testfindPersisted"})
	public void getByLoginInformation(){
		User user = userDao.getByLoginInformation(userName, "reiz");
		assertNotNull(user);
	}

	@Test(dependsOnMethods = {"getByLoginInformation"})
	public void saveUser(){
		User user = userDao.getByLoginInformation(userName, "reiz");
		user.setEnabled(Boolean.FALSE);
		user = userDao.makePersistent(user);
		assertNotNull(user);
	}

	@Test(dependsOnMethods = {"saveUser"})
	public void getByLoginInformation3(){
		User user = userDao.getByLoginInformation(null, null);
		assertNull(user);
	}

}