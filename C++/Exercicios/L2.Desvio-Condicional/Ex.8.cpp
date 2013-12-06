#include <iostream>

using namespace std;

/*
8. Faça um programa que solicita ao usuario tres numeros reais e exibe na tela apenas o menor deles.
*/

int main()
{
    float a, b, c;

    cout << "Digite 3 numeros:";
    cin >> a >> b >> c;

    if(a > b and a > c){
        cout << a;
    }
    if(b > a and b > c){
        cout << b;
    }
    if(c > a and c > b){
        cout << c;
    }
}
