#ifndef SP3_H_INCLUDED
#define SP3_H_INCLUDED

#include "Erastotenes.h"
#include "Pascal.h"

void developers(){                              //Procedimento para opção 3, onde é mostrado os desenvolvedores do projeto
    clrscr();
    textcolor(LIGHTGREEN);
    cout << "Desenvolvido por:\n\
    Joao Felipe Goncalves, Academico de Ciencia da Computacao e\n\
    Guilherme Gustavo Gohr Darosci, Academico de Ciencia da Computacao\n\n\n\n\n\n";
    textcolor(WHITE);
    cout << "Pressione ENTER para voltar ao menu...";
    getch();
    clrscr();
}

void programa(){
    int opcao;
    bool programa = true;

    while(programa){                            //Laço de repetição do programa, só sai dele quando for digitado 4 no Menu
        textcolor(WHITE);
        cout << "Digite a opcao desejada:\n\
        Opcao 1 - Crivo de Erastotenes\n\
        Opcao 2 - Triangulo de Pascal\n\
        Opcao 3 - Desenvolvedor(es)\n\
        Opcao 4 - Sair\n";
        cin >> opcao;
        clrscr();
        if(opcao >= 1 && opcao <= 4){
            switch (opcao){                         //Menu
                case 1://<Crivo de Erastotenes>
                    erastotenes();
                    break;

                case 2://<Triangulo de Pascal>
                    pascal();
                    break;

                case 3://<Desenvolvedores>
                    developers();
                    break;

                case 4://<Sair do programa>
                    programa = false;
                    break;
            }
        } else {                                    //Caso a opção seja maior que 4 ou menor que 1
            cout << "Opcao invalida!";
            _sleep(1000);
            clrscr();
        }

    }
}

#endif // SP3_H_INCLUDED
