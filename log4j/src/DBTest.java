
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/employees";
	static final String username = "root";
	static final String password = "prasada1989";
	
	public static void clear(Buffer buffer)
	  {
	      buffer.clear();
	  }

	  public static void flip(Buffer buffer)
	  {
	      buffer.flip();
	  }

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		// TODO Auto-generated method stub
		//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		/*Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "prasada1989");
		Statement s = con.createStatement();
		ResultSet rs =s.executeQuery("select * from titles order by emp_no desc limit 10");*/
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database");
			con = DriverManager.getConnection(DB_URL, "root", "prasada1989");
			stmt = con.createStatement();
			String sql;
			sql = "select * from titles order by emp_no desc limit 10";
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()){
				int emp_no = rs.getInt("emp_no");
				String title = rs.getString("title");
				System.out.println("emp_no: " + emp_no);
				System.out.println("title: " + title);
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
