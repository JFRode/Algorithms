//Universidade do Vale do Itajaí
//Ciência da Computação - 3º Periodo  2014/1
//Professor: Rafael de Santiago
//Acadêmicos: Guilherme Gustavo Gohr Darosci &
//            João Felipe Gonçalves

#include <conio2.h>
#include "Cartas.h"

using namespace std;

int main()
{
    TListaCartas jogadorUm, jogadorDois, jogadorTres, jogadorQuatro;
    TListaCartas mesa;

    inicializaLE(jogadorUm);
    inicializaLE(jogadorDois);
    inicializaLE(jogadorTres);
    inicializaLE(jogadorQuatro);
    inicializaLE(mesa);

//Gerando os deck
    TListaCartas deckCartas;

    inicializaLE(deckCartas);
    geraCartas(deckCartas);
    embaralhar(deckCartas);

    distribuiCartas(deckCartas, jogadorUm, 2);
    distribuiCartas(deckCartas, jogadorDois, 2);
    distribuiCartas(deckCartas, jogadorTres, 2);
    distribuiCartas(deckCartas, jogadorQuatro, 2);
    distribuiCartas(deckCartas, mesa, 5);
    organizarMesa(mesa);

    textcolor(LIGHTGRAY);
//Mão de cada jogador e mesa
    cout << "\nMesa:\n";
    imprimir(mesa);

    textcolor(WHITE);
    cout << "\nJogador 1:\n";
    imprimir(jogadorUm);
    compara(mesa, jogadorUm);

    textcolor(LIGHTGREEN);
    cout << "\n\nJogador 2:\n";
    imprimir(jogadorDois);
    compara(mesa, jogadorDois);

    textcolor(WHITE);
    cout << "\n\nJogador 3:\n";
    imprimir(jogadorTres);
    compara(mesa, jogadorTres);

    textcolor(LIGHTGREEN);
    cout << "\n\nJogador 4:\n";
    imprimir(jogadorQuatro);
    compara(mesa, jogadorQuatro);


    textcolor(LIGHTGRAY);
    cout << "\n\nPressione ENTER para continuar...";
    getch();
}
