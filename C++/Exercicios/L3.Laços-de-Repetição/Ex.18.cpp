#include <iostream>
using namespace std;

/*
18. Faça um programa que exiba na tela a tabuada de todos os numeros desde o 1 até o 10.
*/

int main()
{
    for(int i=1;i <= 10;i++){
        for(int j=0;j <= 10;j++){
            cout << i << "x" << j << "=" << i*j << endl;
        }
        cout << endl;
    }
}
