#####################################################################################################
# Disciplina: 4189 – Arquitetura e Organização de Computadores
# Atividade: Avaliação 03
# Academicos: - Guilherme Gustavo Gohr Darosci
# 	      - João Felipe Gonçalves
#
# Enunciado:
# Utilizando a linguagem de montagem do MIPS, implemente um programa sobre dados geográficos de
# países que realize a classificação dos mesmos sob diferentes indicadores (População, PIB per capita
# e IDH) utilizando o algoritmo de ordenação bubblesort implementado na forma de um procedimento.
#####################################################################################################
# $t0			Contador
# $t1			Utilizado para acessar o endereco da posicao do vetor
# $t2			Recebe o endereço da mensagem para ser usada no procedimento / Reutilizado para armazenar indicador
# $a0			Quantidade de paises
# $a1			Recebe vetor indicador para ser usado na funcao bubble
# $a2			Recebe vetor DDI para ser ordenado em conjunto ao indicador
# $k0			Recebe o tamanho dos vetores / numero de paises
# $k1			Recebe o endereco do vetor a trabalhar no procedimento
# $s4			Passa por parametro valor a ser mutiplicado (para IDH $s0 = 1000)
# Procedimentos de leitura de dados sao encerrador atraves da label divisor, a qual divide a leitura por "..." e continua o programa traves do comando "jr $ra"

	.data
	
msgTamanho:.asciiz 	"Entre com o numero de paises: "
msgInvalido:.asciiz 	"\nValor invalido! Digite um valor entre (2, 6)\n\n"
msgLeitura:.asciiz	"\nLEITURA:\n\n"
msgIndicador:.asciiz	"\nSelecione o indicador a ser utilizado para a classificação dos países:\n- 1. População\n- 2. PIB per capita\n- 3. IDH\n\nOpção:"
msgDivisor:.asciiz	"...\n"
msgFecha:.asciiz	"]: "
msgPula:.asciiz		"\n"

msgCriterio:.asciiz		"\nClassificação dos países para o critério selecionado: "
msgColocacao:.asciiz		"º lugar - DDI = "
msgColocPOP:.asciiz		" Populacao"
msgColocIDH:.asciiz		" IDH"
msgColocPIB:.asciiz		" PIB"
msgIgual:.asciiz		" = "

msgDDI:.asciiz 		"DDI["
msgPOP:.asciiz		"PO["
msgIDH:.asciiz		"IDH["
msgPIB:.asciiz		"PIB["
	
PaisesDDI:.word 0, 0, 0, 0, 0, 0
PaisesPOP:.word 0, 0, 0, 0, 0, 0
PaisesIDH:.word 0, 0, 0, 0, 0, 0
PaisesPIB:.word 0, 0, 0, 0, 0, 0

	.text
	
	j main				# Inicia o programa chamando a label principal (main)
	
entradaPaises:

	li $v0, 4			# (print_string)
	la $a0, msgTamanho		# Atribui o endereco de msgTamanho para $a0
	syscall				# Chamada do sistema
	
	li $v0, 5			# Read_int
	syscall				# Chamada do sistema
		
	ble $v0, 1, entradaInvalida	# Enquanto menor que 1, chama label invalido
	bge $v0, 7, entradaInvalida	# Enquanto maior que 7, chama label invalido
	
	move $k0, $v0			# Move o valor de $v0 para $k0 ( Recebe o tamanho dos vetores)
	jr $ra				# Continua o programa de onde parou para chamar entradaPaises
	
entradaInvalida:
	
	li $v0, 4			# (print_string)
	la $a0, msgInvalido		# Atribui o endereco de msgInvalido para $a0
	syscall				# Chamada do sistema
	j entradaPaises			# Volta a pedir um valor valido para numero de paises
	
