T=int(input())
for t in range(T):
    maxPrize=[0]
    data=input().split()
    arr=list(data[0])
    change=int(data[1])
    visited=dict()
    def dfs(arr,change):

        key=(''.join(arr),change)
        if change==0:
            maxPrize[0]=max(maxPrize[0],int(''.join(arr)))
            return maxPrize[0]
        if key in visited:
            return
        visited[key]=True
        for i in range(len(arr)):
            for j in range(i+1,len(arr)):
                arr[i],arr[j]=arr[j],arr[i]
                dfs(arr,change-1)
                arr[i],arr[j]=arr[j],arr[i]
    dfs(arr,change)
    print(f"#{t+1} {maxPrize[0]}")