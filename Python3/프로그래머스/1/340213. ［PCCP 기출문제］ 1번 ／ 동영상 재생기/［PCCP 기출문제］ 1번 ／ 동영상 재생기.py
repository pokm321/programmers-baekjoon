def str_to_sec(text):
    return int(text.split(":")[0]) * 60 + int(text.split(":")[1])

def sec_to_str(sec):
    str1 = ( "0" + str(int(sec/60)) )[-2:]
    str2 = ( "0" + str(sec % 60) )[-2:]
    
    return str1 + ":" + str2

def solution(video_len, pos, op_start, op_end, commands):

    video_len = str_to_sec(video_len)
    pos = str_to_sec(pos)
    op_start = str_to_sec(op_start)
    op_end = str_to_sec(op_end)
    
    if op_start <= pos and pos <= op_end:
        pos = op_end
    
    for command in commands:
        if command == "next":
            pos += 10
            if pos > video_len:
                pos = video_len
        elif command == "prev":
            pos -= 10
            if pos < 0:
                pos = 0
        else:
            return -1
    
        if op_start <= pos and pos <= op_end:
            pos = op_end
    
    return sec_to_str(pos)