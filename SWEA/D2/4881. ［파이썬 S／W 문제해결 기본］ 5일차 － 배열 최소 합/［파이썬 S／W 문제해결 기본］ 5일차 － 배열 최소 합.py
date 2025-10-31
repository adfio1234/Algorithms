def leastSum(arr):
    visited=[False]*len(arr)
    min=100

    def dfs(row,sum):
        nonlocal min
        
        if sum>min:
            return
        
        if row == len(arr):
            min = min if min < sum else sum
            
        for i in range(len(arr)):
            
            if not visited[i]:
                visited[i]=True
                dfs(row+1,sum+arr[row][i])
                visited[i]=False
    dfs(0,0)
    return min
T=int(input())
for t in range(T):

    N=int(input())
    arr=[]

    for i in range(N):
        tmp=list(map(int,input().split()))
        arr.append(tmp)

    
    print(f"#{t+1} {leastSum(arr)}")