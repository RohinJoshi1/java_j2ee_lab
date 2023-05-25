package SEE.Question_5;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBConn{
    Connection conn;
    DBConn(){
        try {
        	//1.JDBC : jdbc: protocol: db_details
//        	Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SEE_6";
            String user = "root";
            String pass = "";
            this.conn=DriverManager.getConnection(url,user,pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(String query){
        	//Statement cs = conn.createStatement();cs.exect
            try {
                if(conn!=null){
                conn.createStatement().executeUpdate(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
    }
    public String display(){
        try {
            if(conn!=null){
                String s = "";
                String query= "select * from Customer where Credit_Limit >15000;";
                ResultSet rs = conn.createStatement().executeQuery(query);
                while(rs.next()) {
                        s += Integer.toString(rs.getInt("CustNo"))+" "+rs.getString("CustName")+rs.getString("State")+" "+Integer.toString(rs.getInt("Credit_Limit"))+" "+Integer.toString(rs.getInt("RepNo"));
                	}
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
            }
        return "";
    }
}