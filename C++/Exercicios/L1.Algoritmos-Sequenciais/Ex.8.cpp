#include <iostream>

using namespace std;

/* 8. Faça um programa para calcular e exibir o digito verificador de uma conta bancária.
O usuário deve digitar o número da conta que deve ser um numero inteiro com 4 digitos.
O digito verificador será calculado como segue:
    a. Passo 1: Somar todos os quatro digitos
    b. Passo 2: Multiplicar todos os quatro digitos
    c. Passo 3: Subtrair o resultado da multiplicação (passo 2) pelo resultado da soma(passo 1)
    d. Passo 4: O digito verificador será o resto da divisão do resultado da subtração (passo 3) por 9.
*/

int main()
{
    int num, a, b, c, d, passo1, passo2, passo3;

    cout << "Digite um valor com 4 digitos:";
    cin >> num;

    a = num/1000;
    num = num%1000;             //num como variavel auxiliar.

    b = num/100;
    num = num%100;              //num como variavel auxiliar.

    c = num/10;

    d = num%10;

    passo1 = a + b + c + d;
    passo2 = a * b * c * d;
    passo3 = passo2 - passo1;

    cout << "Digito verificador: " << passo3 % 9;
}
