#include <iostream>

using namespace std;

/*
7. Faça um programa que solicita um numero inteiro e exibe uma mensagem indicando se ele é positivo, negativo ou zero. Exiba
    Caso ele seja positivo: "Ele e positivo"
    Caso ele seja negativo: "Ele e negativo"
    Caso seja igual a zero: "Ele e igual a zero"
*/

int main()
{
    int n;

    cout << "Digite um numero:";
    cin >> n;

    if(n != 0){
        if(n > 0){
            cout << "Ele e positivo";
        } else {
            cout << "Ele e negativo";
        }
    } else {
        cout << "Ele e igual a zero";
    }
}
