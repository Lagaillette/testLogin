import com.sun.corba.se.pept.transport.Connection;

public class DAOfactory extends AbstractDAOFactory{
	protected static final Connection conn = (Connection)Connect.load();
	
	public DAO getUserDAO(){
		return new UserDAO(conn);
		
	}

	
}
