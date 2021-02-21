package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Vendas;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class VendaDAO {
    
    
    private Connection con;
    
    public VendaDAO(){
        this.con= new ConnectionFactory().getConnection();
    }
    
    //cadastrar venda
    public void cadastrarVenda(Vendas obj){
        try {
            String sql= "INSERT INTO tb_vendas(cliente_id,data_venda,total_venda,observacoes) VALUES(?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            stmt.setString(4,obj.getObs());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " +e.getMessage());
        }
    }
    
    //Retorna a ultima Venda
    public int retornaUltimaVenda()  {
        
        try {
            int idVenda =0;
        
            String sql= "SELECT max(id) id FROM tb_vendas;"; // max = retorna o valor maximo, no caso o maior id que é a ultima venda
            PreparedStatement ps =con.prepareStatement(sql);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){
                Vendas p = new Vendas();
                
                p.setId(rs.getInt("id"));
                
                idVenda=p.getId();
            }
            return idVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
