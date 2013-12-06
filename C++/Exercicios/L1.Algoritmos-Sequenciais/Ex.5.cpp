#include <iostream>

using namespace std;

/* 5. Faça um programa que solicita ao usário dois números inteiros e armazena nas variáveis A e B.
A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteudos fazendo com que valor que está em A passe para B e vice-versa.
Ao final exiba na tela os valores que ficaram armazenados nas variáveis.
*/

int main()
{
	int a, b,soma;

	cout << "Digite o valor de A:";
	cin >> a;

	cout << "\nDigite o valor de B:";
	cin >> b;

    a = a+b;
	b = a - b;
	a = a - b;

	cout << "A:" << a << "\nB:" << b;
}
