#include <iostream>

using namespace std;

/*
5. Faça um programa que solicita ao usuario dois numeros inteiros. O primeiro é o valor das horas e o segundo dos minutos.
verifique se a hora é valida e exiba uma mensagem correspondente (considere a hora 24:00 como inválidada)Exiba:
    Caso verdadeiro: "A hora é válida"
    Caso falso: "A hora é inválida"
*/

int main()
{
    int hrs, min;

    cout << "Digite o valor das horas:";
    cin >> hrs;

    cout << endl << "Digite o valor dos minutos:";
    cin >> min;

    if((hrs >= 0 and hrs < 24) and (min >= 0 and min < 60)){
        cout << "A hora e valida";
    } else {
        cout << "A hora e invalida";
    }
}
