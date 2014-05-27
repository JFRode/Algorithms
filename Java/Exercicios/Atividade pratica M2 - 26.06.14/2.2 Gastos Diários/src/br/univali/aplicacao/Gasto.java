
package br.univali.aplicacao;

import br.univali.utilidades.Teclado;
import java.util.Date;

/**
 *
 * @author João Felipe Gonçalves
 */

public class Gasto {
    private String tipo;
    private Date data;
    private float valor;
    private int formaPagamento;
    
    public Gasto(String tipo, Date data, float valor, int formaPagamento) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }
    
    
    
    // Getters e setters
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
}
