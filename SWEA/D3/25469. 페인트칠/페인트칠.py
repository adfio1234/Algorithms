def leastPaint(arr,row,col):
    
    paintedRow=0
    paintedCol=0
    
    for i in arr:
        paintedRow+=1
        for j in i:
            if j=='.':
                paintedRow-=1
                break

    for i in range(col):
        paintedCol+=1
        for j in range(row):
            if arr[j][i]=='.':
                paintedCol-=1
                break

    if paintedCol==col:
        return paintedRow if paintedRow<paintedCol else paintedCol
    else:
        return paintedCol+paintedRow
    
T=int(input())

for _ in range(T):
    row,col=map(int,input().split())
    arr=[]
    
    for _ in range(row):
        tmp=list(input())
        arr.append(tmp)

    print(f"{leastPaint(arr,row,col)}")
