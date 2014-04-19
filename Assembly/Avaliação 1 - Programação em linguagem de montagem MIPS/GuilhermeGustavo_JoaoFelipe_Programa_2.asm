# Disciplina: 4189 – Arquitetura e Organização de Computadores
# Atividade: Avaliação 01 – Programação em Linguagem de Montagem
# Programa 02
# Grupo: - Guilherme Gustavo Gohr Darosci
# 	 - João Felipe Gonçalves

# ENUNCIADO
# Implemente um programa que leia dois vetores via console e, após a leitura dos vetores, produza um
# terceiro vetor em que cada elemento seja a média aritmética dos elementos de mesmo índice dos
# outros dois vetores. Por fim, o programa deve imprimir esse novo vetor na tela.

# $s0		Vetor_A
# $s1		Vetor_B
# $s2		Vetor_C
# $k0		Tamanho dos vetores
# $t0		Indice usado nos lacos
# $t1		Recebe a multiplicação do indice * 4. Sendo utilizado para acessar a posição do Vetor_A
# $t2		Recebe a multiplicação do indice * 4. Sendo utilizado para acessar a posição do Vetor_B
# $t3		Recebe a multiplicação do indice * 4. Sendo utilizado para acessar a posição do Vetor_C
# $v0		Utilizado principalmente para receber a soma dos valores de Vetor_A com Vetor_B sendo divididos por 2 com shift_right_logical


	.data
	
msgTamanho:.asciiz	"\nEntre com o tamanho dos vetores (máx.= 8): "
msgInvalido:.asciiz	"\nValor inválido!\n"

msgLeiA:.asciiz		"LEITURA DOS ELEMENTOS DO VETOR_A:\n"
msgLeiB:.asciiz		"\nLEITURA DOS ELEMENTOS DO VETOR_B:\n"
msgMediaC:.asciiz	"\nELEMENTOS DO VETOR_C:\n"

msgA:.asciiz	"\nVetor_A["
msgB:.asciiz	"\nVetor_B["
msgC:.asciiz	"\nVetor_C["

msgClose:.asciiz	"]: "


Vetor_A:.word 0, 0, 0, 0, 0, 0, 0, 0
Vetor_B:.word 0, 0, 0, 0, 0, 0, 0, 0
Vetor_C:.word 0, 0, 0, 0, 0, 0, 0, 0

	.text
main:
	la $s0, Vetor_A			# Atribui Vetor_A para $a0
	la $s1, Vetor_B			# Atribui Vetor_B para $a1
	la $s2, Vetor_C			# Atribui Vetor_C para $a2
	
	###########################################################################################
	# Tamanho do vetor
	###########################################################################################
	
tamanho:

	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgTamanho		# atribui o endereço de msgTamanho a $a0	("Entre com o tamanho dos vetores (máx.= 8): ")
	syscall				# Chama o sistema				(Imprimindo a mensagem)
	
	li $v0, 5			# Instrucao 5		(read_int)
	syscall				# Chama o sistema
	ble $v0, 1, invalido		# Se $v0 <= 1 entao chama a label invalido
	bgt $v0, 8, invalido		# Se $v0 > 8  entao chama a label invalido
	
	j continua			# Se passar pelos testes, pula para label continua
	
invalido:
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgInvalido		# Atribui o endereço de msgInvalido a $a0
	syscall				# Chama o sistema
	
	j tamanho			# Pula para label tamanho		(solicitando um numero valido)
	
	###########################################################################################
	
	# Continuando o programa
	
continua:
	
	move $k0, $v0			# $k0 recebe $v0			(valor digitado para tamanho do vetor)
	
	###########################################################################################
	# Leitura dos vetores
	###########################################################################################
	
	# Vetor_A
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgLeiA			# $a0 recebe o endereco de msgLeiA
	syscall				# Chama o sistema
	
