def sine(x):
    result = 0
    for i in range(50):
        factorial = 1
        for f in range(1, 2 * i + 2):
            factorial *= f
        compute = (-1)**i * x**(2*i+1)/factorial
        result += compute
    return result
def collatz( ):
    run = 1
    while run:
        inp = (input("Please type a number greater than one or 'quit' to quit\n"))
        try:
            if inp == 'q' or inp == 'Q' or inp == 'quit':
                print("Goodbye\n")
                run = 0
            if run:
                x = int(inp)
                if x <= 1:
                    print(f"You typed {x}, which is not greater than one Please type a number greater than one or 'quit' to quit\n")
                else:
                    print(f"Giving Collatz sequence for {x}")
                    iter = 0
                    while x!=1:
                        if x%2==0:
                            x = x//2
                        else:
                            x = 3*x+1
                        iter +=1
                        print(f"iteration {iter} results in {x}")
        except ValueError:
                inp = input("Please type a valid number or 'quit' to quit\n")
                if inp == 'q' or inp == 'Q' or inp == 'quit':
                    print("Goodbye\n")
                    run = 0