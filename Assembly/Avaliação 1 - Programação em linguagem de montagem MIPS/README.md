Avaliação 01 – Programação em linguagem de montagem
===================================================
UNIVALI – CTTMAR – Curso de Ciência da Computação
Disciplina: CC4189 – Arquitetura e Organização de Computadores
Prof. Cesar Albenes Zeferino
Avaliação 01 – Programação em linguagem de montagem

Acadêmicos: Guilherme Gustavo Gohr Darosci & João Felipe Gonçalves

EXERCÍCIOS DE AQUECIMENTO
=========================

Os exercícios propostos abaixo são sugeridos para fins de aquecimento (não valem nota). Tente(m)
fazê-los antes de iniciar a implementação dos programas desta avaliação (Programa 01 e Programa
02). Isso os ajudará a consolidar os fundamentos da programação na linguagem de montagem do
MIPS antes da implementação de algoritmos mais completos.


- Exercício 01

Usando a instrução syscall, implemente um programa que: (1) solicite ao usuário que forneça dois
números inteiros (X e Y); (2) realize operações aritméticas (adição e subtração) e lógicas (and, or e
not) entre esses dois valores. O programa deve apresentar no console mensagens do tipo:

Entre com o valor de X:
Entre com o valor de Y:

A + B =
A - B =
A & B =
A | B =
A ^ B =

OBS: Este exercício aborda o uso da instrução syscall, das instrução add, sub, and, or e
sub e dos registradores.


- Exercício 02

Implemente um laço de repetição do tipo for que conte de 0 a 7 e imprima o valor de contagem no
console, conforme o exemplo abaixo:
for (i=0; i<7; i++)
cout << i;
OBS: Este exercício aborda o uso de instruções de desvio (podem ser usadas pseudo-instruções),
aritmética e da instrução syscall.


- Exercício 03

Implemente um programa que declare um vetor de inteiros com 8 elementos, solicite ao usuário a
entrada dos elementos do vetor e, após a leitura dos 8 elementos, apresente o valor de cada
elemento, em mensagens como as exemplificadas abaixo:
LEITURA DOS ELEMENTOS DO VETOR:
Entre com A[0]:
...
Entre com A[7]:
APRESENTAÇÃO DO VETOR LIDO:
A[0] = 4
...
A[7] = 7
OBS: Este exercício aborda o uso de instruções de desvio (podem ser usadas pseudo-instruções), da
instrução syscall e de instruções de acesso à memória (la, lw e sw).
NOTAS:
• No Apêndice A, publicado no ambiente Sophia, estão listadas todas as instruções e pseudoinstruções
do MIPS, incluindo diferentes instruções úteis para comparação de valores e desvio
condicional.
• No ambiente Sophia, está disponibilizado um programa exemplo que explica como realizar a
interface de entrada e de saída com o usuário via chamadas de sistema (syscall).


PROGRAMA 01
===========
Enunciado:
Implemente um programa que leia um vetor com 8 elementos via console, carregue todos os
elementos do vetor na memória e calcule a média aritmética entre esses 8 na tela.
Leia atentamente cada requisito listado abaixo, pois o atendimento deles será considerado para fins
de avaliação (o não atendimento de algum requisito implica em desconto de nota).
Requisitos:

1. Na seção de declaração de variáveis (.data), o vetor deve ser declarado com 8 elementos
inicializados em 0. Ele deve ser claramente identificado com um nome como Vetor_A, por
exemplo.

2. O programa deve solicitar a entrada dos elementos do vetor. O programa deve solicitar ao
usuário a entrada de cada elemento do vetor, um a um, com mensagens do tipo:
Vetor_A[0] =
...
Vetor_A[7] =

3. Só após a entrada de todos os elementos do vetor e do armazenamento deles na memória, o
programa deve percorrer o vetor e realizar o somatório do conteúdo de seus elementos. Após,
deve deslocar o somatório calculado à direita na quantidade de vezes necessária para calcular
a média aritmética de oito números.

4. Ao final, o programa deve informar ao usuário o valor calculado utilizando uma mensagem do
tipo: “A média dos elementos do vetor é igual a”.

5. O programa deve ser escrito respeitando o estilo de programação ASM, usando tabulação para
organizar o código em colunas (rótulos, mnemônicos, operandos e comentários).

6. Procure comentar ao máximo o seu código. Isto é um hábito da programação assembly.

7. No seu relatório, apresente uma análise indicando a contagem de instruções executadas para
cada de classe utilizando a ferramenta “Instruction Statistics” do MARS (conecte a ferramenta
ao MIPS antes de executar a simulação), conforme o exemplo abaixo:
Classe No de execuções Percentual
Aritmética e lógica (ALU) 4 67%
Desvio incondicional (Jump) 0 0%
Desvio condicional (Branch) 0 0%
Acesso à memória (Memory) 2 33%
Outras (Other) 0 0%


PROGRAMA 02
===========

Enunciado:
Implemente um programa que leia dois vetores via console e, após a leitura dos vetores, produza um
terceiro vetor em que cada elemento seja a média aritmética dos elementos de mesmo índice dos
outros dois vetores. Por fim, o programa deve imprimir esse novo vetor na tela.
Leia atentamente cada requisito listado abaixo, pois o atendimento deles será considerado para fins
de avaliação (o não atendimento de algum requisito implica em desconto de nota).
Requisitos:

1. Na seção de declaração de variáveis (.data), cada vetor deve ser declarado com 8 elementos
inicializados em 0. Eles devem ser claramente identificados com nomes como Vetor_A,
Vetor_B e Vetor_C, por exemplo.

2. O programa deve solicitar o número de elementos dos vetores aceitando no máximo vetores
com 8 elementos. Para leitura, deve ser apresentada uma mensagem solicitando a entrada
desse valor, indicando o seu limite máximo. Ex: “Entre com o tamanho dos vetores (máx.
= 8).”.

3. O programa deve solicitar a entrada do número de elementos até que ele seja maior que 1 e
menor ou igual a 8. Ou seja, deve implementar um mecanismo de filtragem que não aceite
entrada diferente da especificada. No caso de entrada inválida, o programa deve imprimir uma
mensagem de advertência antes de solicitar novamente a entrada. Ex: “Valor inválido”.

4. O programa deve primeiramente ler todos os elementos do Vetor_A antes de iniciar a leitura
dos elementos do Vetor_B . Para leitura, o programa deve solicitar ao usuário a entrada de
cada elemento do vetor, um a um, com mensagens do tipo:
Vetor_A[0] =
Vetor_A[1] =
...
Vetor_B[0] =
Vetor_B[1] =
...
5. Após a entrada dos elementos dos dois vetores, o programa deve somar os elementos de
mesmo índice dos dois vetores, calcular a média aritmética utilizando uma operação de
deslocamento e armazenar o resultado de cada operação no elemento de posição
correspondente do Vetor_C.

6. Ao final, o programa deve apresenta ao usuário os elementos do terceiro vetor com mensagens
do tipo:
Vetor_C[0] =
Vetor_C[1] =
...
7. Os programas devem ser escritos respeitando o estilo de programação ASM, usando tabulação
para organizar o código em colunas (rótulos, mnemônicos, operandos e comentários).

8. Procure comentar ao máximo o seu código. Isto é um hábito da programação assembly.

9. No seu relatório, apresente uma análise indicando a contagem de instruções executadas para
cada de classe utilizando a ferramenta “Instruction Statistics” do MARS (conecte a ferramenta
ao MIPS antes de executar a simulação), conforme o exemplo anterior.