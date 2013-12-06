#include <iostream>

using namespace std;

/* 9. Faça um programa que solicita ao usuário um número inteiro com três digitos e exibe o número invertido
(ex: usuário digitou 136, programa exibirá 631).
*/

int main()
{
	int num, n1, n2, n3;

	cout << "Digite um valor a ser invertido:";
	cin >> num;

	n1 = num/100;                       //Captura de cada digito.
	n2 = (num%100)/10;
	n3 = (num%100)%10;

	num = n1 + n2*10 + n3*100;          //A variavel num passa a ser o sue proprio numero invertido.

	cout << num;
}
