def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    start=h1*3600+m1*60+s1
    end=h2*3600+m2*60+s2
    if start==0 or start==(12*3600):
        answer+=1
    while start<end:
        curHour=(start/120)%360
        curMin=(start/10)%360
        curSec=(start*6)%360
        
        start+=1
        
        nextHour=(start/120)%360
        nextMin=(start/10)%360
        nextSec=(start*6)%360
        
        def diff(a,b):
            return(a-b+360)%360
        if diff(curSec,curHour)> diff(nextSec,nextHour):
            answer+=1
        if diff(curSec,curMin) > diff(nextSec,nextMin):
            answer+=1
        if diff(nextSec,nextHour)==0 and diff(nextSec,nextMin)==0:
            answer-=1

    return answer