############################################################################
#
#	Exercício 1 - Aquecimento
#	Usando a instrução syscall, implemente um programa que:
#	(1) solicite ao usuário que forneça dois números inteiros (X e Y);
#	(2) realize operações aritméticas (adição e subtração)
#	e lógicas (and, or e xor) entre esses dois valores.
#	O programa deve apresentar no console mensagens do tipo:
#
#
#		Entre com o valor de X: 
#		Entre com o valor de Y: 
#		A + B = 
#		A - B = 
#		A & B = 
#		A | B = 
#		A ^ B =
#
############################################################################

	.data  		

msgX:.asciiz 		"\nEntre com o valor de X: "
msgY:.asciiz 		"\nEntre com o valor de Y: "

opSoma:.asciiz 		"\nA + B = "
opSub:.asciiz 		"\nA - B = "
opAND:.asciiz 		"\nA & B = "
opOR:.asciiz		"\nA | B = "

opNOTX:.asciiz 		"\nA ^ B = " 
opNOTY:.asciiz		" e "

	.text
main:
 	######################################################################
 	
	# Entrada de dados
	
	li $v0, 4   			# Instrução 4 (print_string)
	la $a0, msgX   			# Carrega address msgX para $a0
	syscall				# Chama o sistema
	
	li $v0, 5 			# Intrução 5 (read_int)
	syscall 			# Chama o sistema
	add $t0, $v0, $zero		# $t0 guarda X
	
	li $v0, 4  			# Intrução 4 (print_string)
	la $a0, msgY			# Carrega address msgY para $a0
	syscall				# Chana o sistema
	
	li $v0, 5 			# Intrução 5 (read_int)
	syscall 			# Chama o sistema
	add $t1, $v0, $zero 		# $t1 guarda Y
	
	######################################################################
	
	# Soma
	
	li $v0, 4			# Instrução 4 (print_string)
	la $a0, opSoma			# Carregando asc soma à $a0
	syscall				# Chama o sistema
	
	add $t2, $t0, $t1  		# $t2 = $t0 + $t1
	li $v0, 1 			# Instrução 1 (print_int)
	move $a0, $t2 			# $a0 << $t2
	syscall  			# Chama o sistema
	
	######################################################################
	
	# Subtração

	li $v0, 4			# Instrução 4 (print_string)
	la $a0, opSub			# $a0 recebe o endereço de opSub
	syscall				# Chama o sistema
	
	sub $t2, $t0, $t1		# $t2 = $t0 - $t1
	li $v0, 1			# Instrução 1 (print_int)
	move $a0, $t2			# $a0 << $t2
	syscall				# Chama o sistema
	
	######################################################################
	
	# AND
	
	li $v0, 4			# Intrução 4 (print_string) 
	la $a0, opAND			# Carrega o endereço de opAND para $a0
	syscall				# Chama o sistema
	
	and $t2, $t0, $t1		# $t2 = $t0 AND $t1
	li $v0, 1			# $v0 = 1		(load_immediate)
	move $a0, $t2			# $a0 << $t2
	syscall				# Chama o sistema
	
	######################################################################
	
	# OR
	
	li $v0, 4			# Intrução 4 (print_string)
	la $a0, opOR			# $a0 recebe o endereço de opOR
	syscall				# Chama o sistema
	
	or $t2, $t0, $t1		# $t2 = $t0 OR $t1
	li $v0, 1			# print_int
	move $a0, $t2			# $a0 << $t2
	syscall				# Chama o sistema
	
	######################################################################
	
	# NOT
	
	li $v0, 4			# Intrução 4 (print_string)
	la $a0, opNOTX			# $a0 recebe o endereço de opNOTX
	syscall				# Chama o sistema
	
	not $t2, $t0			# $t2 = $t0 NOT $t1
	li $v0, 1			# $v0 = 1
	move $a0, $t2			# $a0 << $t2
	syscall				# Chama o sistema
	
	
	li $v0, 4			# Instrução 4 (print_string)
	la $a0, opNOTY			# $a0 recebe o endereço de opNOTY
	syscall				# Chama o sistema
	
	not $t2, $t1			# $t2 NOT $t1
	li $v0, 1			# $v0 = 1
	move $a0, $t2			# $a0 << $t2
	syscall				# Chama o sistema
	
	######################################################################
	
	# Finalizando o programa
	
	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema finalizando o programa
	
	######################################################################