leitura:
	###########################################################################################
	# Procedimento Leitura de vetor
	###########################################################################################
	# $t2		Endereco da mensagem	
	# $k1		Endereco do vetor
	# $s4		Multiplica a entrada 
	
	li $v0, 4			# print_string
	la $a0, ($s2)			# Atribui o endereco de $at para $a0
	syscall				# Chamada do sistema
	
	li $v0, 1			# print_int
	move $a0, $t0			# $a0 recebe o valor de $t0 ( contador )
	syscall				# Chamada do sistema	(imprimindo o indice)
	
	li $v0, 4			# print_string
	la $a0, msgFecha		# Atribui o endereco de msgFecha para $a0 ( "]: " )
	syscall				# Chamada do sistema
	
					# INICIO DO LAÇO
	li $v0, 5			# read_int
	syscall				# Chamda do sistema
	mul $v0, $v0, $s4		# Multiplica o valor digitado pelo usuario por $s4 passado por parametro
	
	mul $t1, $t0, 4			# Multiplica $t0 * 4 ( Contador * 4 bytes )
	add $t1, $t1, $s0		# $t1 recebe o indice multiplicado por 4 + $k1
	sw $v0, 0($t1)			# Armazena o valor de $v0 digitado pelo usuario no endereco de $t1
	
	addi $t0, $t0, 1		# $t0 = $t0 + 1			($t0++)
	blt $t0, $k0, leitura		# Laço - Enquanto $t0 for menor que $k0
					# FIM DO LAÇO
	
	li $v0, 4			# print_string
	la $a0, msgDivisor		# Atribui o endereco de msgDivisor ("...")
	syscall				# Chamada do sistema
	
	jr $ra				# Continua o programa de onde parou

indicador:
	
	li $v0, 4			# (print_string)
	la $a0, msgIndicador		# Atribui o endereco de msgIndicador para $a0
	syscall				# Chamada do sistema
	
	li $v0, 5			# read_int
	syscall				# Chamada do sistema
	move $t2, $v0			# Move o valor de $v0 para $t2 (indicador)
	
	ble $v0, 0, indicador		# Enquanto menor ou igual a 0, chama label indicador
	bge $v0, 4, indicador		# Enquanto maior ou igual a 4, chama label indicador
	
	jr $ra				# Continua o programa de onde parou
	
bubble:
	###########################################################################################
	# Bubblesort
	###########################################################################################
	# Ordenar DDI em conjunto
	# $a0		qtd paises
	# $a1		Recebe o vetor indicador
	# $a2		Recebe o vetor DDI
	# $s0		Recebe vetor indicador para manusealo
	# $s1		Recebe vetor indicador+1 para manusealo
	# $s2		Recebe vetor DDI para manusealo
	# $s3		Recebe vetor DDI+1 para manusealo
	
	subi $t7, $a0, 1		# Subtrai 1 de qtdPaises para o bubble não estourar e copia para $t7
	
externo:

	beq $t0, $t7, sairBubble	# Se $t1 for igual a $t7 pula para label sairBubble
	
	move $t1, $zero			# Zera contador $t1 para o label interno
	jal interno			# Pula para label interno
	addi $t0, $t0, 1		# $t0 += 1
	bne $t0, $a0, externo		# Enquanto $t0 não for igual a $a0 (qtd paises) entra na label externo
	
	j sairBubble			# Pula para bubble
	
interno:
					# VETOR DDI
	mul $s2, $t1, 4			# Armazena em $s2 Contador * 4 bytes
	add $s2, $s2, $a2		# $s2 recebe $s2 + $a2
	addi $s3, $s2, 4		# $s3 recebe o valor de $s2 + 4
	
					# VETOR DDI
	lw $t4, 0($s3)			# $t4 recebe vetor[indice + 1]
	lw $t5, 0($s2)			# $t5 recebe vetor[indice]
	
					# VETOR INDICADOR	
	mul $s0, $t1, 4			# Armazena em $s0 Contador * 4 bytes
	add $s0, $s0, $a1		# $s0 recebe $s0 + $a1
	addi $s1, $s0, 4		# $s1 recebe o valor de $s0 + 4
	
					# VETOR INDICADOR
	lw $t2, 0($s1) 			# $t2 recebe vetor[indice + 1]
	lw $t3, 0($s0) 			# $t3 recebe vetor[indice]
	
	bgt $t2, $t3, swap		# Se $t2 for maior que $t3 pula para label swap
	
	addi $t1, $t1, 1		# $t1 += 1
	bne $t1, $t7, interno		# Enquanto $t1 não for igual a $t7 (qtdPaises - 1) entra na label interno
	
	jr $ra				# Continua o programa de onde parou (externo)
	
