package org.dao.articulo;

import java.util.List;

import org.modelo.articulo.Articulo;
//en esta interfaz se implementa el CRUD para la tabla articulo
public interface DaoArticulo {
	public void addArticulo(Articulo articulo);
	public List<Articulo> listArticulo();
	public Articulo getArticuloById(int id);
	public void deleteArticulo(int id);
}
