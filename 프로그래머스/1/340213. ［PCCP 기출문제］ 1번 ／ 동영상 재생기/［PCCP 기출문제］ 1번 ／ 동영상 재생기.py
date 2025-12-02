def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    startSec=int(pos[:2])*60+int(pos[3:])
    endSec=int(video_len[:2])*60+int(video_len[3:])
    opStartSec=int(op_start[:2])*60+int(op_start[3:])
    opEndSec=int(op_end[:2])*60+int(op_end[3:])
    for i in commands:
        if opStartSec<=startSec<opEndSec:
            startSec=opEndSec
        if i=="prev":
            startSec-=10
        elif i=="next":
            startSec+=10
        if startSec<=0:
            startSec=0
        elif startSec>endSec:
            startSec=endSec
    if opStartSec<=startSec<opEndSec:
            startSec=opEndSec
            
    resultMin=str(startSec//60)
    resultSec=str(startSec%60)
    if len(resultMin)==1:
        answer+='0'
    answer+=resultMin
    answer+=':'
    if len(resultSec)==1:
        answer+='0'
    answer+=resultSec

    
    return answer