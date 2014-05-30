Enunciado
=========
Utilizando a linguagem de montagem do MIPS, implemente um programa sobre dados geográficos de
países que realize a classificação dos mesmos sob diferentes indicadores (População, PIB per capita
e IDH) utilizando o algoritmo de ordenação bubblesort implementado na forma de um procedimento.

Requisitos:
===========

- 1. Declaração dos vetores: Na seção de declaração de variáveis (.data), devem ser declarados
vetores para armazenar os nomes e os indicadores geográficos de até 06 países, incluindo:
a. Vetor de inteiros com Código DDI dos países (identificador inteiro do País)
b. Vetor de inteiros com a População dos países expressa em Milhões de Habitantes
c. Vetor de inteiros com o IDH dos países multiplicado por 1000
d. Vetor de inteiros com o PIB per capita dos países

- 2. Entrada do tamanho dos vetores: A função principal (MAIN) deve solicitar o número de
países aceitando no mínimo 2 e no máximo 6 países. Para leitura, deve ser apresentada uma
mensagem solicitando a entrada desse valor, indicando o seu limite máximo.

- 3. Verificação do tamanho do vetores: A função principal (MAIN) deve solicitar a entrada do
número de elementos até que ele seja maior que 1 e menor ou igual a 6. Ou seja, deve
implementar um mecanismo de filtragem que não aceite entrada diferente da especificada. No
caso de entrada inválida, a função principal deve imprimir uma mensagem de advertência
antes de solicitar novamente a entrada.

- 4. Entrada dos elementos dos vetores: Para leitura, a função principal (MAIN) deve solicitar ao
usuário a entrada de cada elemento do vetor, um a um, com mensagens do tipo:

DDI[0] =

DDI[1] =

...

POP[0] =

POP[1] =

...

PIB[0] =

PIB[1] =

...

IDH[0] =

IDH[1] =

...

Exemplo: 03 países
País DDI População (Milhões) PIB per capita (US$) IDH (x1000)
Brasil 55 192 12492 718
França 33 65 44400 884
China 86 1338 8394 687
Obs: Dados obtidos na Embratel e na Wikipedia
5. Solicitação de indicador: A função principal (MAIN) deve solicitar ao usuário o indicador a ser
usado para classificar os países com mensagem do tipo:

Selecione o indicador a ser utilizado para a classificação dos países:

- 1. População

- 2. PIB per capita

- 3. IDH

Opção:

- 6. Interface da função principal com o procedimento: A função principal (MAIN) deve copiar o
número de países (tamanho do vetor) para o registrador $a0 e o endereço base do vetor
correspondente ao indicador selecionado para o registrador $a1 e o vetor endereço base do
vetor DDI para o registrador $a2 antes de chamar o procedimento BUBBLESORT.

- 7. Funcionalidade do procedimento: O procedimento BUBBLESORT deve realizar a ordenação
do vetor do indicador selecionado, com base no conteúdo dos seus elementos, e também do
vetor DDI (identificado do país), de acordo com a ordem estabelecida para o primeiro vetor.

- 8. Uso de registradores e da pilha pelo procedimento: Caso seja necessária a utilização de
algum registrador de uso geral (ex. para implementar laços de repetição), o procedimento
deve, OBRIGATORIAMENTE, utilizar apenas registradores salvos $s, preservando-os na pilha
no começo do procedimento e restaurando-os ao seu final.

- 9. Retorno do procedimento: Como o procedimento recebe os endereços base do vetor, não há
necessidade de retornar nenhum valor pelos registradores $v. A função principal terá acesso
aos vetores ordenados pelos registrador $a1 e $a2.

- 10. Impressão do vetor ordenado: Após o retorno do procedimento, a função principal MAIN
deve imprimir os vetores ordenados no terminal.

Classificação dos países para o critério selecionado: População

1o lugar - DDI = 86, População = 1338

2o lugar - DDI = 55, População = 192

3o lugar - DDI = 33, População = 65

Nota: Alternativamente, ao invés do DDI, pode ser impresso o nome do país (não obrigatório)

- 11. Estilo de codificação: O código deve ser escrito respeitando o estilo de programação ASM,
usando tabulação para organizar o código em colunas (rótulos, mnemônicos, operandos e
comentários).

- 12. Comentários: Procure comentar ao máximo o seu código. Isto é um hábito da programação
assembly.

- 13. Análise das instruções utilizadas: No seu relatório, apresente uma análise indicando a
contagem de instruções executadas para cada de classe utilizando a ferramenta “Instruction
Statistics” do MARS (conecte a ferramenta ao MIPS antes de executar a simulação), conforme
o exemplo anterior.

NOTA:
=====

Para ter certeza do funcionamento correto do procedimento em qualquer circunstância, durante o seu
teste, é recomendável que a função principal inicie todos os registradores $s utilizados pelo
procedimento com um valor diferente de 0, como, por exemplo:

addi $s0, $zero, 0xFFFFFFF0

addi $s1, $zero, 0xFFFFFFF1

addi $s2, $zero, 0xFFFFFFF2

...

Após a execução do procedimento, se ao retornar à função principal, os valores originais desses
registradores tiverem sido restaurados, então o tratamento da pilha estará correto.