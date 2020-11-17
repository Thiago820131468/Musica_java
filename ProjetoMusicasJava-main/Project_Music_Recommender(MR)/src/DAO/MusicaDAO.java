/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.MusicaDTO;
import DTO.GeneroDTO;

public class MusicaDAO {
    
Connection con;
PreparedStatement pstm;
    
    public void cadastrarMusica (MusicaDTO objmusicadto){
        
        String sql = "insert into musicas (nome_Musica) values (?)";      
        con = new ConexaoDAO().conectaBD();
        
        
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1,  objmusicadto.getNome_musica());
                
               

                pstm.execute();
                pstm.close();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir a musica" + erro);
            }
     }
    
    
    
}
