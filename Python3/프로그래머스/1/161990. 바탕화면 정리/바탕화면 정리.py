def solution(wallpaper):
    answer = []
    minx,maxx,miny,maxy = len(wallpaper), 0, len(wallpaper[0]), 0
    
    for i, row in enumerate(wallpaper):
        if row.find('#') != -1:
            if minx > i:
                minx = i
            if maxx < i:
                maxx = i
            if miny > row.find('#'):
                miny = row.find('#')
            if maxy < row.rfind('#'):
                maxy = row.rfind('#')
    
    answer = [minx,miny,maxx+1,maxy+1]
    
    return answer