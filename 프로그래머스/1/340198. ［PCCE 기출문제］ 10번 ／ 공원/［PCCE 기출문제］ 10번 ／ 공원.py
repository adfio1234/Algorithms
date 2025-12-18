def solution(mats, park):
    answer = 0
    mats.sort(reverse=True)
    
    def findMats(x,y):
        for i in mats:
            check=True
            if 0<=(x+i-1)<len(park[0]) and 0<=(y+i-1)<len(park):
                for j in range(y,y+i):
                    for k in range(x,x+i):
                        if park[j][k]!="-1":
                            check=False
                            break
                    if not check:
                        break
                if check:
                    return i
        return 0
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j]=="-1":
                answer=max(findMats(j,i),answer)
                
    if answer==0:
        return -1
    return answer