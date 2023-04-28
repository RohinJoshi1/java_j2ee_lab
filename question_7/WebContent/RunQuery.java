import java.util.*;
import java.sql.*;
public class RunQuery {
	Connection conn;
	RunQuery(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java_lab";
			String user = "root";
			String password ="";
			this.conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	void update(String query) {
		try {
			if(conn!=null) {
				conn.createStatement().executeUpdate(query);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	String show() {
		try {
			if(conn!=null) {
				String s = "";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from PatientRecords;");
				while(rs.next()) {
					s += rs.getString("id")+" "+rs.getString("name")+rs.getString("age")+" "+rs.getString("cause")+" "+rs.getString("doctor")+" "+rs.getString("treat");
				}
				return s;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return "";
	}
	
}
