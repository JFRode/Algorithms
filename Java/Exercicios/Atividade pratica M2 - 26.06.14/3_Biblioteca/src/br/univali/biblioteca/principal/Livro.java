/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.biblioteca.principal;

import java.util.Date;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Livro extends Publicacao {
    private int edicao;
    private String editora;
    private String ISBN;

    public Livro(Date data, String titulo, String[] referencias, Autor[] autores, int edicao, String editora, String ISBN) {
        super(data, titulo, referencias, autores);
        this.edicao = edicao;
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    public String getISBN() {
        return ISBN;
    }
    
    
}
