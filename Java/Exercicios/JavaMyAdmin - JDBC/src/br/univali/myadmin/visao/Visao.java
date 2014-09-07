

package br.univali.myadmin.visao;

import java.util.List;


public interface Visao {
    public String leitura(String mensagem);
    public void exibir(String texto);
    public void exibirList(List lista, String titulo);
    public boolean persistencia();
}
