
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {
    private Connection con;
    public FornecedorDAO(){
        this.con= new ConnectionFactory().getConnection();
    }
    public void cadastrarFornecedor(Fornecedores obj){
        
        try {
            
            String sql="INSERT INTO tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt   (8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as cadastrar " +e);
        }
    }
    public void excluirFornecedor(Fornecedores obj){
        try {
            
            String sql="DELETE FROM tb_fornecedores WHERE id =? ";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao Excluir " +e);
        }
    }
    public void alterarFornecedor(Fornecedores obj){
        try {
            
            String sql="UPDATE tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? WHERE id= ?";
                   
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt   (8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
            stmt.setInt(13, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as alterar " +e);
        }
    }
     public List<Fornecedores>  listarFornecedores(){
        try {
            List<Fornecedores>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM tb_fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
     public List<Fornecedores>  buscarFornecedorPorNome(String nome){
        try {
            List<Fornecedores>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM tb_fornecedores WHERE nome LIKE ?"; //(LIKE) = puesquisa por aproximação
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e);
            return null;
        }
    }
     public Fornecedores consultaPorNome(String nome){
         try {
             
             String sql="SELECT * FROM tb_fornecedores WHERE nome =?";
             PreparedStatement stmt =con.prepareStatement(sql);
             stmt.setString(1, nome);
             ResultSet rs=stmt.executeQuery();
             
              Fornecedores obj = new Fornecedores();
             if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }
             return obj;
             
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Fornecedor não encontrado");
             return null;
         }
             
     }
     public Fornecedores buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Fornecedores obj = new Fornecedores();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }

}
