for _ in range(10):
    T = int(input())
    sumArr=[]
    arr=[]
    total=0
    for i in range(100):
        tmp=list(map(int,input().split()))
        sumArr.append(sum(tmp))
        arr.append(tmp)
    for i in range(100):
        total+=arr[i][i]
    sumArr.append(total)
    total=0
    for i in range(100):
        total+=arr[99-i][i]
    sumArr.append(total)
    transpose=list(map(list,zip(*arr)))
    for i in transpose:
        sumArr.append(sum(i))
    print(f"#{T} {max(sumArr)}")