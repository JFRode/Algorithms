#include <iostream>
using namespace std;

/*
11. Faça um programa que solicita ao usuário o valor de N e calcule o valor de S na serie S = 1/1 + 1/2 + 1/3 + ... 1/N.
Ao fim exiba o real resultante da série.
*/

int main()
{
    int n;
    float resultado=0;

    cout << "Digite o valor de N:";
    cin >> n;

    for(int i=1;i <= n;i++){
        resultado = resultado + 1.0/i;
    }

    cout << resultado;
}
