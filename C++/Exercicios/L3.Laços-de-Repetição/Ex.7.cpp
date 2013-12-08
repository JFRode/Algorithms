#include <iostream>
using namespace std;

/*
7. Faça um programa que solicita ao usuario uma quantidade indeterminada de numeros inteiros.
O programa deve calcular e escrever a média aritmetica apenas dos numeros pares.
A entrada de dados deve ser encerrada quando o numero 0 (ZERO) for digitado.
*/

int main()
{
    int n=1, acc = 0, cont = 0;
    bool programa = true;

    while(programa == true){
        cout << "Insira um valor inteiro:";
        cin >> n;

        if(n != 0){
            if(n%2 == 0){
                acc = acc + n;
                cont++;
            }
        }
        else if(cont > 0){
            cout << acc/cont;
            programa = false;
        }
    }
}
