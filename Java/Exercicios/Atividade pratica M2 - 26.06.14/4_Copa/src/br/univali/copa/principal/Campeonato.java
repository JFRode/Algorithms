
package br.univali.copa.principal;

import br.univali.copa.sede.Cidade;
import br.univali.copa.sede.Estadio;
import br.univali.copa.time.Jogador;
import br.univali.copa.time.Tecnico;
import br.univali.copa.time.Time;
import br.univali.utilidades.Teclado;
import java.util.Date;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Campeonato {
    private Time[] times = new Time[32];
    private Cidade[] cidades = new Cidade[100];
    private Estadio[] estadios = new Estadio[100];
    private int indiceTimes = 0;
    private int indiceCidades = 0;
    private int indiceEstadios = 0;

    public Campeonato() {
        while (true){
            // Menu
            System.out.println("MENU\n"
                    + "1 - Cadastrar Estadio\n"
                    + "2 - Cadastrar Times\n"
                    + "3 - Encerrar");
            int r = Teclado.lerInteiro();
            
            if (r == 1){
                // Cadastra estadio
                registrarEstadio();
            } else if (r == 2) {
                // Cadastra time
                for (int i = 0; i < times.length; i++){
                    registrarTime();
                }
            } else if (r == 3){
                // Encerra
                break;
            } else System.out.println("Opção invalida!");
            
        }
    }

    
    public void registrarCidade(){
        System.out.print("REGISTRO CIDADE/n"
                + "Digite o nome da cidade: ");
        String nome = Teclado.lerTexto();
        
        System.out.print("Digite o estado: ");
        String estado = Teclado.lerTexto();
        
        System.out.print("Digite o IDH: ");
        String IDH = Teclado.lerTexto();
        
        cidades[indiceCidades] = new Cidade(nome, estado, indiceTimes);
    }
    
    public void registrarEstadio(){
        System.out.println("REGISTRO DO " + indiceEstadios + "º ESTADIO\n");
        
        registrarCidade();
        
        System.out.print("Nome do estadio:");
        String nome = Teclado.lerTexto();
        
        System.out.print("Data de fundação:");
        Date data = Teclado.lerData();
        
        System.out.print("Capacidade ocupacional:");
        int capacidade = Teclado.lerInteiro();
        
        estadios[indiceEstadios] = new Estadio(cidades[indiceCidades], nome, data, capacidade);
        indiceCidades++;                                                        // Acrescenta indiceCidade pós registro, para capturar primeiro indice
    }
    
    public Tecnico registrarTecnico(){
        System.out.print("Registro do tecnico\n"
                + "Nome: ");
        String nome = Teclado.lerTexto();
        
        System.out.print("Escolaridade: ");
        String escolaridade = Teclado.lerTexto();
        
        System.out.print("Altura: ");
        float altura = Teclado.lerNumero();
        
        System.out.print("Peso: ");
        float peso = Teclado.lerNumero();
        
        System.out.print("Nacionalidade: ");
        String nacionalidade = Teclado.lerTexto();
        
        Tecnico tecnico = new Tecnico(nome, escolaridade, altura, peso, nacionalidade);
        return tecnico;
    }
    
    public void registrarTime(){
        System.out.println("REGISTRO DE TIME");
        
        System.out.print("Pais:");
        String pais = Teclado.lerTexto();
        
        Tecnico tecnico = registrarTecnico();
        
        // Registro jogadores
        Jogador[] jogadores = new Jogador[Time.QUANTIDADE_JOGADORES];
        System.out.println("REGISTRO DE JOGADORES");
        for (int i = 0; i < jogadores.length; i++){
            jogadores[i] = registrarJogador(i+1);
        }
        
        times[indiceTimes] = new Time(tecnico, jogadores, pais, indiceTimes, indiceTimes);
        
    }
    
    public Jogador registrarJogador(int i){
            System.out.println("Jogador " + i);
            
            System.out.print("Nome: ");
            String nome = Teclado.lerTexto();
            
            System.out.print("Escolaridade: ");
            String escolaridade = Teclado.lerTexto();
            
            System.out.print("Altura: ");
            float altura = Teclado.lerNumero();
            
            System.out.print("Peso: ");
            float peso = Teclado.lerNumero();
            
            System.out.print("Posição: ");
            String posicao = Teclado.lerTexto();
            
            System.out.print("Lado de Preferencia (canhoto, destro, ambidestro): ");
            String preferencia = Teclado.lerTexto();
            
            Jogador jogador = new Jogador(nome, escolaridade, altura, peso, posicao, preferencia);
            return jogador;
    }

}