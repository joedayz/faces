package com.mycompany.filters;

import java.io.IOException;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;


@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter {
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void destroy() {
		this.entityManagerFactory.close();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		EntityManager entityManager = this.entityManagerFactory
				.createEntityManager();
		req.setAttribute("entityManager", entityManager);

		entityManager.getTransaction().begin();

		fc.doFilter(req, res);

		try {
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new ServletException(e.toString());
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("controldvd");
	}
}