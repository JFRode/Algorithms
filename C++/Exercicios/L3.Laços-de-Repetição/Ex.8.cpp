#include <iostream>
using namespace std;

/*
8. Faça um programa que solicita ao usuario um numero real positivo. Verifique se o numero é realmente positivo,
e em caso contrario solicite ao usuario digitar novamente (este processo pode se repetir inumeras vezes e é chamado de consistencia,
pois garante que o numero será valido apos a entrada de dados).
*/

int main()
{
    float n = -1;

    while(n < 0){
        cout << "Digite um valor positivo:";
        cin >> n;
    }
}
