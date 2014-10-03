/**
 * Universidade do Vale do Itajaí - UNIVALI
 * Disciplina de Programação II
 * Professor Elieser
 * Acadêmicos:  -   Guilherme Gustavo Gohr Darosci
 *              -   João Felipe Gonçalves
*/

package br.univali.myadmin.controle;

import br.univali.myadmin.modelo.BancoDeDados;
import br.univali.myadmin.visao.VisaoSwing;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class Controlador {
    private Connection conexao;
    private DatabaseMetaData databaseMetadata;
    
    private ResultSet rsTable;
    private ResultSet rs;
    
    private List lista = new ArrayList();
    private BancoDeDados banco = new BancoDeDados();
    private VisaoSwing visao;
    
    
    public Controlador() {
        visao = new VisaoSwing(this);
    }
    
    public void adicionarLinha() {
        StringBuilder builder = new StringBuilder("insert into " + visao.getDatabaseSelecionado() + "." + visao.getTabelaSelecionada() + " values (");
        
        boolean primeiro = true;
        for (String coluna : visao.getColunas()) {
            if (!primeiro) builder.append(", ");                                // Se não for o primeiro poe uma virgula
            String valor = JOptionPane.showInputDialog("Digite o valor da coluna: " + coluna);
            if (valor == null) return;
            builder.append("\"").append(valor).append("\"");
            primeiro = false;
        }
        builder.append(")");
        
        try {
            conexao.createStatement().execute(builder.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tipos incorretos");
        }
        atualizarDados();
    }

    public void removerLinha() {
        try {
            String query = "select column_name from information_schema.columns where table_schema = \"" + visao.getDatabaseSelecionado() + "\" and table_name = \"" + visao.getTabelaSelecionada() + "\" and column_key = \"PRI\"";
            ResultSet result = conexao.createStatement().executeQuery(query);
            
            if (result.next()){                                                 // Tem primary key
                String primaria = result.getString(1);
                String remocao = "delete from " + visao.getDatabaseSelecionado() + "." + visao.getTabelaSelecionada() + " where " + primaria + " = \"" + visao.buscarLinha(primaria) + "\"";
                System.out.println(remocao);
                conexao.createStatement().execute(remocao);
            } else {                                                            // Não tem primary key
                
                 StringBuilder queryBuilder = new StringBuilder("DELETE FROM " + visao.getDatabaseSelecionado() + "." + visao.getTabelaSelecionada() + " WHERE ");
            
                int contColunas = 0;
                boolean primeiro = true;
                for (String coluna : visao.getColunas()) {
                    if (!primeiro) queryBuilder.append(" AND ");
                    queryBuilder.append(coluna).append(" = ").append("\"").append(visao.getTabela().getValueAt(visao.getTabela().getSelectedRow(), contColunas)).append("\"");

                    primeiro = false;
                    contColunas++;
                }

                System.out.println(queryBuilder);
                conexao.createStatement().execute(queryBuilder.toString());
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para remover");
           e.printStackTrace();
        }
        atualizarDados();
    }
    
    public void conectar(String url) {
        String usuario = JOptionPane.showInputDialog("Usuário:");
        String senha = JOptionPane.showInputDialog("Senha:");
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            databaseMetadata = conexao.getMetaData();
            visao.inserirRaiz(databaseMetadata.getDatabaseProductName());
            List<String> nomeBancos = banco.getResult(databaseMetadata.getCatalogs(), "TABLE_CAT");
            for (String nomeBanco : nomeBancos) {
                List<String> tabelas = banco.getResult(databaseMetadata.getTables(nomeBanco, null, null, null), "TABLE_NAME");
                visao.inserirBanco(nomeBanco, tabelas);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1045) JOptionPane.showMessageDialog(null, "Acesso negado. Certifique-se de ter digitado a usuario e senha corretos");
            else JOptionPane.showMessageDialog(null, "Conexão não existe");
        } 
    }
    
    public DatabaseMetaData getDatabaseMetadata() {
        return databaseMetadata;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void atualizarDados() {                                              // Atualiza os dados da tabela
        if (visao.getTabelaSelecionada() == null) return;                       // Tratamento para que cada vez que uma tabela é selecionada não disparar exception
        try {
            ResultSet resultado = conexao.createStatement().executeQuery("select * from " + visao.getDatabaseSelecionado() + "." + visao.getTabelaSelecionada());
            visao.preencherTabela(banco.tabela(resultado), banco.matriz(resultado));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
// Main do programa  
    public static void main(String[] args) {
        new Controlador();
    }
    
}
