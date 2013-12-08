#include <iostream>
using namespace std;

/*
2. Faça um programa que exiba na tela a tabuada do numero 5 no seguinte formato 5x1=5; 5x2=10; ...; 5x10=50.
*/

int main()
{
	for(int i=1;i <= 10;i++){
        cout << "5x" << i << "=" << 5*i << endl;
	}
}
