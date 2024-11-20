def solution(name, yearning, photos):
    answer = []
    dic_yearning = {}
    
    for i, n in enumerate(name):
        dic_yearning[n] = yearning[i]
    
    for photo in photos:
        sum = 0
        for p in photo:
            try:
                sum += dic_yearning[p]
            except:
                continue
        answer.append(sum)
    
    return answer