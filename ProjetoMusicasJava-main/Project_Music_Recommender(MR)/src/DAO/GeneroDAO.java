
package DAO;

import DTO.GeneroDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class GeneroDAO {
   
Connection con;
PreparedStatement pstm;
ArrayList<GeneroDTO> lista = new ArrayList<>();    

    public ArrayList<GeneroDTO> PesquisarGenero(){
        String sql = "select * from genero";
        con = new ConexaoDAO().conectaBD();
        
         
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
               GeneroDTO objgeneroDTO = new GeneroDTO();
               objgeneroDTO.setNome_genero(rs.getString("nome_genero"));
               objgeneroDTO.setId(rs.getInt("genderId"));
               
              
               lista.add(objgeneroDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: "+erro);
        }
        
        return lista;
        
    }
}        
         
