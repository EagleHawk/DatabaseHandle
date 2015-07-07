/**
 * 
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * @author bajirao
 *
 */


public class Manipulate {

	/**
	 * @param args
	 */
	static final String DB_DATABASE_SID = "postgres";
	static final String DB_LOCATION = "localhost";
	static final String DB_LISTENING_PORT = "5432";
	static final String DB_USER = "postgres";
	static final String DB_PASSWORD = "hector009";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String query = "SELECT VERSION()";
		ResultSet rSet = null;
		ConnectDB lclConn = new ConnectDB(DB_DATABASE_SID, DB_LOCATION, DB_LISTENING_PORT, DB_USER, DB_PASSWORD);
		lclConn.EstablishConn();
		
		try	{
			rSet = lclConn.GetResult(query);
			System.out.println(rSet.getString(1));
		}	catch (Exception exw)	{
			System.out.println("Bad Result Set");
		}	finally {
			 try {
	                if (rSet != null) {
	                	rSet.close();
	                }	          

	            } catch (SQLException ex) {
	            	System.out.println("Bad Finnal Close");
	            }
		}
				
	}

}
