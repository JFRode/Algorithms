/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import br.univali.utilidades.Teclado;
import java.util.Date;

/**
 *
 * @author user
 */
public class Principal {

    private Tratamento[] tratamentos;
    private int quantidade;
    
    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {
        System.out.println("Digite a quantidade de remedios:");
        quantidade = Teclado.lerInteiro();
        tratamentos = new Tratamento[quantidade];
        
        for (int i = 0; i < tratamentos.length; i++){
            cadastrarRemedio(i);
        }
    }
    
    private void cadastrarRemedio(int indice){
        System.out.println("Digite o nome do remédio");
        Remedio remedio = new Remedio(Teclado.lerTexto());

        System.out.println("Digite o nome do paciente");
        Paciente paciente = new Paciente(Teclado.lerTexto());

        System.out.println("Digite a data de início");
        Date dataInicio = Teclado.lerData();

        System.out.println("Digite o nome do médico");
        Medico medico = new Medico(Teclado.lerTexto());

        System.out.println("Digite a quantidade de dias em que o remédio será tomado");
        int quantidadeDias = Teclado.lerInteiro();

        System.out.println("Digite quantas vezes por dia o remédio será tomado");
        int vezesPorDia = Teclado.lerInteiro();

        System.out.println("Digite a dosagem do remédio");
        float dosagem = Teclado.lerNumero();

        tratamentos[indice] = new Tratamento(dataInicio, dosagem, medico, medico, quantidadeDias, quantidadeDias, remedio);
    }
    
    
    
}
