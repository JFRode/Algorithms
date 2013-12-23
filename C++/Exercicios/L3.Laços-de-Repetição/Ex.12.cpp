#include <iostream>
using namespace std;

/*
12. Faça um programa que solicita a idade de 10 pessoas e exiba a quantidade de pessoas que possui idade maior ou igual a 18 anos.
*/

int main()
{
    int idade, contador=0;

    for(int i=1;i <= 10;i++){
        cout << "Digite a idade da pessoa " << i << ":";
        cin >> idade;

        if(idade >= 18){
            contador ++;
        }
    }
    cout << contador << " pessoas maiores de 18 anos";
}
