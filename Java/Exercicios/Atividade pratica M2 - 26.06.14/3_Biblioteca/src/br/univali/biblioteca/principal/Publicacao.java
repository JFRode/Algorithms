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
public abstract class Publicacao {
    private Date data;
    private String titulo;
    private String[] referencias = new String[255];
    private Autor[] autores = new Autor[255];

    public Publicacao(Date data, String titulo, String[] referencias, Autor[] autores) {
        this.data = data;
        this.titulo = titulo;
        this.referencias = referencias;
        this.autores = autores;
    }

    public Date getData() {
        return data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getReferencias() {
        return referencias;
    }

    public Autor[] getAutores() {
        return autores;
    }

}
