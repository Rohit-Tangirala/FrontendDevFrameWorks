package simplebro;
import java.sql.*;
public class JDBCDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String url  = "jdbc:mysql://localhost:3306/jdbcconnect";
       String username = "root";
       String password = "admin@123";
      
  try (Connection conn = DriverManager.getConnection(url, username,password)) {
  
   int rollno = 99;
		  String name = "P R Kumar";
          String sql  = "INSERT INTO students (rollno, name ) VALUES (?,?)";
          PreparedStatement pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, rollno);
          pstmt.setString(2, name);
          
          int rows = pstmt.executeUpdate();
          System.out.println(rows + " row(s) inserted , Rollno :" + rollno +" , Name : " + name);
  }
  catch(SQLException e) {
	  e.printStackTrace();
	  
  }
}
}
