#ifndef PASCAL_H_INCLUDED
#define PASCAL_H_INCLUDED

//Procedimento que cria o Triangulo de Pascal
void pascal(){
    int c,l,n;
    cout << "Digite quantas linhas do Triangulo de Pascal voce deseja exibir: ";
    cin >> n;
    int **mat = new int*[n];    //A Alocação ocorre aqui

    for (int i=0; i < n; i++){  //Alocando
        mat[i] = new int[n];
    }

    //Insere os valores
    for (l=0; l<n; l++){
        for (c=0;c<=l;c++){
           mat[l][c] = (c==0 or c==l) ? 1 : mat[l-1][c]+mat[l-1][c-1];
        }
    }

    //Exibe o triangulo
    for (l=0;l<n;l++){
        for (c=0;c<=l;c++){
            cout << mat[l][c] << "\t";
        }
        cout << endl;
    }

    cout << "Pressione ENTER para continuar...";
    getch();
    clrscr();
}

#endif // PASCAL_H_INCLUDED
