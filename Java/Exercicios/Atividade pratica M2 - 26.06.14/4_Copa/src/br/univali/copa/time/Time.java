
package br.univali.copa.time;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Time {
    private Tecnico tecnico ;
    private List<Jogador> jogadores;
    private String pais;
    private int numeroTitulos;
    private int posicaoRank;

    public Time(Tecnico tecnico, List<Jogador> jogadores, String pais, int titulos, int rank) {
        this.tecnico = tecnico;
        this.jogadores = jogadores;
        this.pais = pais;
        this.numeroTitulos = titulos;
        this.posicaoRank = rank;
    }
    
    
}
