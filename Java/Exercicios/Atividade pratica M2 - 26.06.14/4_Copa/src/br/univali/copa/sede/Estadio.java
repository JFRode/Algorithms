
package br.univali.copa.sede;

import java.util.Date;

/**
 *
 * @author user
 */
public class Estadio {
    private Cidade cidade;
    private String nomeEstadio;
    private Date fundacao;
    private int capacidade;

    public Estadio(Cidade cidade, String nome, Date fundacao, int capacidade) {
        this.cidade = cidade;
        this.nomeEstadio = nome;
        this.fundacao = fundacao;
        this.capacidade = capacidade;
    }

    
    
    
}
