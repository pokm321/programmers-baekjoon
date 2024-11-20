def get_time_taken(level, diffs, times):
    time_taken = 0

    for i, (diff, time) in enumerate(zip(diffs, times)):
        if i == 0 or diff < level:
            time_taken += time
        else:
            time_taken += time + (diff - level) * (time + times[i-1])
            
    return time_taken


def solution(diffs, times, limit):
    level_min = 1
    level_max = max(diffs)
    
    while level_min != level_max:
        level = int((level_min + level_max)/2)
        
        time_taken = get_time_taken(level, diffs, times)
        
        if time_taken > limit: # 숙련도가 부족
            level_min = level + 1
        else:                   # 숙련도가 충분
            level_max = level 
    
    return level_min