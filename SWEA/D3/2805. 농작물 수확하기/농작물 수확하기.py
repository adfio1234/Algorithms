def harvest(arr,N):
    total=0
    mid=N//2
    for i in range(mid+1):
        total+=sum(arr[i][mid-i:mid+1+i])
    for i in range(mid):
        total+=sum(arr[i+mid+1][i+1:-(i+1)])
    return total

T=int(input())
for t in range(T):
    N=int(input())
    arr=[]
    for i in range(N):
        str=input()
        lst=[int(j) for j in str]
        arr.append(lst)
    print(f"#{t+1} {harvest(arr,N)}")