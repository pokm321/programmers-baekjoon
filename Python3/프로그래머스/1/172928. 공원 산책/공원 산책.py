def solution(park, routes):
    answer = []
    
    park2_row = []
    park2 = []
    
    for i_r, row in enumerate(park):
        for i_c, letter in enumerate(row):
            park2_row.append(letter)
            if letter == "S":
                r = i_r
                c = i_c
        park2.append(park2_row)
        park2_row = []
    
    for route in routes:
        direction = route.split(" ")[0]
        length = int(route.split(" ")[1])
        doit = True
        
        if direction == "E":
            for l in range(1, length+1):
                try:
                    if park2[r][c+l] == "X":
                        doit = False
                        break
                except:
                    doit = False
                    break
                    
            if doit:
                c += length
        elif direction == "W":
            for l in range(1, length+1):
                try:
                    if park2[r][c-l] == "X":
                        doit = False
                        break
                    elif c-l < 0:
                        doit = False
                        break
                except:
                    doit = False
                    break
                    
            if doit:
                c -= length
        elif direction == "S":
            for l in range(1, length+1):
                try:
                    if park2[r+l][c] == "X":
                        doit = False
                        break
                except:
                    doit = False
                    break
                    
            if doit:
                r += length
        elif direction == "N":
            for l in range(1, length+1):
                try:
                    if park2[r-l][c] == "X":
                        doit = False
                        break
                    elif r-l < 0:
                        doit = False
                        break
                except:
                    doit = False
                    break
                    
            if doit:
                r -= length
    
    return [r, c]