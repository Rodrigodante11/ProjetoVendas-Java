
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItensVenda;
import br.com.projeto.model.Produtos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    //metodo que lista itens vendido , por ID
    public List<ItensVenda>listaItensVendaPorVenda(int venda_id){
        try {
            List<ItensVenda>lista = new ArrayList<>();
        
            String sql ="SELECT  p.descricao, i.qtd,p.preco, i.subtotal FROM tb_itensvendas as i " 
                       +"INNER JOIN tb_produtos as p on(i.produto_id = p.id) WHERE i.venda_id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda_id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                 ItensVenda item= new ItensVenda();
                 Produtos prod= new Produtos();
                 prod.setDescricao(rs.getString("p.descricao"));
                 item.setQtd(rs.getInt("i.qtd"));
                 prod.setPreco(rs.getDouble("p.preco"));
                 item.setSubTotal(rs.getDouble("i.subtotal"));
                 
                 item.setProduto(prod);
                 
                 lista.add(item);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
