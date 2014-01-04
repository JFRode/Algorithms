#ifndef ERASTOTENES_H_INCLUDED
#define ERASTOTENES_H_INCLUDED

bool verifica(int primo){                       //Verifica se a variavel é um numero primo ou não
    for(int i=2; i<primo; i++){
        if(primo%i == 0){
            return false;
        }
    }
    return true;
}


void erastotenes(){                      //Faz o Crivo de Erastotenes
    bool teste = true;
    int TAM;

    while(teste){
        cout << "Digite um numero de parada:\n";
        cin >> TAM;

        if(TAM > 1){                //Verifica se o valor é maior que zero
            int *vet;
            vet = new int[TAM];

            cout << "\nNumeros primos encontrados:\n";
            int indice=0;           //Variavel posição para vet

            for(int j=2;j <= TAM;j++){
                if(verifica(j)){
                    vet[indice] = j;
                    indice++;
                }
            }
            for(int i=0; i<indice; i++){ //Exibe na tela os numeros primos alocados no vetor
                cout << vet[i] << endl;
            }
            delete []vet;           //Vetor deletado

            cout << "Pressione ENTER para continuar...";
            getch();
            clrscr();
            teste = false;          //Necessário para que o while(teste) tenha uma parada
        }
    }
}

#endif // ERASTOTENES_H_INCLUDED
