#include <iostream>

using namespace std;

/*
3. Faça um programa que solicita ao usuario uma letra e verifique se ela é uma vogal ou não exibindo uma mensagem correspondente. Exiba:
caso verdadeiro: "É uma vogal"
caso falso: "Não é uma vogal"
*/

int main()
{
	char letra;

	cout << "Insira uma letra:";
	cin >> letra;

	if(letra == 'a' or letra == 'e' or letra == 'i' or letra == 'o' or letra == 'u'){
        cout << "E uma vogal";
	} else {
        cout << "Nao e uma vogal";
	}
}
