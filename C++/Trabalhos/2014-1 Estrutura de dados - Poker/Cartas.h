#ifndef CARTAS_H_INCLUDED
#define CARTAS_H_INCLUDED
#include <iostream>
#include <conio2.h>
#include <time.h>
#include <stdlib.h>
#include <vector>
using namespace std;

const int TAM = 52;

struct TCarta{
    int valor;
    string naipe;
};

struct TListaCartas{
    TCarta elemento[TAM];
    int qtd;
};


//Funções
void inicializaLE(TListaCartas &lc){                    //Inicializa a quantidade de cartas e posição como zero
    lc.qtd = 0;
}

void insereFimLE(TListaCartas &lc, TCarta c){           //Função Insere carta pelo final do array
    if (lc.qtd < TAM){
        lc.elemento[lc.qtd] = c;
        lc.qtd++;
    }
}

void removerFimLC(TListaCartas &lc){                    //Função Remove carta pelo final do array
    if (lc.qtd > 0){
        lc.qtd--;
    }
}

void inserePosLE(TListaCartas &lc, TCarta c, int pos){  //Função Insere Posição
    if (lc.qtd < TAM and pos <= lc.qtd){
        for (int i = lc.qtd; i > pos; i--){
            lc.elemento[i] = lc.elemento[i-1];
        }
        lc.elemento[pos] = c;
        lc.qtd++;

    }
}

void removePosicaoLE(int posicao, TListaCartas &lc){    //Função Remove posição
    for (int i = posicao; i < lc.qtd; i++){
        lc.elemento[i+1] = lc.elemento[i];
    }
    lc.qtd--;
}

void imprimir(TListaCartas lc){                         //Função Imprimir
    for (int i = 0; i < lc.qtd; i++){
        cout << lc.elemento[i].valor << " de " << lc.elemento[i].naipe << ".\n";
    }
}

void geraCartas(TListaCartas &lc){                      //Função Gera todas as cartas do deck
        for (int i = 0, j = 1; i < TAM; i++, j++){
            TCarta x;
        if(j == 14){
            j = 1;
        }
        if (i < 13){
            x.naipe = "Paus";
        }else if (i > 12 and i < 26){
            x.naipe = "Ouro";
        }else if (i > 25 and i < 39){
            x.naipe = "Copas";
        }else if (i > 38 and i < TAM){
            x.naipe = "Espadas";
        }

        x.valor = j;
        insereFimLE (lc, x);
    }
}

void embaralhar(TListaCartas &lc){                      //Função Embaralhar
    srand(time(NULL));
    int r;
    for (int i = 0; i < TAM; i++){
      r = rand()%TAM;
      TListaCartas temporario;
      temporario.elemento[i] = lc.elemento[i];
      lc.elemento[i] = lc.elemento[r];
      lc.elemento[r] = temporario.elemento[i];
  }
}

void distribuiCartas(TListaCartas &crupie, TListaCartas &jogadorCartas, int limite){//Distribui Cartas
    for (int i=0; i < limite; i++){
        insereFimLE(jogadorCartas, crupie.elemento[crupie.qtd-1]);
        removerFimLC(crupie);
    }
}

void organizarMesa(TListaCartas &mesa){                 //Organiza a mesa de menor para maior para facilitar a comparação
    int i, j, aux;
    int num = 5;
    for (i = 0; i < 5; i++){
        for (j = i+1; j < 5; j++){
            if (mesa.elemento[i].valor > mesa.elemento[j].valor){
                aux = mesa.elemento[i].valor;
                mesa.elemento[i] = mesa.elemento[j];
                mesa.elemento[j].valor = aux;
            }
        }
    }

}

void organizar(int vet[], int tam){                     //Organiza vetor auxiliar
    int i, j, aux;
    for (i = 0; i < tam; i++){
        for (j = i+1; j < tam; j++){
            if (vet[i] > vet[j]){
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
    }

}

void compara(TListaCartas mesa, TListaCartas jogador){ //Faz a comparação da mão com mesa
    //Junta vetores > Organiza sequencia > Contagem.
    int tam = 7;
    int vetor[7];
    int vetorauxiliar[4] = {0,0,0,0};
    int cont = 1;

    for (int i = 0; i < 5; i++){
        vetor[i] = mesa.elemento[i].valor;
    }
    for (int i = 5, j = 0; i < 7; i++,j++){
        vetor[i] = jogador.elemento[j].valor;
    }

    organizar(vetor, tam);

    int ant =vetor[0];
    for (int i = 1; i < 7; i++){
        if (ant != vetor[i] ){
            vetorauxiliar[cont-1]++;
            cont = 1;
        }else{
            cont++;
        }
        ant = vetor[i];
    }
    vetorauxiliar[cont-1]++;

    for (int i = 0; i < 4; i++){
        if (i == 0){
            cout << "\nNumeros sem pares ou trincas: ";
        }else if (i == 1){
            cout << "\nPares: ";
        }else if (i == 2){
            cout << "\nTrincas: ";
        }else if (i == 3){
            cout << "\nQuadras: ";
        }
        cout << vetorauxiliar[i];
    }
}


#endif // CARTAS_H_INCLUDED
