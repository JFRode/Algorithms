#include <iostream>

using namespace std;

// 11. Faça um programa que solicita ao usuário uma quantidade de segundos, converte em horas, minutos e segundos e exibe na tela.


int main()
{
	int num, hrs, min, seg, aux;

	cout << "Digite uma quantidade de segundos:";
	cin >> num;

	hrs = num/3600;                                     //3600 é a quantidade de segundos contidas em uma hora.
	aux = (num%3600);                                   //Variavel auxiliar atribuida ao resto da divisão.

	min = aux/60;                                       //60 é a quantidade de segundos contidas em um minuto.

	seg = aux%60;


	cout << endl << hrs << ":" << min << ":" << seg;    //O comando endl pula uma linha
}
