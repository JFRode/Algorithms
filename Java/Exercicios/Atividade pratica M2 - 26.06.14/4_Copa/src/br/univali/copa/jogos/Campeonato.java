
package br.univali.copa.jogos;

import br.univali.copa.time.Time;
import br.univali.utilidades.Teclado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author João Felipe Gonçalves
 
 8 Grupos
 Os 2 melhores de cada passa para as grupoTimes de final
 Oitavas tem 8 jogos 
 Os 8 vencedores vão para as quartas de final
 Os 4 vencedores vão para a semi-final
 Os 2 vencedores vão para final, e os 2 perdedores competem pelo terceiro lugar
 
 1 - Alocar nos grupos                              
 
 2 - Solicitar ganhadores dos grupos                
 2.1 - Alocar ganhadores nas grupoTimes de final    
 
 3 - Solicitar ganhadores das grupoTimes de final   
 3.1 - Alocar nas quartas de final                  
 
 4 - Solicitar ganhadores das quartas de final      
 4.1 - alocar ganhadores na semi final              
 
 5 - Solicitar ganhadores da semi final             
 5.1 - alocar ganhadores na final
 
 6 - solicitar vencedor da final e vencedor disputando 3ºlugar
*/

public class Campeonato {
    public static final int QUANTIDADE_GRUPOS = 8;
    private List<Grupo> grupos = new ArrayList<Grupo>();
    private List<Time[]> oitavas = new ArrayList<Time[]>();
    private List<Time[]> quartas;
    private List<Time[]> semifinais;
    private Time[] primeiroLugar = new Time[2];
    private Time[] terceiroLugar = new Time[2];
    
    
    private List<Time> times;
            

    public Campeonato(List<Time> times) {
        this.times = times;                                                     // Referencia para busca
        
        // Cadastro dos grupos--------------------------------------------------
        
        for (int i = 0; i < QUANTIDADE_GRUPOS; i++){
            Grupo g = new Grupo();
            for (int j = 0; j < 4;){
                System.out.println("REGISTRO DO GRUPO " + (i+1) + " (digite 'buscar' para consultar os times disponiveis)");
                if (cadastraGrupo(g)) j++;
            }
            grupos.add(g);
        }
        
        // Vencedores de cada grupo---------------------------------------------
        
        for (int i = 0; i < QUANTIDADE_GRUPOS; i++){
            System.out.println("GRUPO " + (i+1) + "\nPaises:");
            List<Time> listaTimes = grupos.get(i).getTimes();
            for (Time time : listaTimes) System.out.println(time.getPais());
            Time[] arrayTimes = new Time[2];
            
            for (int j = 0; j < 2; j++){
                String pais = Teclado.lerTexto("Digite o pais classificado:");
                for (Time time : listaTimes){
                    if (pais.equalsIgnoreCase(time.getPais())){
                        arrayTimes[j] = time;
                        listaTimes.remove(time);
                        break;
                    }
                }
            }
            oitavas.add(arrayTimes);                                            // Insere na list de arrayTimes os 2 vencedores de cada grupo
        }
        
        // Vencedores das grupoTimes ----------------------------------------------
        System.out.println("\nOITAVAS DE FINAL:");
        quartas = realizarJogos(oitavas);
        
        // Vencedores das quartas-----------------------------------------------
        System.out.println("\nQUARTAS DE FINAL:");
        semifinais = realizarJogos(quartas);
        
        // Vencedores das semi-finais-------------------------------------------
        System.out.println("\nSEMI-FINAL:");
        
        for (int i = 0; i < semifinais.size(); i++) {
            Time[] arrayTimes = semifinais.get(i);
            System.out.println("Jogo " + (i+1) + ": " + arrayTimes[0].getPais() + " vs " + arrayTimes[1].getPais());
            String pais = Teclado.lerTexto("Digite o time vencedor:");
            
            boolean alocou = false;
            for (int j = 0; j < arrayTimes.length; j++) {
                if (pais.equalsIgnoreCase(arrayTimes[j].getPais())){
                    primeiroLugar[i] = arrayTimes[j];
                    terceiroLugar[i] = arrayTimes[(j+1)%2];                     // Pega o perdedor do jogo ao qual ganhador venceu
                    alocou = true;
                }
            }
        }
        
        String terceiro;
        String segundo;
        // Disputa pelo Terceiro lugar------------------------------------------
        System.out.println("\nDISPUTA PELO TERCEIRO LUGAR:");
        String pais = "";
        
        do {            
            System.out.println(terceiroLugar[0].getPais() + " vs " + terceiroLugar[1].getPais());
            pais = Teclado.lerTexto("Digite o time vencedor:");
            terceiro = pais;
        } while (!pais.equalsIgnoreCase(terceiroLugar[0].getPais()) && !pais.equalsIgnoreCase(terceiroLugar[1].getPais()));
        
        
        // Final----------------------------------------------------------------
        System.out.println("\nFINAL:");
        do {            
            System.out.println(primeiroLugar[0].getPais() + " vs " + primeiroLugar[1].getPais());
            pais = Teclado.lerTexto("Digite o time vencedor:");
            
        } while (!pais.equalsIgnoreCase(primeiroLugar[0].getPais()) && !pais.equalsIgnoreCase(primeiroLugar[1].getPais()));
       
        // Operador ternário
        segundo = pais.equalsIgnoreCase(primeiroLugar[0].getPais()) ? primeiroLugar[1].getPais() : primeiroLugar[0].getPais();
        
        
        // Exibição dos resultados finais
        System.out.println("1º Lugar: " + pais);
        System.out.println("2º Lugar: " + segundo);
        System.out.println("3º Lugar: " + terceiro);
    }
    
    
// Metodos
    
    private List<Time[]> realizarJogos(List<Time[]> grupoTimes){
        List<Time[]> listaTimes = new ArrayList<Time[]>();
        List<Time> listaTemporaria = new ArrayList<Time>();
        
        for (int i = 0; i < grupoTimes.size(); i++){
            Time[] arrayTimes = grupoTimes.get(i);
            System.out.println("Jogo " + (i+1) + ": " + arrayTimes[0].getPais() + " vs " + arrayTimes[1].getPais());
            String pais = Teclado.lerTexto("Digite o time vencedor:");
            
            boolean alocou = false;
            for (Time time : arrayTimes) {
                if (pais.equalsIgnoreCase(time.getPais())){
                    if (i % 2 == 0){
                        listaTemporaria.clear();
                        listaTemporaria.add(time);
                    } else {
                        listaTemporaria.add(time);
                        listaTimes.add(listaTemporaria.toArray(new Time[0]));   // Converte a lista em array de Time
                    }
                    alocou = true;
                    break;
                }
            }
            if (!alocou){                                                       // Verifica se o pais digitado existe, verificando se alocou ou não
                System.out.println("\nPais digitado INVALIDO! Digite novamente");
                i--;
            }                                                   
        }
        return listaTimes;
    }
    
    public boolean cadastraGrupo(Grupo g){
        String pais = Teclado.lerTexto("Digite o nome do pais:");
        
        if (pais.equalsIgnoreCase("buscar")){
            buscarTimes();
            return false;
        } else {
            for (Time time : times) {
                if (time.getPais().equalsIgnoreCase(pais)){
                    g.adicionarTime(time);
                    times.remove(time);
                    return true;
                }
            }
            System.out.println("O Time não existe! Digite um time valido.");
            return false;
        }
    }
    
    private void buscarTimes(){
        System.out.println("PAISES DISPONIVEIS PARA CADASTRO:");
        for (Time time : times) {
            System.out.println(time.getPais());
        }
        
    }
    
    
    
}
