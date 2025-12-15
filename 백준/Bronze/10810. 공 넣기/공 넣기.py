N,M=map(int,input().split())
lst=[0]*N
for i in range(M):
    a,b,c=map(int,input().split())
    for j in range(a-1,b):
        lst[j]=c
for i in lst:
    print(i,end=" ")