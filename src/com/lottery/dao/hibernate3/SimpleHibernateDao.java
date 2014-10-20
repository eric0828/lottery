package com.lottery.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

@SuppressWarnings("unchecked")
public class SimpleHibernateDao<T, PK extends Serializable> extends HibernateDaoSupport {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected Class<T> entityClass;

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public SimpleHibernateDao() {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            logger.warn(getClass().getSimpleName() + "'s superclass not ParameterizedType");
            this.entityClass = (Class<T>) Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (!(params[0] instanceof Class)) {
            logger.warn(getClass().getSimpleName() + " not set the actual class on superclass generic parameter");
            this.entityClass = (Class<T>) Object.class;
        }
		this.entityClass = (Class) params[0];
	}

	public SimpleHibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		setSessionFactory(sessionFactory);
		this.entityClass = entityClass;
	}

	public Serializable save(final T entity) {
		logger.debug("save entity: {}", entity);
		BussinessEntity bussinessEntity = (BussinessEntity) entity;
		return getHibernateTemplate().save(bussinessEntity);
	}

	public void saveOrUpdate(final T entity) {
		Assert.notNull(entity, "entity can't be null");
		BussinessEntity bussinessEntity = (BussinessEntity) entity;
		getHibernateTemplate().saveOrUpdate(bussinessEntity);
		logger.debug("saveOrUpdate entity: {}", entity);
	}

	public Object merge(final T entity) {
		Assert.notNull(entity, "entity can't be null");
		logger.debug("merge entity: {}", entity);
		return getHibernateTemplate().merge(entity);
	}

	public void update(final T entity) {
		Assert.notNull(entity, "entity can't be null");
		BussinessEntity bussinessEntity = (BussinessEntity) entity;
		getHibernateTemplate().update(bussinessEntity);
		logger.debug("update entity: {}", entity);
	}

	public void delete(final T entity) {
		Assert.notNull(entity, "entity can't be null");
		getHibernateTemplate().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	public void delete(final PK id) {
		Assert.notNull(id, "id can't be null");
		delete(get(id));
		logger.debug("delete entity {},id is {}", entityClass.getSimpleName(), id);
	}

	public T get(final PK id) {
		Assert.notNull(id, "id can't be null");
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	public List<T> getAll() {
		return find();
	}

	public List<T> getAll(String orderBy, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderBy));
		} else {
			c.addOrder(Order.desc(orderBy));
		}
		return c.list();
	}

	public List<T> findBy(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName can't be null");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
	}

	public T findUniqueBy(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName can't be null");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(criterion).uniqueResult();
	}

	public List<T> findByIds(List<PK> ids) {
		return find(Restrictions.in(getIdName(), ids));
	}

	public <X> List<X> find(final String hql, final Object... values) {
		return createQuery(hql, values).list();
	}

	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString can't be null");
		Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
		if (values != null) {
			int k = 0;
			for (int i = 0; i < values.length; i++) {
				if (!"".equals(values[i]) && null != values[i]) {
					query.setParameter(k, values[i]);
					k++;
				}
			}
		}
		return query;
	}

	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString can't be null");
		Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	public List<T> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	public T findUnique(final Criterion... criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	public void initEntity(T entity) {
		Hibernate.initialize(entity);
	}

	public void initEntity(List<T> entityList) {
		for (T entity : entityList) {
			Hibernate.initialize(entity);
		}
	}

	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}
}