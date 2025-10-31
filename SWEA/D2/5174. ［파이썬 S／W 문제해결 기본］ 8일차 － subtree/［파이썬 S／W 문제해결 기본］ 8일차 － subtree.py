from collections import deque

def subTree(tree,N):
    queue=deque([N])
    sum=1
    
    while queue:
        node=queue.popleft()
        for i in range(len(tree)):
            if tree[node][i]==1:
                queue.append(i)
                sum+=1
    return sum

T=int(input())
for t in range(T):

    E,N=map(int,input().split())
    arr=list(map(int,input().split()))
    tree=[[0]*(E+2) for _ in range(E+2)]

    for i in range(0,E*2-1,2):

        tree[arr[i]][arr[i+1]]=1

    print(f"#{t+1} {subTree(tree,N)}")