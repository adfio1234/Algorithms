def printMap(mapArr):
    for i in mapArr:
        for j in i:
            print(j,end="")
        print()

def tankOperation(command,mapArr,tankDirection,tankPointX,tankPointY):
    tankDirection=tankDirection
    tankPointX=tankPointX
    tankPointY=tankPointY
    for i in command:
        if i=='S':
            mapArr=tankShoot(tankDirection,mapArr,tankPointX,tankPointY)
        else:
            mapArr,tankDirection,tankPointX,tankPointY=tankMove(mapArr,tankPointX,tankPointY,i)

    return mapArr

def tankMove(mapArr,tankPointX,tankPointY,moveDirection):
    commandDirection={'L':1,'R':2,'U':3,'D':4}
    moveDirection=commandDirection[moveDirection]

    if moveDirection==1:
        if tankPointX-1<0:
            mapArr[tankPointY][tankPointX] = '<'
            return mapArr, moveDirection, tankPointX, tankPointY
        elif mapArr[tankPointY][tankPointX-1]=='.':
            mapArr[tankPointY][tankPointX-1]='<'
            mapArr[tankPointY][tankPointX]='.'
            return mapArr, moveDirection, tankPointX-1, tankPointY
        else:
            mapArr[tankPointY][tankPointX] = '<'
            return mapArr, moveDirection, tankPointX, tankPointY
    elif moveDirection==2:
        if tankPointX+1>=len(mapArr[0]):
            mapArr[tankPointY][tankPointX] = '>'
            return mapArr, moveDirection, tankPointX, tankPointY
        elif mapArr[tankPointY][tankPointX+1]=='.':
            mapArr[tankPointY][tankPointX+1]='>'
            mapArr[tankPointY][tankPointX]='.'
            return mapArr, moveDirection, tankPointX+1, tankPointY
        else:
            mapArr[tankPointY][tankPointX] = '>'
            return mapArr, moveDirection, tankPointX, tankPointY

    elif moveDirection==3:
        if tankPointY-1<0:
            mapArr[tankPointY][tankPointX] = '^'
            return mapArr, moveDirection, tankPointX, tankPointY
        elif mapArr[tankPointY-1][tankPointX]=='.':
            mapArr[tankPointY-1][tankPointX]='^'
            mapArr[tankPointY][tankPointX]='.'
            return mapArr, moveDirection, tankPointX, tankPointY-1
        else:
            mapArr[tankPointY][tankPointX] = '^'
            return mapArr, moveDirection, tankPointX, tankPointY
    elif moveDirection==4:
        if tankPointY+1>=len(mapArr):
            mapArr[tankPointY][tankPointX] = 'v'
            return mapArr, moveDirection, tankPointX, tankPointY
        elif mapArr[tankPointY+1][tankPointX]=='.':
            mapArr[tankPointY+1][tankPointX]='v'
            mapArr[tankPointY][tankPointX]='.'
            return mapArr, moveDirection, tankPointX, tankPointY+1
        else:
            mapArr[tankPointY][tankPointX] = 'v'
            return mapArr, moveDirection, tankPointX, tankPointY

def tankShoot(tankDirection,mapArr,tankPointX,tankPointY):
    if tankDirection==1:
        for i in range(tankPointX,-1,-1):
            if mapArr[tankPointY][i]=='*':
                mapArr[tankPointY][i]='.'
                break
            elif mapArr[tankPointY][i]=='#':
                break
    elif tankDirection==2:
        for i in range(tankPointX,len(mapArr[0])):
            if mapArr[tankPointY][i]=='*':
                mapArr[tankPointY][i]='.'
                break
            elif mapArr[tankPointY][i]=='#':
                break
    elif tankDirection==3:
        for i in range(tankPointY,-1,-1):
            if mapArr[i][tankPointX]=='*':
                mapArr[i][tankPointX]='.'
                break
            elif mapArr[i][tankPointX]=='#':
                break
    elif tankDirection==4:
        for i in range(tankPointY,len(mapArr)):
            if mapArr[i][tankPointX]=='*':
                mapArr[i][tankPointX]='.'
                break
            elif mapArr[i][tankPointX]=='#':
                break
    return mapArr
T=int(input())
for t in range(T):
    H,W=map(int,input().split())
    mapArr=[]
    direction={'<':1,'>':2,'^':3,'v':4}
    tankDirection=0
    tankPointX,tankPointY=0,0

    for i in range(H):
        str=list(input())
        mapArr.append(str)

        if tankDirection==0:
            for j in range(len(str)):
                if str[j] in direction:
                    tankDirection=direction[str[j]]
                    tankPointX,tankPointY=j,i

    N=int(input())
    command=input()
    print(f"#{t+1 } ",end="")
    printMap(tankOperation(command,mapArr,tankDirection,tankPointX,tankPointY))
