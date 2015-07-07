

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDB {
	
	private static String DB_DATABASE_SID;
	private static String DB_LOCATION = "localhost";
	private static String DB_LISTENING_PORT;
	private static String DB_USER;
	private static String DB_PASSWORD;
	private static String connURL;
	
	private static Connection databaseConn = null;
	private Statement dbStatement = null;
	private ResultSet dbResultSet = null;
	
	
	ConnectDB (String dB_DATABASE_SID, String dB_LOCATION, String dB_LISTENING_PORT, String dB_USER, String dB_PASSWORD)	{
		setDB_DATABASE_SID(dB_DATABASE_SID);
		setDB_LOCATION(dB_LOCATION);
		setDB_LISTENING_PORT(dB_LISTENING_PORT);
		setDB_USER(dB_USER);
		setDB_PASSWORD(dB_PASSWORD);		
	}
	
	protected static void setDB_DATABASE_SID(String dB_DATABASE_SID) {
		DB_DATABASE_SID = dB_DATABASE_SID;
	}
	protected static void setDB_LOCATION(String dB_LOCATION) {
		DB_LOCATION = dB_LOCATION;
	}
	protected static void setDB_LISTENING_PORT(String dB_LISTENING_PORT) {
		DB_LISTENING_PORT = dB_LISTENING_PORT;
	}
	protected static void setDB_USER(String dB_USER) {
		DB_USER = dB_USER;
	}
	protected static void setDB_PASSWORD(String dB_PASSWORD) {
		DB_PASSWORD = dB_PASSWORD;
	}
	
	void EstablishConn()	{
		connURL = "jdbc:postgresql://"+ DB_LOCATION + ":"+DB_LISTENING_PORT+"/"+DB_DATABASE_SID ;
		try {
			// Register the Database Driver
			Class.forName("org.postgresql.Driver");
			
		}	catch(ClassNotFoundException de)	{
			System.out.println("Please place your driver in the build location. ");
			de.printStackTrace();
			
			return;
		}	
		
		try	{
			// Establish Connection
			databaseConn = DriverManager.getConnection(connURL, DB_USER, DB_PASSWORD);
		}	catch(SQLException deS)	{
			System.out.println("Connection Failed ! Check output console");
			deS.printStackTrace();
			return;
		}
		
		if ( databaseConn != null )	{
		} else	{
			System.out.println("Connection Failed..... ");
		}
		
	}
	
	
	ResultSet GetResult(String fireQurey)	{
		try {
			dbStatement = databaseConn.createStatement();
			dbResultSet = dbStatement.executeQuery(fireQurey);
			
			if (dbResultSet.next())	{
				return dbResultSet;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}
}
