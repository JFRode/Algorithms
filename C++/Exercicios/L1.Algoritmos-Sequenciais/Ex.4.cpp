#include <iostream>

using namespace std;

/* 4. Faça um programa que calcula os gastos com combustivel em uma viagem.
O programa deve solicitar ao usuário a distancia a ser percorrida em Km, o consumo do carro em Km/litro e o preço do litro do combustivel.
Como resposta o programa deverá informar qual o valor em R$ a ser gasto com  combustivel na viagem.
*/

int main()
{
	float distancia, consumo, preco;

	cout << "Digite a distancia em Km:";
	cin >> distancia;

	cout << "\nDigite o consumo do carro em Km/litro:";
	cin >> consumo;

	cout << "\nDigite o preco litro:";
	cin >> preco;

	cout << "\n\n O valor a sera R$" << (preco/consumo) * distancia;
}
