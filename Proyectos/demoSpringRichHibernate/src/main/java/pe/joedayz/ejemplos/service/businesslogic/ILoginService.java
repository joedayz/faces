package pe.joedayz.ejemplos.service.businesslogic;

import pe.joedayz.ejemplos.persistence.entity.User;

public interface ILoginService {

	User getByLoginInformation(String username, String password);

}
