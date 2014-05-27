/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.biblioteca.principal;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Autor {
    private String nome;
    private String titulacao;

    public Autor(String nome, String titulacao) {
        this.nome = nome;
        this.titulacao = titulacao;
    }
    
    
    
    public static Autor[] registrarAutores(String autores) {
        String[] valores = autores.split(";");
        Autor[] autoresProntos = new Autor[valores.length];
        
        for (int i = 0; i < valores.length; i++) {
            String[] info = valores[i].split(",");
            autoresProntos[i] = new Autor(info[0], info[1]);
        }

        return autoresProntos;
    }
}
