
package br.univali.myadmin.controle;

import br.univali.myadmin.modelo.BancoDeDados;
import br.univali.myadmin.visao.Visao;
import br.univali.myadmin.visao.VisaoConsole;
import com.bethecoder.ascii_table.ASCIITable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Controlador {
    private String url = "jdbc:mysql://localhost";
    private Connection conexao = DriverManager.getConnection(url, "root", "");
    private DatabaseMetaData dbMeta = conexao.getMetaData();
    private Statement state = conexao.createStatement();
    
    private ResultSet rsTable;
    private ResultSet rs;
    
    private List lista = new ArrayList();
    private BancoDeDados banco = new BancoDeDados();
    private Visao visao = new VisaoConsole();
    
    private String baseDeDados;
    private String tabela;
           
    
    public Controlador() throws Exception {
        
        boolean persistencia = true;
        
        while (persistencia){
            
            lista = banco.getResult(conexao.getMetaData().getCatalogs(), "TABLE_CAT");
            visao.exibirList(lista, "BANCOS DISPONIVEIS:");
            baseDeDados = visao.leitura("Digite o nome do banco que deseja acessar:");

            rsTable = dbMeta.getTables(baseDeDados, null, null, null);
            lista = banco.getResult(rsTable, "TABLE_NAME");
            visao.exibirList(lista, "TABELAS DISPONIVEIS:");

            tabela = visao.leitura("Digite o nome da tabela que deseja acessar:");

            rs = state.executeQuery("SELECT * FROM " + baseDeDados + "." + tabela); // Comando SQL

            ASCIITable.getInstance().printTable(banco.tabela(rs), banco.matriz(rs));
            
            persistencia = visao.persistencia();
        }
    }
    
}
