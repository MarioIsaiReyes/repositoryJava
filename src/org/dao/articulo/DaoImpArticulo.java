package org.dao.articulo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.articulo.Articulo;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImpArticulo implements DaoArticulo {
	
	@SessionTarget
	private Session session;
	@TransactionTarget
	private Transaction transaction;
	
	@Override
	public void addArticulo(Articulo articulo) {
		try {
			session.saveOrUpdate(articulo);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

	}

	@Override
	public List<Articulo> listArticulo() {
		List<Articulo> list = null;
		try {
			list= (List<Articulo>) session.createQuery("from Articulo").list();
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return list;
	}

	@Override
	public Articulo getArticuloById(int id) {
		Articulo articulo = null;
		try {
			articulo = (Articulo) session.get(Articulo.class, id);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return articulo;
	}

	@Override
	public void deleteArticulo(int id) {
		Articulo articulo = null;
		try {
			articulo = (Articulo) session.get(Articulo.class, id);
			session.delete(articulo);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

	}

}
