

package br.univali.aplicacao;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Relatorio {
    
    private String[] pagamentos = {"dinheiro", "cheque", "cheque pré", "cartão"};
    
    public Relatorio() {
        // Construtor
    }

    public void relatar(Gasto[] gastos, String[] tipos){
        for (String tipo : tipos){
            if (tipo.isEmpty()) break;
            
            float acumulador = 0;
            for (Gasto g : gastos) {
                if (g == null) break;
                if (g.getTipo().equals(tipo)){
                    acumulador += g.getValor();
                }
            }
            System.out.println(tipo + ": " + acumulador);
        }
        
        for (int i = 0; i < pagamentos.length; i++){
            float acumulador = 0;
            for (Gasto g : gastos) {
                if (g == null) break;
                if(g.getFormaPagamento() == i){
                    acumulador += g.getValor();
                }
            }
            System.out.println(pagamentos[i] + ": " + acumulador);
        }
           
        
    }
    
}
