package pe.joedayz.ejemplos.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;


public interface IGenericDao<T, ID extends Serializable>  {

	T findById(ID id, boolean lock);

	T getById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance, String... excludeProperty);

	T makePersistent(T entity);

	void makeTransient(T entity);

	void update(Object o) throws DataAccessException;

}
