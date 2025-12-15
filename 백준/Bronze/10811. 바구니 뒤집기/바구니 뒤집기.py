N,M=map(int,input().split())
lst=[i for i in range(1,N+1)]
for i in range(M):
    a,b=map(int,input().split())
    left=lst[:a-1]
    mid=lst[a-1:b][::-1]
    right=lst[b:]
    lst=left+mid+right
for i in lst:
    print(i,end=" ")