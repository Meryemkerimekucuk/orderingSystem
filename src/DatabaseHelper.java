
import java.util.*;
import java.sql.*;
public class DatabaseHelper {
    
    private String userName="root";
    private String password="Laktak41";
    private String url="jdbc:mysql://localhost:3306/shopping";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, userName, password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error Message : "+exception.getMessage());
        System.out.println("Error Code : "+exception.getErrorCode());
    }
    
}
