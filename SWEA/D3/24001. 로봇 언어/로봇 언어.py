
def countParameter(str):
    L,R,Q=0,0,0
    for i in str:
        if i=='?':
            Q+=1
        elif i=='L':
            L+=1
        else:
            R+=1
    return L,R,Q

def findMaxPoint(str):
    point=[0]
    maxDistance=0

    for i in range(len(str)):
        if str[i]=='L' or str[i]=='?':
            point.append(point[i]-1)
        elif str[i]=='R':
            point.append(point[i]+1)
        maxDistance=max(maxDistance,abs(point[i+1]))
    point[0]=0
    for i in range(len(str)):
        if str[i]=='L':
            point[i+1]=point[i]-1
        elif str[i]=='R' or str[i]=='?':
            point[i+1]=point[i]+1
        maxDistance = max(maxDistance, abs(point[i+1]))
    return maxDistance

T=int(input())
for _ in range(T):
    str=list(input())
    countL,countR,countQ=countParameter(str)
    if countQ==len(str):
        print(f"{countQ}")
    else:
        print(f"{findMaxPoint(str)}")