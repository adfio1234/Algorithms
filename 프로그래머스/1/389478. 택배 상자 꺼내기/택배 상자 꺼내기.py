import math
def solution(n, w, num):
    answer = 0
    box=[]
    count=1
    height=math.ceil(n/w)
    targetLocation=(0,0)
    for i in range(height):
        tmp=[]
        for j in range(w):
            if count>n:
                tmp.append(0)
                continue
            tmp.append(count)
            count+=1
        if i%2==1:
            tmp=tmp[:][::-1]
        if num in tmp:
            targetLocation=(i,tmp.index(num))
        box.append(tmp)
        
    for i in range(targetLocation[0],height):
        if box[i][targetLocation[1]]!=0:
            answer+=1
    #print(targetLocation,height)
    return answer