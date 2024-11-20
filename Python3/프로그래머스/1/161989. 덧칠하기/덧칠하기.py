def solution(n, m, section):
    answer = 0
    right = 0
    
    for s in section:
        if s > right:
            right = s + m - 1
            answer += 1
    
    return answer