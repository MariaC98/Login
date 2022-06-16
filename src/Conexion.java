import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	public Connection conn;
	public Statement stmt;
	
	public Conexion() {
		 final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
		 final String DB_URL="jdbc:mysql://localhost:3306/usuario";
		 info f=new info();
		 final String USER= f.getUser();
		 final String PASS=f.getPass();
		 
		 	conn=null;
			stmt =null;
			try {
				//paso 2
				Class.forName(JDBC_DRIVER);
				
				//paso3 
				System.out.println("conectando");
				conn= DriverManager.getConnection(DB_URL,USER,PASS);
				
				//paso 4
				
				/*while(rs.next()) {
					int population= rs.getInt("Population");
					String Name =rs.getNString("Name");
					String CountryCode =rs.getString("Code");
					
					System.out.println("Pais: "+Name);
					System.out.println("Codigo Pais: "+ CountryCode);
					System.out.println("Poblacion: "+ population +" habitantes");
					System.out.println();
				}*/
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.print("LIsto");
		}

		public ResultSet devolverConsulta(String query) throws SQLException {
			System.out.println("creando declaracion");
			stmt= conn.createStatement();
			String sql;
			sql=query;
			
			ResultSet rs =stmt.executeQuery(sql);
			 return rs;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
