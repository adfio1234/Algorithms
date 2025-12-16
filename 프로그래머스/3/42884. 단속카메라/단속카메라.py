def solution(routes):
    answer = 1
    routes.sort(key=lambda x:x[1])
    last=routes[0][1]
    for i in range(1,len(routes)):
        left,right=routes[i]
        if left<=last<=right:
            continue
        answer+=1
        last=right
    return answer