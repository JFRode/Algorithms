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
public class Artigo extends Publicacao {
    private String resumo;

    public Artigo(Date data, String titulo, String[] referencias, Autor[] autores, String resumo) {
        super(data, titulo, referencias, autores);
        this.resumo = resumo;
    }

    public String getResumo() {
        return resumo;
    }
    
}
