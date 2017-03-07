

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	//Retourne un objet User interagissant avec la BDD
	public abstract DAO<User> getUserDAO();



	//Méthode permettant de récupérer les Factory
	public static AbstractDAOFactory getFactory(int type){
		return new DAOfactory();
	}
}

