#include <iostream>

using namespace std;

/*
9. Faça um programa que solicita ao usuario seu nome e as notas de tres provas.
Calcule a media aritmetica e informe se o aluno foi Aprovado ou Reprovado
(o aluno é considerado aprovado com a media igual ou superior a 6)
*/

int main()
{
    string nome;
    float media;
    int n1, n2, n3;

    cout << "Digite seu nome:";
    cin >> nome;

    cout << "Digite a PRIMEIRA nota:";
    cin >> n1;

    cout << "Digite a SEGUNDA nota:";
    cin >> n2;

    cout << "Digite a TERCEIRA nota:";
    cin >> n3;

    media = n1 + n2 + n3;

    if(media/3 >= 6){
        cout << nome << " voce foi APROVADO!";
    } else {
        cout << nome << " voce esta reprovado.";
    }

}