swap:
					# VETOR DDI
	sw $t4, 0($s2)			# vetor[indice] recebe o valor de $t4
	sw $t5, 0($s3)			# vetor[indice+1] recebe o valor de $t5
	
					# VETOR INDICADOR
	sw $t2, 0($s0) 			# vetor[indice] recebe o valor de $t2
	sw $t3, 0($s1)			# vetor[indice+1] recebe o valor de $t3
	
	jr $ra				# Continua o programa de onde parou (interno)
	
	
imprimeClassificacao:
	# Ordem de concatenação
	# i + "msgColocacao" + DDI[i] + labelPAIS + valorPais[i]
	
	li $v0, 4			# print_string
	la $a0, msgPula			# Atribui o endereco de msgPula
	syscall				# Chamada do sistema
	
	li $v0, 1			# print_int
	move $a0, $t1			# $s7 recebe o valor de $t1 ( contador )
	syscall				# Chamada do sistema	(imprimindo o indice)
	
	li $v0, 4			# print_string
	la $a0, msgColocacao		# Atribui o endereco de msgColocacao
	syscall				# Chamada do sistema
	
					# DDI
	mul $s1, $t0, 4			# Armazena em $s1 Contador * 4 bytes
	add $s1, $s1, $a2		# $s1 recebe $s1 + $a1
	lw $t2, 0($s1)			# Recebe o valor da posição $s1 vetor DDI
	
	li $v0, 1			# print_string				(imprimindo o DDI)
	move $a0, $t2			# Atribui o endereco de $t2 para $a0
	syscall				# Chamada do sistema
	
	li $v0, 4			# print_string
	la $a0, ($t8)			# Atribui o endereco de $t8 para $a0
	syscall				# Chamada do sistema
	
	li $v0, 4			# print_string
	la $a0, msgIgual		# Atribui o endereco de msgIgual
	syscall				# Chamada do sistema
	
					# INDICADOR
	mul $s2, $t0, 4			# Armazena em $s1 Contador * 4 bytes
	add $s2, $s2, $a1		# $s1 recebe $s1 + $a1
	lw $t3, 0($s2)			# Recebe o valor da posição $s2 vetor DDI
	
	li $v0, 1			# print_string
	move $a0, $t3			# Atribui o endereco de $t3			TALVEZ TROCAR POR MOVE
	syscall				# Chamada do sistema
	
	addi $t1, $t1, 1			# $t1 += 1
	addi $t0, $t0, 1			# $t0 += 1
	bne $t0, $k0, imprimeClassificacao	# Enquanto $t0 não for igual a $a0 (qtd paises) entra na label externo
	
	jr $ra
	
	
