#include <iostream>

using namespace std;

/* 7. Faça um programa pra um terminal de auto-atendimento bancário que realiza saques em dinheiro.
O programa deve solicitar ao usuário qual o valor a ser retirado e deve exibir na tela qual a quantidade de cada cédula será entregue ao usuário.
O programa sempre deve tentar utilizar o menor número possivel de cédulas. A máquina possui apenas cédulas de R$10, 5 e 1.
Você deve exibir as variaveis que contem a quantidade de cédulas na seguinte ordem: 10, 5, 1.
*/

int main()
{
    int saque, dez, cinco, um;

    cout << "Digite o valor de saque:";
    cin >> saque;

    dez = saque/10;
    saque = saque%10;           //Reuso da variavel saque como auxiliar.

    cinco = saque/5;

    um = saque%5;

    cout << endl << "R$10,00: " << dez;
    cout << endl << "R$5,00: " << cinco;
    cout << endl << "R$1,00: " << um;
}
