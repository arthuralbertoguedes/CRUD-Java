
package controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import model.Cliente;
import model.TableModel;

public class Controle {
    
    
    public Connection conectarBD(){
        ConnectionFactory con = new ConnectionFactory();
        Connection c = con.getConnection();
        return c;
        
    }
    public TableModel criarTabela(){
        TableModel tabela = new TableModel();
        return tabela;
        
    }
    
  
    
   
    
    
}
