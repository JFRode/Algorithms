#include <iostream>

using namespace std;

/*
4. Faça um programa que solicita a data de nascimento de uma pessoa e a data atual e exiba a idade desta pessoa em anos
(A data deve ser armazenada em 3 variaveis inteiras para ano, mes e dia).
*/

int main()
{
    int diaA, mesA, anoA;       //Data atual
    int dia, mes, ano;          //Data nascimento

    cout << "Digite sua data de nascimento(dia/mes/ano):";
    cin >> dia >> mes >> ano;

    cout << endl << "Digite a data atual:";
    cin >> diaA >> mesA >> anoA;


    if(mes < mesA and dia < diaA){
        cout << endl << "Idade:" << anoA - ano;
    } else {
        cout << endl << "Idade:" << anoA - ano - 1;
    }
}
