package pe.joedayz.ejemplos.cinedayz.core;


import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;

/**
 *
 * @author hsaira
 */
public class Busqueda implements CriteriaSpecification, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final CriteriaImpl impl;
    private final Criteria criteria;

    private int maxResults = 100;
    public int getMaxResults() { return maxResults; }
    public void setMaxResults(int maxResults) { this.maxResults = maxResults; }

    private int firstResult = 0;
    public int getFirstResult() { return firstResult; }
    public void setFirstResult(int firstResult) { this.firstResult = firstResult; }

    protected Busqueda(String entityName) {
        impl = new CriteriaImpl(entityName, null);
        criteria = impl;
    }
    protected Busqueda(String entityName, String alias) {
        impl = new CriteriaImpl(entityName, alias, null);
        criteria = impl;
    }
    protected Busqueda(CriteriaImpl impl, Criteria criteria) {
        this.impl = impl;
        this.criteria = criteria;
    }

    public Criteria getExecutableCriteria(Session session) {
		impl.setSession( ( SessionImplementor ) session );
		return impl;
	}
    public static Busqueda forEntityName(String entityName) {
		return new Busqueda(entityName);
	}
	public static Busqueda forEntityName(String entityName, String alias) {
		return new Busqueda(entityName, alias);
	}
	public static Busqueda forClass(Class clazz) {
		return new Busqueda( clazz.getName() );
	}
	public static Busqueda forClass(Class clazz, String alias) {
		return new Busqueda( clazz.getName() , alias );
	}
    public Busqueda add(Criterion criterion) {
		criteria.add(criterion);
		return this;
	}
	public Busqueda addOrder(Order order) {
		criteria.addOrder(order);
		return this;
	}
	public Busqueda createAlias(String associationPath, String alias) throws HibernateException {
		criteria.createAlias(associationPath, alias);
		return this;
	}
	public Busqueda createCriteria(String associationPath, String alias) throws HibernateException {
		return new Busqueda( impl, criteria.createCriteria(associationPath, alias) );
	}
	public Busqueda createCriteria(String associationPath) throws HibernateException {
		return new Busqueda( impl, criteria.createCriteria(associationPath) );
	}
	public String getAlias() {
		return criteria.getAlias();
	}

	public Busqueda setFetchMode(String associationPath, FetchMode mode) throws HibernateException {
		criteria.setFetchMode(associationPath, mode);
		return this;
	}
	public Busqueda setProjection(Projection projection) {
		criteria.setProjection(projection);
		return this;
	}
	public Busqueda setResultTransformer(ResultTransformer resultTransformer) {
		criteria.setResultTransformer(resultTransformer);
		return this;
	}
    @Override
	public String toString() {
		return "Busqueda(" + criteria.toString() + ')';
	}
	CriteriaImpl getCriteriaImpl() {
		return impl;
	}
    public Busqueda createAlias(String associationPath, String alias, int joinType) throws HibernateException {
        criteria.createAlias(associationPath, alias, joinType);
        return this;
    }
    public Busqueda createCriteria(String associationPath, int joinType) throws HibernateException {
        return new Busqueda(impl, criteria.createCriteria(associationPath, joinType));
    }
    public Busqueda createCriteria(String associationPath, String alias, int joinType) throws HibernateException {
        return new Busqueda(impl, criteria.createCriteria(associationPath, alias, joinType));
    }
    public Busqueda setComment(String comment) {
        criteria.setComment(comment);
        return this;
    }
    public Busqueda setLockMode(LockMode lockMode) {
        criteria.setLockMode(lockMode);
        return this;
    }
    public Busqueda setLockMode(String alias, LockMode lockMode) {
        criteria.setLockMode(alias, lockMode);
        return this;
    }

}