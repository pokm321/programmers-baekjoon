def get_history(points, route):
    history = []

    for i, r in enumerate(route):
        route[i] = points[r-1].copy()
    
    for i, r in enumerate(route):
        if i:
            dest = route[i]
            now = route[i-1]
            
            while dest[0] != now[0]:
                history.append(tuple(now))
                if dest[0] > now[0]:
                    now[0] += 1
                else:
                    now[0] -= 1
            
            while dest[1] != now[1]:
                history.append(tuple(now))
                if dest[1] > now[1]:
                    now[1] += 1
                else:
                    now[1] -= 1
                    
    history.append(tuple(now))

    return history

from collections import Counter

def solution(points, routes):
    answer = 0
    histories = []
    
    for route in routes:
        histories.append(get_history(points, route))
    
    time = 0
    
    while True:
        positions = []
        for i in range(len(routes)):
            try:
                positions.append(histories[i][time])
            except:
                pass

        if len(positions):
            for position, num in Counter(positions).items():
                if num > 1:
                    answer += 1
        else:
            break
        
        time += 1
    
    return answer