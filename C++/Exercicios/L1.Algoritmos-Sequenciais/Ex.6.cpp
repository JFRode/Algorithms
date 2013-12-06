#include <iostream>

using namespace std;

/* 6. O sistema de avaliação de determinada disciplina, é composto por três provas. A primeira prova tem peso 2,
a segunda tem peso 4 e a terceira prova tem peso 6. Faça um programa que solicita as notas para o aluno,
calcula e exibe a média final deste aluno.
*/

int main()
{
	int prova1, prova2, prova3;

	cout << "Digite o resultado da PRIMEIRA prova(peso 2):";
	cin >> prova1;

	cout << "\nDigite o resultado da SEGUNDA prova(peso 4):";
	cin >> prova2;

	cout << "\nDigite o resultado da TERCEIRA prova(peso 6):";
	cin >> prova3;

    prova1 = prova1*2;
    prova2 = prova2*4;
    prova3 = prova3*6;

	cout << "\n\nMedia final:" << (prova1 + prova2 + prova3)/12;    //Dividido por 12 pois é a soma dos pesos
}
