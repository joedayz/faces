package pe.joedayz.ejemplos.persistence.dao;

import pe.joedayz.ejemplos.persistence.entity.User;


public interface IUserDao extends IGenericDao<User, Long>{


	User getByUserName(String userName);

	User getByLoginInformation(String userName, String password);


}
