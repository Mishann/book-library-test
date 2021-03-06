package com.app.dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Book;
import com.app.utils.HibernateUtil;

public class BookDaoImpl implements BookDao {
	private	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void add(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	public void update(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("delete from Book where id =:id");
		query.setParameter("id", id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	public List<Book> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Book");
		List<Book> books = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return books;
	}

	public Book findOne(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select from Book where id =:id");
		query.setParameter("id", id);
		List<Book> books = query.getResultList();

		session.getTransaction().commit();
		session.close();

		if(books == null)
			return null;
		else 
			return books.get(0);
	}
	public List<Book> findByTitle(String title) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Book where title = :title ");
		query.setParameter("title", title);
		List<Book> books = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return books;
	}

}
