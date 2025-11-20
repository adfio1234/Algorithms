N=int(input())
arr=[[0]*101 for _ in range(101)]
ans=[0]*(N+1)
for i in range(1,N+1):
    x1,y1,x2,y2=map(int,input().split())
    x2+=x1
    y2+=y1
    for j in range(x1,x2):
        for k in range(y1,y2):
            arr[j][k]=i
for i in range(len(arr)):
    for j in range(len(arr[i])):
        ans[arr[i][j]]+=1

for i in range(1,len(ans)):
    print(ans[i])