Funções do Windows em seu programa
==================================
Aqui listo alguns comandos do Windows através do CMD (pronpt de comando) que é possivel utilizar dentro dos programas.
Para usar um comando no programa é nescessário usar a função system("comando").

- Exemplo de programa:

Parar o serviço do programa LogMeIn Hamachi:



    int r;
    
    cout << "Certifique-se de ter iniciado o programa como ADMINISTRADOR\n\n";
	cout << "Digite o numero da opcao desejada:\n\
	1 - Iniciar servico LogMeIn Hamachi\n\
	2 - Parar servico LogMeIn Hamachi\n\
	3 - Sair do programa\n";
	cin >> r;

	switch(r){
        case 1:
            system("net start Hamachi2Svc");
            break;
        case 2:
            system("net stop Hamachi2Svc");
            break;
        case 3:
            break;
	}

Comandos
========
-
