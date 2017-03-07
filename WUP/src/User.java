
public class User {
	
	private String login;
	
	private String pwd;
	
	
	public String getlogin() {
		return login;
	}


	public void setlogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User(){
		
	}
	
	public User(String login,String password){
		this.login=login;
		this.pwd=password;
	}
	public static boolean log_in(String login, String pwd){
		/*Connect.load();
		return Connect.log_in(login, pwd);*/
		User u=new User(login,pwd);
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<User> ud=adf.getUserDAO();
		boolean result=ud.find(u);
		return result;
		
	}
}

