package org.action.articulo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.articulo.DaoArticulo;
import org.dao.articulo.DaoImpArticulo;
import org.hibernate.sql.Delete;
import org.modelo.articulo.Articulo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionArticulo extends ActionSupport implements ModelDriven<Articulo>{
	private Articulo articulo = new Articulo();
	private DaoArticulo dao = new DaoImpArticulo();
	private List<Articulo> listArticulo = new ArrayList<Articulo>();
	
	public String execute() {
		return SUCCESS;
	}
	public String add() {
		dao.addArticulo(articulo);
		return SUCCESS;
	}
	public String list() {
		setListArticulo(dao.listArticulo());
		return SUCCESS;
	}
	public String edita() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		articulo = dao.getArticuloById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	public String Delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.deleteArticulo(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	
	@Override
	public Articulo getModel() {
		// TODO Auto-generated method stub
		return articulo;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public List<Articulo> getListArticulo() {
		return listArticulo;
	}
	public void setListArticulo(List<Articulo> listArticulo) {
		this.listArticulo = listArticulo;
	}
	
}
