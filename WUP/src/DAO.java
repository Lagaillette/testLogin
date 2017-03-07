

import java.sql.Connection;


public abstract class DAO<T> {
	protected Connection connect= null;
	
	public DAO(com.sun.corba.se.pept.transport.Connection conn){
	    this.connect = (Connection) conn;
	}


	/**
	 * M�thode de cr�ation
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean create(T obj);

	/**
	 * M�thode pour effacer
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean delete(T obj);

	/**
	 * M�thode de mise � jour
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * M�thode de recherche des informations
	 * @param login
	 * @return T
	 */
	public abstract boolean find(T login);
}

