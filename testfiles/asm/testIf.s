.global _start
.data
buf: .skip 1024
.text
_start:

main:
	pushq %rbp
	movq %rsp, %rbp
	subq $0, %rsp
	movq $2, %rax
	pushq %rax
	movq $1, %rax
	movq %rax, %rbx
	popq %rax
	cmpq %rbx, %rax
	jle main0_else
	movq $1, %rax
	pushq %rax
	call print
	jmp main0_done
main0_else:
main0_done:
	movq $2, %rax
	pushq %rax
	movq $1, %rax
	movq %rax, %rbx
	popq %rax
	cmpq %rbx, %rax
	jl main1_else
	movq $2, %rax
	pushq %rax
	call print
	jmp main1_done
main1_else:
main1_done:
	movq $1, %rax
	pushq %rax
	movq $2, %rax
	movq %rax, %rbx
	popq %rax
	cmpq %rbx, %rax
	jg main2_else
	movq $3, %rax
	pushq %rax
	call print
	jmp main2_done
main2_else:
main2_done:
	movq $1, %rax
	pushq %rax
	movq $2, %rax
	movq %rax, %rbx
	popq %rax
	cmpq %rbx, %rax
	je main3_else
	movq $4, %rax
	pushq %rax
	call print
	jmp main3_done
main3_else:
main3_done:
	movq $1, %rax
	pushq %rax
	movq $2, %rax
	movq %rax, %rbx
	popq %rax
	cmpq %rbx, %rax
	jge main4_else
	movq $5, %rax
	pushq %rax
	call print
	jmp main4_done
main4_else:
main4_done:
sys_exit:
	movq %rbp, %rsp
	popq %rbp
	movq $0, %rdi
	movq $60, %rax
	syscall
# Procedure to read number from stdin
# C signature: long int read(void)
read:
        pushq %rbp
        movq %rsp, %rbp
        movq $0, %rdi
        movq $buf, %rsi
        movq $1024, %rdx
        movq $0, %rax
        syscall                 # %rax = sys_read(0, buf, 1024)
        ### convert string to integer:
        ### %rax contains nchar
        ### %rsi contains ptr
        movq $0, %rdx           # sum = 0
atoi_loop:
        cmpq $0, %rax           # while (nchar > 0)
        jle atoi_done           # leave loop if nchar <= 0
        movzbq (%rsi), %rbx     # move byte, and sign extend to qword
        cmpq $0x30, %rbx        # test if < '0'
        jl atoi_done            # character is not numeric
        cmpq $0x39, %rbx        # test if > '9'
        jg atoi_done            # character is not numeric
        imulq $10, %rdx         # multiply sum by 10
        subq $0x30, %rbx        # value of character
        addq %rbx, %rdx         # add to sum
        incq %rsi               # step to next char
        decq %rax               # nchar--
        jmp atoi_loop           # loop back
atoi_done:
        movq %rdx, %rax         # return value in RAX
        popq %rbp
        ret

# Procedure to print number to stdout
# C signature: void print(long int)
print:
        pushq %rbp
        movq %rsp, %rbp
        ### convert integer to string
        movq 16(%rbp), %rax     # parameter
        movq $(buf+1023), %rsi  # write ptr (start from end of buf)
        movb $0x0a, (%rsi)      # insert newline
        movq $1, %rcx           # string length
itoa_loop:                      # do.. while (at least one iteration)
        movq $10, %rbx
        movq $0, %rdx
        idivq %rbx              # divide rdx:rax by 10
        addb $0x30, %dl         # remainder + '0'
        decq %rsi               # move string pointer
        movb %dl, (%rsi)
        incq %rcx               # increment string length
        cmpq $0, %rax
        jg itoa_loop            # produce more digits
itoa_done:
        movq $1, %rdi
        movq %rcx, %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret

print_string:
        pushq %rbp
        movq %rsp, %rbp
        movq $1, %rdi
        movq 16(%rbp), %rsi
        movq 24(%rbp), %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret

funky_done:
	movq %rbp, %rsp
	popq %rbp
	ret
