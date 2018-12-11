
package DAO;

import connection.ConnectionFactory;
import controller.Controle;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import view.TelaPesquisarCliente;

public class ManipularBD {
    
    
    
public ManipularBD(){
    
    
    
    
}  

public void addFuncionario(Funcionario f){
    String sql = "insert into funcionario values(DEFAULT,'" + f.getNome() + "','" + f.getTelefone() + "','" + f.getEmail() + "','" + f.getEstadoCivil() + "')";

        try {
            ConnectionFactory conectar = new ConnectionFactory();
            Connection pega_conexao = conectar.getConnection();
            PreparedStatement stmt = pega_conexao.prepareStatement(sql);
            stmt.execute();
            conectar.CloseConnection(pega_conexao,stmt);
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção \n" + ex);
        }
}

public void addCliente(Cliente c){
    String sql = "insert into cliente values(DEFAULT,'" + c.getNome() + "','" + c.getTelefone() + "','" + c.getEmail() + "','" + c.getEstadoCivil() + "')";
        //pego a conexao com o BD e executo os comandos sql
        try {
            ConnectionFactory conectar = new ConnectionFactory();
            Connection pega_conexao = conectar.getConnection();
            PreparedStatement stmt = pega_conexao.prepareStatement(sql);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso ! ");
            conectar.CloseConnection(pega_conexao,stmt);
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção \n" + ex);
        }
}
    

public List<Cliente> buscaCliente(){
      String sql = " select * from cliente where nome_Cliente like '%" +  TelaPesquisarCliente.textCliente.getText() + "%';"; 
      //pego a conexao com o BD e executo os comandos sql
      Controle controle = new Controle();
      Connection conexao = controle.conectarBD();
    try {
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        
        int i=0;
        while(rs.next()){
            Cliente aux = new Cliente();
            aux.setNome(rs.getString(2));
            aux.setTelefone(rs.getString(3));
            aux.setEmail(rs.getString(4));
            aux.setEstadoCivil(rs.getString(5));
            
            listaClientes.add(i, aux);
                      
            i++;
        }
        return listaClientes;
        
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro de conexao \n" + ex);
        return null;
    }
    
}

    public void removerCliente(String nome){
        String sql = "delete from cliente where nome_Cliente='" + nome + "';";
        //pego a conexao com o BD e executo os comandos sql
        Controle controle = new Controle();
        Connection con = controle.conectarBD();
    try {
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso! ");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERRO \n " + ex);
    }
        
        
    }

    
    public void editarCliente(String novoNome, String novoTelefone, String novoEmail, String novoEstadoCivil, String clienteAtt){
        Controle controle = new Controle();
        Connection conexao = controle.conectarBD();
        String sql = "update cliente set nome_Cliente='" + novoNome +  "',telefone_Cliente = '" + novoTelefone + "',email_Cliente='" + novoEmail + "',estadocivil_Cliente='" + novoEstadoCivil + "' where nome_Cliente='" + clienteAtt + "';";        
        
    try {
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Mudanças realizadas com sucesso ! ");
        stmt.close();
        conexao.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar alteraçao \n" + ex);
    }
        
        
    }

}
