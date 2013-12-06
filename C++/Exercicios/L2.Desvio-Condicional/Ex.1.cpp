#include <iostream>

using namespace std;

/*
1. Faça um programa que solicita ao usuário um numero inteiro e exibe este na tela.
Se o numero for negativo, antes de eser exibido, ele deve ser transformado no equivalente positivo.
*/

int main()
{
	int n;

	cout << "Digite um numero:";
	cin >> n;

	if(n < 0){
        n = n*(-1);
	}

	cout << endl << n;
}
