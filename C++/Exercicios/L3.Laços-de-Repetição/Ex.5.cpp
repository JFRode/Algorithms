#include <iostream>
using namespace std;

/*
5. Faça um programa que exiba na tela a soma dos números inteiros do intervalo [100, 200]
*/

int main()
{
    int aux=0;

	for(int i=100;i <= 200;i++){
        aux = aux + i;
	}
	cout << aux;
}
