package pe.joedayz.ejemplos.cinedayz.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author hsaira
 */
public abstract class GenericoDAO<Entidad, Id extends Serializable> extends HibernateDaoSupport {

    protected Class<Entidad> clase;

    @SuppressWarnings("unchecked")
    public GenericoDAO() {
        super();
        this.clase = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Entidad crear(Entidad entidad) {
        getHibernateTemplate().saveOrUpdate(entidad);
        return entidad;
    }
    @SuppressWarnings("unchecked")
	public Entidad obtener(Id id) {
        return (Entidad)getHibernateTemplate().get(this.clase, id);
    }
    public Entidad modificar(Entidad entidad) {
        getHibernateTemplate().update(entidad);
        return entidad;
    }
    public void eliminar(Entidad entidad) {
        getHibernateTemplate().delete(entidad);
    }

    @SuppressWarnings("unchecked")
	public List<Entidad> obtenerLista(final Busqueda filtro) {
        return (List<Entidad>)this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria busqueda = filtro.getExecutableCriteria(session);
                busqueda.setFirstResult(((Busqueda)filtro).getFirstResult());
                if (filtro.getMaxResults() > 0)
                    busqueda.setMaxResults(((Busqueda)filtro).getMaxResults());
                return (List<Entidad>)busqueda.list(); 
            }
        });
    }
    public Integer obtenerTamanho(final Busqueda filtro) {
        return (Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Projection total = Projections.rowCount();
                filtro.setProjection(total);
                Integer resultado = (Integer)filtro.getExecutableCriteria(session).uniqueResult();
                filtro.setProjection(null);
                return resultado;
            }
        });
    }

}