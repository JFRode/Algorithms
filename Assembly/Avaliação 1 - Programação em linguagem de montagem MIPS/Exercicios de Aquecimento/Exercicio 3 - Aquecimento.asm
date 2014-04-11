###################################################################################################	
#	Exercício 03
# Implemente um programa que declare um vetor de inteiros com 8 elementos, solicite ao usuário a
# entrada dos elementos do vetor e, após a leitura dos 8 elementos, apresente o valor de cada
# elemento, em mensagens como as exemplificadas abaixo:
# LEITURA DOS ELEMENTOS DO VETOR:
# Entre com A[0]:
# ...
# Entre com A[7]:
# APRESENTAÇÃO DO VETOR LIDO:
# A[0] = 4
# ...
# A[7] = 7
# OBS: Este exercício aborda o uso de instruções de desvio (podem ser usadas pseudo-instruções), da
# instrução syscall e de instruções de acesso à memória (la, lw e sw).
#
###################################################################################################

	.data

msgLeitura:.asciiz "LEITURA DOS ELEMENTOS DO VETOR:\n"
msgImprime:.asciiz "ELEMENTOS DO VETOR:\n"
msgP1:.asciiz	"\nA["
msgP2:.asciiz	"]: "

array:.word 0,0,0,0,0,0,0		# - Label array com 7 espaços na memoria
			
	.text
main:
	####################################################################
	
	# Iniciando o vetor
		
	la $s0, array			# - Instrução Load Adress
	
	####################################################################
	# - Leitura dos valores do vetor
	####################################################################
	
	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgLeitura   		# Imprime "A[" no console
	syscall				# Chama o sistema
	
loop:

	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgP1   		# Imprime "A[" no console
	syscall				# Chama o sistema
	
	li $v0, 1			# print_int
	move $a0, $t0			# Move o conteudo de $t0 para $a0
	syscall				# Chama o sistema
	
	li $v0, 4			# $v0 = 4		(load_immediate)
	la $a0, msgP2			# $a0 = msgP2		(load_address)
	syscall				# Chama o sistema
	
	li $v0, 5 			# Intrução 5 (read_int)
	syscall 			# Chama o sistema  
	
	mul $t1, $t0, 4			# $t1= i*4
	add $t1, $t1, $s0		# 
	sw $v0, 0($t1)			# 
	
	addi $t0, $t0, 1		# $t0 ++
	bne $t0, 8, loop		# Se $t0 != 8, então chama label loop novamente
	
	####################################################################
	# - Imprimindo valores do vetor
	####################################################################
	
	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgImprime   		# Imprime "A[" no console
	syscall				# Chama o sistema
	
	move $t0, $zero			# Zerando registrador $t0
	
imprime:
	
	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgP1   		# Imprime "A[" no console
	syscall				# Chama o sistema
	
	li $v0, 1			# print_int
	move $a0, $t0			# Move o conteudo de $t0 para $a0
	syscall				# Chama o sistema
	
	li $v0, 4			# $v0 = 4		(load_immediate)
	la $a0, msgP2			# $a0 = msgP2		(load_address)
	syscall				# Chama o sistema
	
	# Atribui endereço da memoria do vetor
	
	mul $t1,$t0,4			# $t1= i*4
	add $t1,$t1,$s0			# $t1= $t1 + endereço-base
	
	lw $t3,0($t1)			# $t3= array[i]
	
	li $v0, 1			# Intrução 1 (print_int)
	move $a0,$t3 			#  Move $t3 para $a0
	syscall				# Chama o sistema
	
	addi $t0, $t0, 1		# $t0 = $t0 + 1
	bne $t0, 8, imprime		# if($t0!=8) volta pro label loop
	
	
finaliza:
	
	# Finalizando o programa
	
	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema
	
	######################################################################
