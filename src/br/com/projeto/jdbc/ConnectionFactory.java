/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author rodri
 */
public class ConnectionFactory {
    //String de conexão
    private static final String URL="jdbc:mysql://localhost/bdvendas";
    private static final String USER="usuariocurso";
    private static final String PASS="123";
    
    public Connection getConnection(){
        
        try {
            Connection c=DriverManager.getConnection(URL,USER,PASS);
            return c;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
