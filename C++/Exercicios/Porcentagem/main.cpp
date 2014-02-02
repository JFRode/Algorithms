#include <iostream>
#include <conio2.h>
using namespace std;

int main()
{
    system("title Desconto de produto");
	float valor, porcento;
    bool programa = true;

    while(programa){
        textcolor(WHITE);
        cout << "Digite 0 (zero) para fechar o programa\n\
        Preco do produto:";
        cin >> valor;

        if(valor == 0){             //*
            programa = false;       //* Teste
            break;                  //*
        }

        cout << "Quanto Porcento de desconto:";
        cin >> porcento;


        textcolor(LIGHTGREEN);
        cout << endl << valor << "$ com " << porcento << "% de desconto fica ";

        textcolor(WHITE);                           //*
        porcento = 100 - porcento;                  //*  Calculo e exibição
        cout << valor * (porcento/100) << "$\n\n\n";//*

        textcolor(LIGHTGRAY);
        cout << "Precione ENTER para continuar...\n\n";
        getch();
    }
}
