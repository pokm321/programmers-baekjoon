def get_x(bases, expression):
    num1, operator, num2, _ = expression.split(" ", 3)

    x_bases = []
    x = 0
    
    for base in bases:
        num_bases = []
        for num in [num1, num2]:
            num_base = 0
            for i, n in enumerate(reversed(num)):
                num_base += int(n) * (int(base)**i)
            num_bases.append(num_base)
        
        if operator == "+":
            x = num_bases[0] + num_bases[1]
        elif operator == "-":
            x = num_bases[0] - num_bases[1]
        
        x_base = ""
        while x != 0:
            x_base = str(x % base) + x_base
            x = x // base
        
        if not x_base:
            x_base = "0"
        x_bases.append(x_base)
    
    return list(set(x_bases))
        

def is_working(base, expressions):
    for expression in expressions:
        if not "X" in expression:
            num1, operator, num2, equal, num3 = expression.split(" ")
            
            num_bases = []
            for num in [num1, num2, num3]:
                num_base = 0
                for i, n in enumerate(reversed(num)):
                    num_base += int(n) * (int(base)**i)
                num_bases.append(num_base)
            
            if operator == "+" and num_bases[0] + num_bases[1] != num_bases[2]:
                return False
            elif operator == "-" and num_bases[0] - num_bases[1] != num_bases[2]:
                return False
    
    return True
            
            
def get_bases(expressions):
    min_base = 0
    for expression in expressions:
        expression = expression.replace(" + ","",1).replace(" - ","",1).replace(" = ","",1).replace("X","")
        for e in expression:
            if int(e) > min_base:
                min_base = int(e)
    
    return list(range(min_base + 1, 10))
    
def solution(expressions):
    answer = []
    
    bases = get_bases(expressions)
    working_bases = []
    for base in bases:
        if is_working(base, expressions):
            working_bases.append(base)
    
    
    for expression in expressions:
        if "X" in expression:
            x = get_x(working_bases, expression)
            
            if len(x) > 1:
                answer.append(expression.replace("X", "?"))
            elif len(x) == 1:
                answer.append(expression.replace("X", str(x[0])))
    
    return answer