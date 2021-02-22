package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    private Connection con;
     
    public ProdutoDAO(){
        this.con =new ConnectionFactory().getConnection();
    }
    public void cadastrarProduto(Produtos obj){
        try {
            String sql ="INSERT INTO tb_produtos(descricao,preco,qtd_estoque,for_id) "
                    +"VALUES(?,?,?,?)";
            
            PreparedStatement stmt =con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2,obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            
            stmt.setInt(4,obj.getFornecedor().getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com suceso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro "+e.getMessage());
        }
    }
    
    public void alterarProduto(Produtos obj){
        try {
            String sql ="UPDATE tb_produtos SET descricao=?,preco=?,qtd_estoque=?,for_id=? WHERE id=?";
            
            PreparedStatement stmt =con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2,obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            
            stmt.setInt(4,obj.getFornecedor().getId());
            
            stmt.setInt(5, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto alterado com suceso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro "+e.getMessage());
        }
    }
    
    public List<Produtos>listarProdutos(){
        try {
            List<Produtos>lista=new ArrayList<>();
        
            String sql= "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                     +"INNER JOIN tb_Fornecedores as f on(p.for_id=f.id)";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f= new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
            
            return null;
        }
    }
    public void excluirProduto(Produtos obj){
        try {
            String sql= "DELETE FROM tb_produtos WHERE id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao  Excluir Produto ");
        }
    }
    public List<Produtos>listarProdutoPorNome(String nome){
        try {
            List<Produtos>lista=new ArrayList<>();
        
            String sql= "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                     +"INNER JOIN tb_Fornecedores as f on(p.for_id=f.id) WHERE p.descricao like ?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs= stmt.executeQuery();
            
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f= new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
            
            return null;
        }
    }
    public Produtos consultaProdutoPorNome(String nome){
        try {
        
            String sql= "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                     +"INNER JOIN tb_Fornecedores as f on(p.for_id=f.id) WHERE p.descricao = ?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs= stmt.executeQuery();
            Produtos obj = new Produtos();
                Fornecedores f= new Fornecedores();
            
            while(rs.next()){
                
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }
            return obj;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
            
            return null;
        }
    }
    public Produtos consultaProdutoPorCodigo(int id){
        try {
        
            String sql= "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                     +"INNER JOIN tb_Fornecedores as f on(p.for_id=f.id) WHERE p.id = ?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs= stmt.executeQuery();
            Produtos obj = new Produtos();
                Fornecedores f= new Fornecedores();
            
            while(rs.next()){
                
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }
            return obj;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
            
            return null;
        }
    }
    
    //Metodo que da baixa no estoque
    public void baixarEstoque(int id,int qtd_nova){
        try {
            String sql="UPDATE tb_produtos set qtd_estoque = ? WHERE id=? ";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
        }
    }
    
    //Metodo retorna estoque atual
    public int retornaEstoqueAtual(int id){
        try {
            int qtd_estoque =0;
            String sql= "SELECT qtd_estoque FROM tb_produtos WHERE id =?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs= stmt.executeQuery();
            
            if(rs.next()){
                
                qtd_estoque=(rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void adicionarEstoque(int id,int qtd_nova){
        try {
            String sql= "UPDATE tb_produtos SET qtd_estoque = ? WHERE id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
        }
    }
}
