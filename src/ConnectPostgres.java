
/**
 * @author devendra
 * 
 */

/**
 * import statements
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectPostgres {

	/**
	 * @param args
	 */
	static final String DB_DATABASE_SID = "postgres";
	static final String DB_LOCATION = "localhost";
	static final String DB_LISTENING_PORT = "5432";
	static final String DB_USER = "postgres";
	static final String DB_PASSWORD = "hector009";
	
	
	public static void main(String[] devs) {
		// TODO Auto-generated method stub
		
		System.out.println("---- Connecting the Postgres database using the JDBC Driver ----");
		
		try {
			Class.forName("org.postgresql.Driver");
			
		}	catch(ClassNotFoundException de)	{
			System.out.println("Please place your driver in the build location. ");
			de.printStackTrace();
			
			return;
		}
		
		System.out.println("PostgreSQL driver registered.\n\n");
		
		// Create a Connection Object
		Connection connection = null;
		
		// Create a connection String and making a connection
		try	{
			connection = DriverManager.getConnection("jdbc:postgresql://"+DB_LOCATION+ ":"+DB_LISTENING_PORT+"/"+DB_DATABASE_SID, 
					DB_USER, DB_PASSWORD);
		}	catch(SQLException deS)	{
			System.out.println("Connection Failed ! Check output console");
			deS.printStackTrace();
			return;
		}
		
		if (connection != null)	{
			System.out.println("Connection Successful ! Take the control.");
		}else	{
			System.out.println("Failed to make connection");
		}
		
		
	}

}
