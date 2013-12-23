#include <iostream>
using namespace std;

/*
13. Faça um algoritmo que leia um conjunto de 20 numeros inteiros e indique, ao final, qual foi o menor valor digitado.
*/

int main()
{
    int n, menor;

    cout << "Digite um valor:";         //Solução encontrada para que a variavel 'menor' tenha um valor primario
    cin >> n;

    menor = n;
    for(int i=1;i < 5;i++){
        cout << "Digite um valor:";
        cin >> n;

        if(n < menor){
            menor = n;
        }
    }
    cout << "O menor numero digitado foi " << menor;
}
