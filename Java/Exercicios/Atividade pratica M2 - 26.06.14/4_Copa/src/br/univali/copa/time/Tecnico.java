
package br.univali.copa.time;

import br.univali.copa.principal.Pessoa;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Tecnico extends Pessoa {
    private String nacionalidade;

    public Tecnico(String nome, String escolaridade, float altura, float peso, String nacionalidade) {
        super(nome, escolaridade, altura, peso);
        this.nacionalidade = nacionalidade;
    }
     
    
}
