
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItensVenda;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ItemVendaDAO {
    private Connection con;
    
    public ItemVendaDAO(){
        this.con=new ConnectionFactory().getConnection();
    }
    
    
    //metodo que cadastra Item
    public void cadastraItem(ItensVenda obj){
        try {
             String sql= "INSERT INTO tb_itensvendas(venda_id,produto_id,qtd,subtotal) VALUES (?,?,?,?)";
        
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3,obj.getQtd());
            stmt.setDouble(4,obj.getSubTotal());
            
            stmt.execute();
            stmt.close();
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :"+e.getMessage());
        }
       
        
    }
}
