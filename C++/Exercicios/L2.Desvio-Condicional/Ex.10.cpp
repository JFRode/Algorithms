#include <iostream>

using namespace std;

/*
10. Faça um programa que solicita ao usuario tres valores correspondentes aos lados de um triangulo.
Informe se o triangulo é equilatero (possui 3 lados iguais) , isóceles (possui dois lados iguais) ou escaleno (não possui lados iguais).
*/

int main()
{
    int L1, L2, L3;

    cout << "Digite 3 valores correspondentes aos lados do triangulo:";
    cin >> L1 >> L2 >> L3;

    if (L1 == L2 and  L2 == L3){
			cout << "O triangulo e equilatero!";
		}else{
			if(L1 != L2 and  L2 != L3){
				cout << "O triangulo e escaleno!";
			}else {
				cout << "O triangulo e isoseles!";
			}
		}
}