main:
	# Procedimento principal (Main)
	
	jal entradaPaises		# Pula para label entradaPaises
	
	li $v0, 4			# print_string
	la $a0, msgLeitura		# Atribui a $a0 o endereco de msgLeitura
	syscall				# Chamada do sistema
	
					# EMPILHA
	addi $sp, $sp, -16  		# new 5 posições
	sw $s0, 0($sp)			# Empilha $s0
	sw $s1, 4($sp)			# Empilha $s1
	sw $s2, 8($sp)			# Empilha $s2
	sw $s3, 12($sp)			# Empilha $s3
	
	###############################################################
	# Leitura de dados
	###############################################################
	
	# Leitura vetor DDI
	
	la $s2, msgDDI			# Parametro mensagem
	la $s0, PaisesDDI		# Parametro vetor
	li $s4, 1			# Parametro nº multiplicavel
	move $t0, $zero			# Zera o contador
	
	jal leitura			# Pula para label leitura
	
	# Leitura vetor PO
	
	la $s2, msgPOP			# Parametro mensagem
	la $s0, PaisesPOP		# Paramentro vetor
	move $t0, $zero			# Zera o contador
	
	jal leitura			# Pula para label leitura
	
	# Leitura vetor IDH
	
	la $s2, msgIDH			# Parametro mensagem
	la $s0, PaisesIDH		# Parametro vetor
	li $s4, 1000			# Parametro nº multiplicavel
	move $t0, $zero			# Zera o contador
	
	jal leitura			# Pula para label leitura
	
	# Leitura vetor PIB
	
	la $s2, msgPIB			# Parametro mensagem
	la $s0, PaisesPIB		# Parametro vetor
	li $s4, 1			# Parametro nº multiplicavel
	move $t0, $zero			# Zera o contador
	
	jal leitura			# Pula para label leitura
	
	###############################################################
	
	# Indicador
	
	jal indicador			# Pula para label indicador (salva opcao em $v0)
	
	beq $t2, 1, indicadorPOP	# Se $t2 for igual a 1 vai para label indicadorPOP
	beq $t2, 2, indicadorPIB	# Se $t2 for igual a 2 vai para label indicadorPIB
	beq $t2, 3, indicadorIDH	# Se $t2 for igual a 3 vai para label indicadorIDH
	
indicadorPOP:
	la $a1, PaisesPOP		# $a1 recebe o endereco de PaisesPOP
	la $t8, msgColocPOP		# Atribui o endereco de msgColocPOP para $t8
	move $a0, $k0			# Atribui a $a0 a quantidade de paises
	j continua			# Pula para label continua
indicadorPIB:
	la $a1, PaisesPIB		# $a1 recebe o endereco de PaisesPIB
	la $t8, msgColocPIB		# Atribui o endereco de msgColocPIB para $t8
	move $a0, $k0			# Atribui a $a0 a quantidade de paises
	j continua			# Pula para label continua
indicadorIDH:
	la $a1, PaisesIDH		# $a1 recebe o endereco de PaisesIDH
	la $t8, msgColocIDH		# Atribui o endereco de msgColocIDH para $t8
	move $a0, $k0			# Atribui a $a0 a quantidade de paises
	j continua			# Pula para label continua
	
continua:
					# BUBBLESORT
	la $a2, PaisesDDI		# Atribui vetor DDI para $a2
	move $t0, $zero			# Zera contador
	
	jal bubble			# Pula para label bubble
sairBubble:	
					# IMPRESSÃO
	li $v0, 4			# print_string
	la $a0, msgCriterio		# Atribui o endereco de msgCriterio
	syscall				# Chamada do sistema
			
	li $v0, 4			# print_string
	la $a0, ($t8)			# Atribui o endereco
	syscall				# Chamada do sistema			
	
	move $t0, $zero			# Zera contador
	addi $t1, $zero, 1		# $t1 recebe 1
	
	la $a2, PaisesDDI		# Atribui vetor DDI para $a2
	jal imprimeClassificacao	# Chama label imprimeClassificacao
					
					# DESENPILHA
	lw $s0, 0($sp)			# Resgata o valor de $s0
	lw $s1, 4($sp)			# Resgata o valor de $s1
	lw $s2, 8($sp)			# Resgata o valor de $s2
	lw $s3, 12($sp)			# Resgata o valor de $s3
	addi $sp, $sp, 16   		# delete 5 posições	

	######################################################################
	# Finalizando o programa
	
	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema	(finalizando o programa)
	
	######################################################################
