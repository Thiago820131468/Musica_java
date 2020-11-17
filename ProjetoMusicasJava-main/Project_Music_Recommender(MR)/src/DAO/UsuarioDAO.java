package DAO;

import DTO.UsuarioDTO;
import VIEW.LoginUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();
    
    public void cadastrarUsuario(UsuarioDTO objusuariodto){
        
        String sql = "insert into usuario (nome_usuario, senha_usuario) values (?,?)";      
        con = new ConexaoDAO().conectaBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
        }
    }
    
    public boolean LoginUsuario(UsuarioDTO objusuariodto, String login, String senha) {
        boolean autenticado = false;
        String sql = "SELECT userId, nome_usuario, senha_usuario FROM usuario WHERE nome_usuario=? and senha_usuario=?";
        
        if (!login.isEmpty() && !senha.isEmpty()) {
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, login);
                pstm.setString(2, senha);

                rs = pstm.executeQuery();

                if (rs.next()) {
                    autenticado = true;
                } else {
                    pstm.close();
                    return autenticado;
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"UsuarioDAO" + erro);
            }
        }
        return autenticado;
        
    }
    
    
}
