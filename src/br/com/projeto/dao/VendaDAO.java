package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Vendas;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    //metodo que filtra vendas por datas
    public List<Vendas> listarVendasPorPerido(LocalDate dataInicial,LocalDate  dataFinal){
        
        try {
            List<Vendas> lista= new ArrayList<>();
        String sql="SELECT v.id , v.data_venda, c.nome, v.total_venda, v.observacoes FROM tb_vendas AS v "
                  +"INNER JOIN tb_clientes as c on(v.cliente_id = c.id) WHERE v.data_venda BETWEEN ? AND ?";
        
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1, dataInicial.toString());
        stmt.setString(2, dataFinal.toString());
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Vendas obj=new Vendas();
            Clientes c= new Clientes();
            
            obj.setId(rs.getInt("v.id"));
            obj.setData_venda(rs.getString("v.data_venda"));
            c.setNome(rs.getString("c.nome"));
            obj.setTotal_venda(rs.getDouble("v.total_venda"));
            obj.setObs((rs.getString("v.observacoes")));
            
            obj.setCliente(c);
            
            lista.add(obj);
        }
        return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Vendas nao encontrada nesse Periodo");
            return null;
        }
        
    }
}
