def solution(keymap, targets):
    answer = []
    
    dic = {}
    
    for key in keymap:
        for i, letter in enumerate(key):
            try:
                if dic[letter] > i + 1:
                    dic[letter] = i + 1
            except:
                dic[letter] = i + 1
                
    for target in targets:
        sum = 0
        for letter in target:
            try:
                sum += dic[letter]
            except:
                sum = -1
                break
        answer.append(sum)
    
    return answer