
package br.univali.biblioteca.principal;

import br.univali.utilidades.Teclado;
import java.util.Date;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Biblioteca {
    private String nome;
    private String endereco;
    private Publicacao[] publicacoes = new Publicacao[65535];
    private int indice = 0;

    public Biblioteca() {
        while(true){
            System.out.println("Digita a opção desejada:\n"
                    + "1 - Cadastrar\n"
                    + "2 - Encerrar\n");
            int r = Teclado.lerInteiro();
            if (r == 1){
                cadastrar();
            } else if(r == 2){
                break;
            } else System.out.println("Opção invalida!");
            
        }
    }
    
    public void cadastrar(){
        // Cadastra publicação
        while (true){
            System.out.println("Opções de registros:\n"
                    + "1 - Livro\n"
                    + "2 - Artigo\n");
            int r = Teclado.lerInteiro();
            if (r == 1){                                                        // Cadastro Livro
                System.out.print("Data publicação: ");
                Date data = Teclado.lerData();
                
                System.out.print("Titulo: ");
                String titulo = Teclado.lerTexto();
                
                System.out.print("Digite Referencia (utilize ';' para separar referencias)\n"
                        + "Exemplo: Ruptura; O Silmarillion \n:");
                String[] referencia = Teclado.lerTexto().split(";");            // split() transforma string em array de string com separador definido
                
                System.out.print("Autor (utilize ',' para separar 'nome' de 'titulação' e ';' para separar autores.\n"
                        + "Exemplo: Tolkien, Filologista; Rode, Programador\n: ");
                Autor[] autor = Autor.registrarAutores(Teclado.lerTexto());
                
                System.out.print("Edição: ");
                int edicao = Teclado.lerInteiro();
                
                System.out.print("Editora: ");
                String editora = Teclado.lerTexto();
                
                System.out.print("ISBN: ");
                String ISBN = Teclado.lerTexto();
                
                publicacoes[indice] = new Livro(data, titulo, referencia, autor, edicao, editora, ISBN);
                indice++;
                break;
            } else if (r == 2){                                                 // Cadastro Artigo
                System.out.print("Data publicação: ");
                Date data = Teclado.lerData();
                
                System.out.print("Titulo: ");
                String titulo = Teclado.lerTexto();
                
                System.out.print("Digite Referencia (utilize ';' para separar referencias)\n"
                        + "Exemplo: Ruptura; O Silmarillion \n:");
                String[] referencia = Teclado.lerTexto().split(";");            // split() transforma string em array de string com separador definido
                
                System.out.print("Autor (utilize ',' para separar 'nome' de 'titulação' e ';' para separar autores.\n"
                        + "Exemplo: Tolkien, Filologista; Rode, Programador\n: ");
                Autor[] autor = Autor.registrarAutores(Teclado.lerTexto());
                
                System.out.print("Resumo: ");
                String resumo = Teclado.lerTexto();
                
                publicacoes[indice] = new Artigo(data, titulo, referencia, autor, resumo);

                indice++;
                break;
            } else System.out.print("Entrada invalida!");
        }
        
        // Printando
        
        for (Publicacao publicacao : publicacoes) {
            if (publicacao == null) break;
            System.out.println(publicacao.getTitulo());
        }
    }
  
}