#include <iostream>
using namespace std;

/*
10. Faça um programa que gere e exiba os 20 primeiros termos da série de Fibonacci (Os dois primeiros termos da serie são 1 e 1
os termos subsequentes são a soma dos dois ultimos. Observe oi exemplo: (1,1,2,3,5,8,13,21,...).
*/

int main()
{
    int opcao ,a=0, b=1, aux;

    cout << "Digite um numero de parada:";
    cin >> opcao;

    cout << "1\n";                          //Solução inplementada para imprimir o inicio na série

    for(int i=0;i < opcao;i++){
        aux = a + b;
        cout << aux << endl;
        a = b;
        b = aux;
    }
}
