package pe.joedayz.ejemplos.persistence.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import pe.joedayz.ejemplos.persistence.dao.IUserDao;
import pe.joedayz.ejemplos.persistence.entity.User;
import org.ploin.utils.annotation.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDao extends GenericDao<User, Long> implements IUserDao{

	private static Log log = LogFactory.getLog(UserDao.class);

	@Transactional(readOnly = true)
	public User getByUserName(@NotNull final String userName) {
		try {
			Query query = getSession().createQuery(
					"FROM User where userName = :name");
			query.setString("name", userName);
			return (User) query.uniqueResult();
		} catch (Exception e) {
			log.error(" ERROR Exception in getByUserName(String userName ", e);
			return null;
		}
	}

	@Transactional(readOnly = true)
	public User getByLoginInformation(@NotNull final String userName, @NotNull final String password) {
		try {
			Query query = getSession().createQuery(
					"FROM User where userName = :name AND password = :pass AND enabled = :en");
			query.setString("name", userName);
			query.setString("pass", password);
			query.setBoolean("en", Boolean.TRUE);
			return (User) query.uniqueResult();
		} catch (Exception e) {
			log.error(" ERROR Exception in getByLoginInformation(final String userName, final String password)", e);
			return null;
		}
	}

}
