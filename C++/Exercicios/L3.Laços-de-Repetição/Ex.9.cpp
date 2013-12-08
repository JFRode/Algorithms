#include <iostream>
using namespace std;

/*
9. Faça um programa para uma calculadora simples que solicita ao usuario dois operandos como entrada,
seleciona uma das opções da lista (1- Soma, 2- Produto, 3- Divisão, 4- potencia) e exibe o resultado.
O algoritmo deve executar repetidamente até que os dois operandos informados sejam iguais a zero.
Utilize uma variavel do tipo real para exibir o resultado.
*/

int main()
{
    int a, b, opcao;
    float resultado;
    bool programa = true;

    while(programa){
        cout << "Digite o valor de A:";
        cin >> a;

        cout << "Digite o valor de B:";
        cin >> b;

        if(a == 0 and b == 0){
            programa = false;
            break;
        }
        else {
            cout << "Digite a opcao desejada:\n\
            1 - Soma\n\
            2 - Produto\n\
            3 - Divisao\n\
            4 - Potencia\n";
            cin >> opcao;

            switch(opcao){
                case 1:
                    resultado = a + b;
                    break;
                case 2:
                    resultado = a * b;
                    break;
                case 3:
                    resultado = a/b;
                    break;
                case 4:
                    resultado = a;
                    for(int i=1;i < b;i++){
                        resultado = a * resultado;
                    }
                    break;
            }
            cout << "Resultado:" << resultado << endl;
        }
    }
}
