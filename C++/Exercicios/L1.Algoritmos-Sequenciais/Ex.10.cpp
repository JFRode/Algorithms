#include <iostream>

using namespace std;

/* 10. Faça um programa que converta um numero decimal digitado pelo usuário em binário.
O programa deve funcionar somente para numeros de 0 a 15.
*/


int main()
{
    int num, aux;
    int n1, n2, n3, n4;

    cout << "Digite um numero decimal:";
    cin >> num;

    n4 = num%2;
    num = num/2;

    n3 = num%2;
    num = num/2;

    n2 = num%2;
    num = num/2;

    n1 = num%2;
    num = num/2;

    cout << endl << n1 << n2 << n3 << n4;
}
