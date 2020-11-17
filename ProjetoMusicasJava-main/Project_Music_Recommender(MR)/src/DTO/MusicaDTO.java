/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author bonet
 */
public class MusicaDTO {
    private String nome_Musica;
    
    
    public void  setNome_musica (String nome_musica){
        this.nome_Musica = nome_musica;        
    }
    
    
    public String getNome_musica () {
        return nome_Musica;
    }
     
}
