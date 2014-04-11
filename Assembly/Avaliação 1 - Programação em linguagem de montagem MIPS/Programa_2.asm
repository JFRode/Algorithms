######################################################################################################
# - PROGRAMA 2
#
# Implemente um programa que leia dois vetores via console e, após a leitura dos vetores, produza um
# terceiro vetor em que cada elemento seja a média aritmética dos elementos de mesmo índice dos
# outros dois vetores. Por fim, o programa deve imprimir esse novo vetor na tela.
######################################################################################################
# $a0 = Vetor_A
# $a1 = Vetor_B
# $a2 = Vetpr_C


	.data
	
msgLeitura:.asciiz	"LEITURA DOS ELEMENTOS DO VETOR:"
msgSaida:.asciiz	"SAIDA DOS ELEMENTOS DO VETOR:\n"
msgAritmetica:.asciiz	"\n\nA média dos elementos do vetor é igual a "

msgA0:.asciiz	"\nVetor_A[0]: "
msgA1:.asciiz	"\nVetor_A[1]: "
msgA2:.asciiz	"\nVetor_A[2]: "
msgA3:.asciiz	"\nVetor_A[3]: "
msgA4:.asciiz	"\nVetor_A[4]: "
msgA5:.asciiz	"\nVetor_A[5]: "
msgA6:.asciiz	"\nVetor_A[6]: "
msgA7:.asciiz	"\nVetor_A[7]: "

msgB0:.asciiz	"\nVetor_B[0]: "
msgB1:.asciiz	"\nVetor_B[1]: "
msgB2:.asciiz	"\nVetor_B[2]: "
msgB3:.asciiz	"\nVetor_B[3]: "
msgB4:.asciiz	"\nVetor_B[4]: "
msgB5:.asciiz	"\nVetor_B[5]: "
msgB6:.asciiz	"\nVetor_B[6]: "
msgB7:.asciiz	"\nVetor_B[7]: "

msgC0:.asciiz	"\nVetor_C[0] = "
msgC1:.asciiz	"\nVetor_C[1] = "
msgC2:.asciiz	"\nVetor_C[2] = "
msgC3:.asciiz	"\nVetor_C[3] = "
msgC4:.asciiz	"\nVetor_C[4] = "
msgC5:.asciiz	"\nVetor_C[5] = "
msgC6:.asciiz	"\nVetor_C[6] = "
msgC7:.asciiz	"\nVetor_C[7] = "


Vetor_A:.word 0,0,0,0,0
Vetor_B:.word 0,0,0,0,0
Vetor_C:.word 0,0,0,0,0

	.text
main:
	la $a0, Vetor_A			# Atribui Vetor_A para $a0
	la $a1, Vetor_B			# Atribui Vetor_B para $a1
	la $a1, Vetor_C			# Atribui Vetor_C para $a2
	
	li $v0, 4			# Intrução 4 (print_string)
	la $a0, msgLeitura		# Titulo LEITURA DOS ELEMENTOS
	syscall				# Chama o sistema
	
	###########################################################################################
	# Leitura dos dados do Vetor_A
	###########################################################################################
	
	# Vetor_A[0]
	
	li $v0, 4
	la $a0, msgA0
	syscall
	
	li $v0, 5			# Intrução 5 (read_int)
	syscall				# Chamada do sistema
	sw $v0, 0($a0)			# Memória[$a0 + 0] = $v0	(onde 0 é indice * 4)



