######################################################################
#	Exercício 02
# Implemente um laço de repetição do tipo for que conte de 0 a 7 e imprima o valor de contagem no
# console, conforme o exemplo abaixo:
# for (i=0; i<7; i++)
# cout << i;
# OBS: Este exercício aborda o uso de instruções de desvio (podem ser usadas pseudo-instruções),
# aritmética e da instrução syscall.

######################################################################

	
	.text	
loop:	

	li $v0, 1			# Intrução 1 (print_int)
	move $a0, $t0 			# $a0 << $t0
	syscall 			# Chama o sistema
	
	addi $t0, $t0, 1		# $t0 = $t0 + 1
	
	bne  $t0, 7, loop		# Se $t0 != 7, então chama label loop (Recursividade)
	beq $t0, 7, finaliza		# Se $t0 == 7, então chama label finaliza
	
	
finaliza:

	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema
	
