Solução de Problemas 3
======================
2º Periodo Ciência da Computação - 2013/2
Escrito por João Felipe Gonçalves e Guilherme Gustavo Gohr Darosci

Enunciado
=========
Crie um menu em que conste as seguintes opções:

• Opção 1 – Crivo de Erastótenes.

• Opção 2 – Triângulo de Pascal.

• Opção 3 – Desenvolvedor(es).

• Opção 4 – Sair.

Qualquer outra opção deve ser informada que é inválida, retornar ao menu e solicitar uma
nova opção.

O enunciado da Opção 1 segue abaixo:

 O Crivo de Eratóstenes é um algoritmo e um método simples e prático para
encontrar números primos até um certo valor limite. Segundo a tradição, foi criado
pelo matemático gregoEratóstenes (c. 285-194 a.C.), o terceiro bibliotecário-chefe
da Biblioteca de Alexandria (Fonte: Wikipédia).
Utilizando alocação dinâmica de memória com vetor faça um algoritmo que solicite
ao usuário um valor máximo (maior que 1 – garanta que isso ocorra) e informe, ao
final, todos os valores primos no intervalo entre 2 e o valor máximo, utilizando o
Crivo de Eratóstenes. Veja a explicação em
http://pt.wikipedia.org/wiki/Crivo_de_Erat%C3%B3stenes.

O enunciado da Opção 2 segue abaixo:

 O Triângulo de Pascal (alguns países, nomeadamente na França, é conhecido
como Triângulo de Tartaglia) é um triângulo numérico infinito formado por números
binomiais , onde representa o número da linha (posição vertical)
e representa o número da coluna (posição horizontal), iniciando a contagem a
partir do zero.1 O triângulo foi descoberto pelo matemático chinês Yang Hui, e 500anos 
depois várias de suas propriedades foram estudadas pelo francês Blaise
Pascal. O triângulo é infinito e simétrico se seus lados esquerdo e direito sempre
possuírem o número 1. Cada linha possui um número a mais que a linha
anterior. (Fonte: Wikipedia).
Utilizando alocação dinâmica de memória com matriz, solicite ao usuário a
quantidade de linhas desejadas e gere o triângulo de Pascal Simétrico (os espaços
vazios deverão ser preenchidos com 0).

Ao ser selecionada a opção 3 deve exibir na tela o nome dos desenvolvedores/desenvolvedor.
Outros itens:

• A resolução do crivo e do triângulo devem estar cada um em uma biblioteca diferente.
• Uma terceira biblioteca devem conter o menu e chamada das outras duas bibliotecas.
