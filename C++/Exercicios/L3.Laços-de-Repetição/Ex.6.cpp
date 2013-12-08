#include <iostream>
using namespace std;

/*
6. Faça um programa que solicita ao usuario dois valores inteiros e positivos que serão a base e o expoente.
O programa deve calcular e escrever o resultado da base elevado a potencia.
*/

int main()
{
    int base, expoente, acc;

    cout << "Digite a base:";
    cin >> base;

    cout << "Digite o expoente:";
    cin >> expoente;
    acc = base;

    for(int i=1;i < expoente;i++){
        acc = base * acc;
    }
    cout << acc;
}
