def is_available(mat, r, c, park):
    rows_park = len(park)
    columns_park = len(park[0])
    
    if mat + r > rows_park or mat + c > columns_park:
        return False
    
    for i in range(mat):
        for j in range(mat):
            if park[r+i][c+j] != "-1":
                return False
            
    return True


def solution(mats, park):
    answer = -1
    
    for mat in mats:
        for r, row in enumerate(park):
            for c, value in enumerate(row):          
                if is_available(mat, r, c, park) and mat > answer:
                    answer = mat
    
    return answer