#include <iostream>

using namespace std;

/*
2. Faça um programa que solicita ao usuário um valor inteiro e exibe uma mensagem informando se o numero é par ou impar. Exiba:
Caso verdadeiro: "Onumero é par"
Caso falso: "O numero é impar"
*/

int main()
{
	int n;

	cout << "Digite um valor:";
	cin >> n;

	if(n%2 == 0){
        cout << endl << "O numero e par";
	}else {
        cout << endl << "O numero e impar";
	}
}
