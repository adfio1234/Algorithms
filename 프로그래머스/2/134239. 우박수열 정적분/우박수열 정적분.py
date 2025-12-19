def solution(k, ranges):
    answer = []
    point=[(0,k)]
    count=1
    size=[]
    while k!=1:
        if k%2==0:
            k//=2
        else:
            k=k*3+1
        point.append((count,k))
        count+=1
    for i in range(len(point)-1):
        y1,y2=point[i][1],point[i+1][1]
        minimal=min(y1,y2)
        maximal=max(y1,y2)
        tmp=minimal+(maximal-minimal)/2
        size.append(tmp)
    count-=1
    for i in ranges:
        tmp=0
        start,end=i[0],count+i[1]
        if start>end:
            answer.append(-1)
        elif start==end:
            answer.append(0)
        else:
            for j in range(start,end):
                tmp+=size[j]
            answer.append(tmp)

    return answer