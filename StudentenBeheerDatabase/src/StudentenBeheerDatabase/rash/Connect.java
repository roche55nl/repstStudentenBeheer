package StudentenBeheerDatabase.rash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Connect {

	/**
	 *
	 * @author Rash
	 */

		private String url="jdbc:mysql://localhost:3306/";
		private String user="root";
		private String password;
		Connection connection;
		
		public Connect() {
			
			try {
				
				connection = DriverManager.getConnection(url,user,password);
				Statement statement = connection.createStatement();
				statement.execute("CREATE DATABASE IF NOT EXISTS ProjectDBR");
				statement.execute("USE ProjectDBR");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS student"
						+ 	"(" 
						+ 	"id BIGINT NOT NULL AUTO_INCREMENT," 
						+ 	"nr VARCHAR(30) UNIQUE," 
						+	"naam VARCHAR(30),"
						+	"voornaam VARCHAR(30),"
						+	"module VARCHAR(30),"
						+   "gdatum VARCHAR(30),"
						+	"punt VARCHAR(30),"
						+   "vermelding VARCHAR(30),"
						+ 	"PRIMARY KEY(id)"
						+ 	")"
				);
				
			} catch (Exception e) {
				e.printStackTrace();
				  System.out.println("SQLException: " );
				  
			}
				
			}
		    Connection getconnection(){
		    	return connection;}

		    PreparedStatement PreparedStatement(String sql) {
		        throw new UnsupportedOperationException("Not supported yet."); 
		    }
		  
		}
