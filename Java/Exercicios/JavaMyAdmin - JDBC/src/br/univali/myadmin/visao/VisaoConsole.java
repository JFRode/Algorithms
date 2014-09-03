
package br.univali.myadmin.visao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VisaoConsole implements Visao{
    
    public String leitura (String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
    
    public void exibir(String mensagem){
        System.out.println(mensagem);
    }
    
    public void exibirList(List lista, String titulo){
        System.out.println("________________________________________\n" + titulo);
        
        for (Object l : lista) {
            System.out.println(l);
        }
    }
}
