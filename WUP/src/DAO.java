

import java.sql.Connection;


public abstract class DAO<T> {
	protected Connection connect= null;
	
	public DAO(com.sun.corba.se.pept.transport.Connection conn){
	    this.connect = (Connection) conn;
	}


	/**
	 * Méthode de création
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode pour effacer
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean delete(T obj);

	/**
	 * Méthode de mise à jour
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * Méthode de recherche des informations
	 * @param login
	 * @return T
	 */
	public abstract boolean find(T login);
}

