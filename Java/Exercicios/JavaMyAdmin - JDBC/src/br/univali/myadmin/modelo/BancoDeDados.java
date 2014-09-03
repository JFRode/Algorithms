
package br.univali.myadmin.modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BancoDeDados {  
    
    
    public List getResult(ResultSet rs, String comando) throws SQLException{    // Este método trabalha com comandos similares de ResultSet
        List lista = new ArrayList();
        
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
            String tipoColuna = rsMeta.getColumnTypeName(i);
            System.out.println(nomeColuna +"-> " + tipoColuna);
            header[i-1] = nomeColuna + "(" + tipoColuna + ")";
        }
        
        return header;
    }
    
    public String[][] matriz(ResultSet rs){
        String[][] matriz = {{"oi", "ola"}, {"oi", "ola2"}};
        
        return matriz;
    }
    
    
}
