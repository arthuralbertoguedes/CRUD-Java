
package connection;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionFactory {
    //jdbc:mysql://127.0.0.1:3306/meubanco
    private static final String URL= "jdbc:mysql://localhost:3306/bdpetshop"; //caminho do banco de dados
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //local do driver
    private static final String USER = "root";     //usuario do BD
    private static final String PASS = "";        //senha do BD
    
    
    
    public static Connection getConnection() {
       try{
            Class.forName(DRIVER); //Carrega o driver
            return DriverManager.getConnection(URL, USER, PASS);
            
            
   
       } catch(ClassNotFoundException | SQLException ex){
           
           JOptionPane.showMessageDialog(null, "Erro\n" + ex);
           throw new RuntimeException("Erro de conexao", ex);
        }  
       
    }
    
    
    //Métodos para fechar conexão
     public static void CloseConnection(Connection con){
       
       if(con!=null){
           
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println("ERRO");
           }
       }
       
       
   }
   
   public static void CloseConnection(Connection con, PreparedStatement stmt){
       
       if(stmt!=null){
           
           try {
               stmt.close();
               
           } catch (SQLException ex) {
               System.out.println("ERRO");
           }
       }
   CloseConnection(con);    
       
   }
   
   
   public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs){
       
       if(rs!=null){
           
           try {
               rs.close();
           } catch (SQLException ex) {
               System.out.println("ERRO");
           }
       }
   CloseConnection(con,stmt);    
       
   }
    
}
