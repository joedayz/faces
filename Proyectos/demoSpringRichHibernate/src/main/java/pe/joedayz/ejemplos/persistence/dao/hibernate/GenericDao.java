package pe.joedayz.ejemplos.persistence.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import pe.joedayz.ejemplos.persistence.dao.IGenericDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public abstract class GenericDao <T, ID extends Serializable> extends HibernateTemplate implements IGenericDao<T, ID>, Serializable{

	private Class<T> persistentClass;

	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}


	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) getSession().load(getPersistentClass(), id);

		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T getById(ID id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) getSession().get(getPersistentClass(), id);

		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Transactional
	public void makeTransient(T entity) {
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

}
