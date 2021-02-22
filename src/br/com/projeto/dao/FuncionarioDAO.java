
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.WebServiceCep;
import br.com.projeto.view.FmrLogin;
import br.com.projeto.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    private Connection con;
    
    public FuncionarioDAO(){
        this.con =new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrar funcionario
     public void cadastrarFuncionario(Funcionarios obj){
        try {
            
            String sql="INSERT INTO tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf() );
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt   (12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as cadastrar " +e);
        }
    }
     //Listar Funcionarios
      //metodo Listar cliente
    public List<Funcionarios>  listarFuncionarios(){
        try {
            List<Funcionarios>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
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
    //metodo Alterar Funcionario
    public void alterarFuncionarios(Funcionarios obj){
        try {
            
            String sql="UPDATE tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? WHERE id= ?";
                   
            //tratar e executar os comandos sql
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf() );
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt   (12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17,obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch ( SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro as alterar " +e);
        }
    }
    
    //metodo Excluir Funcionario
    public void excluirFuncionario(Funcionarios obj){
        try {
            
            String sql="DELETE FROM tb_funcionarios WHERE id =? ";
            
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
    //lista Funcionario por nome
    public List<Funcionarios>  listaFuncionarioPorNome(String nome){
        try {
            List<Funcionarios>lista= new ArrayList<>();
            
            String sql= "SELECT * FROM tb_funcionarios WHERE nome LIKE ?"; //(LIKE) = pesquisa por aproximação
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
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
    
     public Funcionarios consultaPorNome(String nome){
         try {
             
             String sql="SELECT * FROM tb_funcionarios WHERE nome =?";
             PreparedStatement stmt =con.prepareStatement(sql);
             stmt.setString(1, nome);
             ResultSet rs=stmt.executeQuery();
             
             Funcionarios obj = new Funcionarios();
             if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
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
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
             return null;
         }
             
     }
     
     //Busca Cep
      public Funcionarios buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Funcionarios obj = new Funcionarios();

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
      //Metodo efetua login
      public void efetuarLogin(String email,String senha){
          try {
              String sql ="SELECT * FROM tb_funcionarios WHERE email=? AND senha = ?";
              PreparedStatement stmt =con.prepareStatement(sql);
              stmt.setString(1, email);
              stmt.setString(2, senha);
              
              ResultSet rs=stmt.executeQuery();//toda vez que usa o (Select) usa o ResultSet
              if(rs.next()){
                //Usuario conseguir logar
                  
                //caso o usuario seja do tipo admin
                if(rs.getString("nivel_acesso").equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela=new FrmMenu();
                    tela.usuarioLogado =rs.getString("nome");
                    tela.setVisible(true); 
                }
                //caso o usuario seja de nive limitado
                else if(rs.getString("nivel_acesso").equals("Usuário"))
                {
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela=new FrmMenu();
                    tela.usuarioLogado =rs.getString("nome");
                    
                    //Desabilitar os menus
                    tela.menu_posicao.setEnabled(false); //dois jeitos diferentes de desabilitar
                    tela.menu_controVenda.setEnabled(false);
                    tela.MenuFuncionario.setEnabled(false);
                    //tela.menu_controVenda.setVisible(false);  outra maneira de controlar o acesso
                    tela.setVisible(true); 
                }
                  
              }else{
                  //dados incorretos
                  JOptionPane.showMessageDialog(null, "Dados Incorretos");
                  new FmrLogin().setVisible(true);
              }
              
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro: "+e);
              
              
          }
              
      }
}
