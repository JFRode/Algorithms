#include <iostream>
using namespace std;

/*
17. Faça um programa que verifica se um numero digitado pelo usuario é um numero primo, ou seja um numero que só é divisivel por 1 e por ele mesmo.
*/

int main()
{
    int n;
    bool teste=true;

    cout << "Digite um valor:";
    cin >> n;

    for(int i=2;i < n;i++){
        if(n%i == 0){
            cout << "Nao e primo";
            return teste = false;
        }
    }
    if(teste){
        cout << "E primo";
    }
}
