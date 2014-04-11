###########################################################################################
# - PROGRAMA 1
# 
# Implemente um programa que leia um vetor com 8 elementos via console, carregue todos os
# elementos do vetor na memória e calcule a média aritmética entre esses 8 na tela.
###########################################################################################
# $s0 		Vetor A de 8 posições
# $t0		Indice do laço. Também usado para fazer a multiplicação por byte
# $t1		Recebe a multiplicação do indice * 4. Sendo utilizado para acessar a posição do vetor
# $t2		Recebe os valores atribuidos do vetor A, e repassa para $t3
# $t3 		Acumula todos os valores atribuidos ao vetor

	.data
	
msgLeitura:.asciiz	"LEITURA DOS ELEMENTOS DO VETOR:\n"
msgSaida:.asciiz	"SAIDA DOS ELEMENTOS DO VETOR:\n"
msgAritmetica:.asciiz	"\n\nA média dos elementos do vetor é igual a "

msgA1:.asciiz	"A["
msgA2:.asciiz	"]: "
	
	
Vetor_A:.word 0, 0, 0, 0, 0, 0, 0, 0	# Reserva 8 posições zeradas na memoria para Vetor_A

	.text
main:
	
	la $s0, Vetor_A			# Atribui Vetor_A para $s0
	
	###########################################################################################
	# Leitura dos dados do Vetor_A
	###########################################################################################
	
	li $v0, 4			# Intrução 4 (print_string)
	la $a0, msgLeitura		# Imprime "LEITURA DOS ELEMENTOS DO VETOR:"
	syscall				# Chama o sistema
	
leitura:
	
	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgA1   		# Imprime "A["
	syscall				# Chama o sistema
	
	li $v0, 1			# Intrução 1 (print_int)
	move $a0, $t0			# Move o conteudo do registrador acumulador $t0 para $a0
	syscall				# Chama o sistema
	
	li $v0, 4			# Intrução 4 (print_string)	
	la $a0, msgA2			# Imprime "]: "
	syscall				# Chama o sistema
	
	li $v0, 5 			# Intrução 5 (read_int)
	syscall 			# Chama o sistema
	
	mul $t1, $t0, 4			# $t1= i*4
	add $t1, $t1, $s0		# $t1 = $t1 + $s0
	sw $v0, 0($t1)			# Memória[$t1+0] = $v0
	
	addi $t0, $t0, 1		# $t0 ++
	bne $t0, 8, leitura		# Se $t0 != 8 então chama label leitura
	
	###########################################################################################
	# Acumulando valores do vetor
	###########################################################################################
	
	move $t0, $zero			# Zerando $t0 para ser usado novamente como indice do laço
	
acumula:

	mul $t1, $t0, 4			# $t1 = indice * 4		($t0 é o indice deste laço)
	add $t1, $t1, $s0		# $t1 = $t1 + $s0
	
	lw $t2, 0($t1)			# $t2 = Memória[$t1 + 0]	A[0]
	add $t3, $t3, $t2		# $t3 = $t3 + $t2		(Acumulador)
	
	addi $t0, $t0, 1		# $t0 ++
	bne $t0, 8, acumula		# Enquanto $t0 != 8 chama label leitura
	
	###########################################################################################
	
	# Media Aritmética
	
	srl $t1, $t3, 3			# $t1 recebe $t3 deslocado para direita. 2 no expoente 3 é 8	(shift_right_logical)
	
	###########################################################################################
	
	# Imprimindo no console
	
	li $v0, 4			# $v0 = 4
	la $a0, msgAritmetica		# $a0 recebe msgAritmetica
	syscall				# Chama o sistema
		
	li $v0, 1			# Intrução 1 		(print_int)
	move $a0, $t1			# $a0 recebe $t1
	syscall  			# Chama o sistema
	
	######################################################################
	
	# Finalizando o programa
	
	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema	(finalizando o programa)
	
	######################################################################
