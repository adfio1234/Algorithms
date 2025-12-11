def solution(schedules, timelogs, startday):
    answer = 0
    remain=7-startday
    remain2=6-startday
    for i in range(len(schedules)):
        limit=schedules[i]+10
        if limit%100>=60:
            limit+=40
        answer+=1
        timelogs[i][remain],timelogs[i][remain2]=0,0
        for j in range(len(timelogs[i])):
            if timelogs[i][j]>limit:
                answer-=1
                break

    return answer