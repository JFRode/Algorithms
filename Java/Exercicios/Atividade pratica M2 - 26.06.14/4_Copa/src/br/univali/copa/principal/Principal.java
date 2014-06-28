
package br.univali.copa.principal;

import br.univali.copa.jogos.Campeonato;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Principal {

    
    public static void main(String[] args) {
        
        Cadastro cadastro = new Cadastro();
        new Campeonato(cadastro.getTimes());
    }
    
}
