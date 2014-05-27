
package br.univali.copa.time;

import br.univali.copa.principal.Pessoa;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Jogador extends Pessoa {
    private String posicao;
    private String ladoPreferencia;

    public Jogador(String nome, String escolaridade, float altura, float peso, String posicao, String ladoPreferencia) {
        super(nome, escolaridade, altura, peso);
        this.posicao = posicao;
        this.ladoPreferencia = ladoPreferencia;
    }
    
    
}
