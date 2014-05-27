
package br.univali.copa.time;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Time {
    public static final int QUANTIDADE_JOGADORES = 11;
    private Tecnico tecnico ;
    private Jogador[] jogadores = new Jogador[QUANTIDADE_JOGADORES];
    private String pais;
    private int numeroTitulos;
    private int posicaoRank;

    public Time(Tecnico tecnico, Jogador[] jogadores, String pais, int titulos, int rank) {
        this.tecnico = tecnico;
        this.jogadores = jogadores;
        this.pais = pais;
        this.numeroTitulos = titulos;
        this.posicaoRank = rank;
    }
    
    
}