leituraA:
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgA			# $a0 recebe o endereco de msgA
	syscall				# Chama o sistema
	
	li $v0, 1			# Instrucao 1		(print_int)
	move $a0, $t0			# $a0 << $t0		indice
	syscall				# Chama o sistema
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgClose		# $a0 recebe o endereco de msgB
	syscall				# Chama o sistema
	
	
	li $v0, 5			# Instrucao 5		(read_int)
	syscall
	
	mul $t1, $t0, 4			# $t1 = i*4		indice = $t0
	add $t1, $t1, $s0		# $t1 = $t1 + $s0
	sw $v0, 0($t1)			# Memoria[$t1+0] = $v0		(valor digitado pelo usuario)
	
	addi $t0, $t0, 1		# $t0 = $t0 + 1			($t0++)
	bne $t0, $k0, leituraA		# Enquanto $t0 for diferente de $k0, leituraA e chamada novamente
	
	
	# Vetor_B
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgLeiB			# $a0 recebe o endereco de msgLeiB
	syscall				# Chama o sistema
	
	move $t0, $zero			# Zerando o contador indice para reuso
	
leituraB:

	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgB			# $a0 recebe o endereco de msgB
	syscall				# Chama o sistema
	
	li $v0, 1			# Instrucao 1		(print_int)
	move $a0, $t0			# $a0 << $t0		indice
	syscall				# Chama o sistema
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgClose		# $a0 recebe o endereco de msgB
	syscall				# Chama o sistema
	
	
	li $v0, 5			# Instrucao 5		(read_int)
	syscall				# Chama o sistema
	
	mul $t1, $t0, 4			# $t1 = i*4		indice = $t0
	add $t1, $t1, $s1		# $t1 = $t1 + $s0
	sw $v0, 0($t1)			# Memoria[$t1+0] = $v0		(valor digitado pelo usuario)
	
	addi $t0, $t0, 1		# $t0 = $t0 + 1			($t0++)
	bne $t0, $k0, leituraB		# Enquanto $t0 for diferente de $k0, leituraA e chamada novamente
	
	###########################################################################################
	# Media entra Vetor_A e Vetor_B
	###########################################################################################
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgMediaC		# $a0 recebe o endereco de msgA
	syscall				# Chama o sistema
	
	move $t0, $zero			# Zerando o contador indice para reuso
	
media:
	
	mul $t1, $t0, 4			# $t1 = indice * 4		$t1 contribui com Vetor_A
	mul $t2, $t0, 4			# $t2 = indice * 4		$t2 contribui com Vetor_B
	mul $t3, $t0, 4			# $t3 = indice * 4		$t3 contribui com Vetor_C
	
	add $t1, $t1, $s0		# $t1 = $t1 + $s0
	add $t2, $t2, $s1		# $t2 = $t2 + $s1
	add $t3, $t3, $s2		# $t3 = $t3 + $s2
	
	lw $t1, 0($t1)			# $t1 = Memoria[$t1+0]
	lw $t2, 0($t2)			# $t2 = Memoria[$t2+0]
	add $v0, $t1, $t2		# $v0 = $t1 + $t2		Soma os elementos do indice $t0 de Vetor_A e Vetor
	
	sra $v0, $v0, 1			# $v0 recebe $v0 deslocado para direita. 2 no expoente 1 é 2	(shift_right_logical)
	sw $v0, 0($t3)			# Memoria[$t3+0] = $v0
	
	# Imprimindo
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgC			# $a0 recebe o endereco de msgC
	syscall				# Chama o sistema
	
	li $v0, 1			# Instrucao 1		(print_int)
	move $a0, $t0			# $a0 << $t0		indice
	syscall				# Chama o sistema
	
	li $v0, 4			# Instrucao 4		(print_string)
	la $a0, msgClose		# $a0 recebe o endereco de msgClose
	syscall				# Chama o sistema
	
	li $v0, 1			# Intrução 1 		(print_int)
	lw $t1, 0($t3)			# $t1 = Memoria[$t3+0]	(reuso de registradores)
	move $a0, $t1			# $a0 recebe $t1
	syscall  			# Chama o sistema
	
	addi $t0, $t0, 1		# $t0 ++
	bne $t0, $k0, media		# Enquanto $t0 for diferente de $k0 entao chama label media
	
	
	######################################################################
	
	# Finalizando o programa
	
	li $v0, 10			# Intrução 10 (exit)
	syscall				# Chama o sistema	(finalizando o programa)
	
	######################################################################
	
