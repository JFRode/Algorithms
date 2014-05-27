
package br.univali.aplicacao;

import br.univali.utilidades.Teclado;
import java.util.Date;
import java.util.Arrays;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Programa { 
    
    private Gasto[] gastos = new Gasto[50];
    private String[] tiposGasto = new String[50];
    private int indiceGasto = 0;
    private int indiceTipos = 0;
    private Relatorio relatorio = new Relatorio();
    
    
    public Programa() {
        Arrays.fill(tiposGasto, "");            // Preenche todas as posições com string vazia
        while (true){
            System.out.println("Digite a opção desejada:\n"
                    + "1 - Cadastrar gasto\n"
                    + "2 - Encerrar");
            int r = Teclado.lerInteiro();
            
            if (r == 1){
                cadastrar();
            } else if (r == 2){
                relatorio.relatar(gastos, tiposGasto);
                break;
            } else {
                System.out.println("Entrada invalida!");
            }
        }
    }
    
    private void cadastrar(){
        Teclado.lerTexto();
        System.out.print("Tipo de gasto:");
        String tipo = Teclado.lerTexto();
        
        System.out.print("Data:");
        Date data = Teclado.lerData();
        
        System.out.print("Valor:");
        float valor = Teclado.lerNumero();
        
        System.out.print("Forma de Pagamento:\n"
                + "1 - Dinheiro\n"
                + "2 - Cheque\n"
                + "3 - Cheque pré\n"
                + "4 - Cartão\n");
        int formaPagamento = Teclado.lerInteiro()-1;    // (-1) para poder pegar indice 0 do array de pagamentos
        
        gastos[indiceGasto] = new Gasto(tipo, data, valor, formaPagamento);
        indiceGasto++;
        
        for (String tg : tiposGasto) {                  // Verifica se ja existe tipo do gasto no array, senão cadastra o novo tipo
            if (tg.equals(tipo)){
                break;
            } else {
                tiposGasto[indiceTipos] = tipo;
                indiceTipos++;
                break;
            }
        }
    }
    
}
