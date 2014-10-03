
package br.univali.myadmin.modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BancoDeDados {  
    
    public List<String> getResult(ResultSet rs, String comando) throws SQLException{    // Trabalha com comandos similares de ResultSet
        List<String> lista = new ArrayList();
        
        while (rs.next()){
            String nomeDaBase = rs.getString(comando);
            lista.add(nomeDaBase);
        }
        
        return lista;
    }
    
    public String[] tabela(ResultSet rs) throws SQLException{
        ResultSetMetaData rsMeta = rs.getMetaData();
        int colunasQtd = rsMeta.getColumnCount();
        String[] header = new String[colunasQtd];
        
        for (int i = 1; i <= colunasQtd; i++) {
            String nomeColuna = rsMeta.getColumnName(i);
            String tipoColuna = rsMeta.getColumnTypeName(i);                    //tipoColuna não é usado na versão Swing
            header[i-1] = nomeColuna;
        }
        
        return header;
    }
    
    public String[][] matriz(ResultSet rs) throws SQLException{
        
        List<String[]> lista = new ArrayList();
        ResultSetMetaData rsMeta = rs.getMetaData();
        int colunasQtd = rsMeta.getColumnCount();
        
        
        while (rs.next()){
            String[] vetor = new String[colunasQtd];
            for (int j = 0; j < colunasQtd; j++){
                String dado = rs.getString(j+1);
                vetor[j] = dado != null ? dado : "null";                        // Operador ternário
            }
            
            lista.add(vetor);
        }
        
        if (lista.isEmpty()) return null;
        List<String[]> listaFinal = new ArrayList<>();
        int count = lista.get(0).length;
        for (int i = 0; i < count; i++) {
            String[] array = new String[lista.size()];
            int index = 0;
            for (String[] strings : lista) {
                array[index] = strings[i];
                index++;
            }
            listaFinal.add(array);
        }
        
        // Transformando em matriz
        String[][] matriz = new String[listaFinal.size()][colunasQtd];
        matriz = listaFinal.toArray(matriz);
        
        
        return matriz;
    }
    
}
