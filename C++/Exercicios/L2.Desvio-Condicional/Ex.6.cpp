#include <iostream>

using namespace std;

/*
6. Faça um programa que exiba o maior dentre dois numeros reais digitados pelo usuario.
Caso eles sejam iguais exiba a mensagem correspondente.
*/

int main()
{
    float a, b;

    cout << "Digite o valor de A:";
    cin >> a;

    cout << endl << "Digite o valor de B:";
    cin >> b;

    if(a != b){
        if(a > b){
            cout << a << " e maior";
        } else {
            cout << b << " e maior";
        }
    } else {
        cout << "A e B sao iguais";
    }
}
