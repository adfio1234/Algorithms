#bfs풀이
from collections import deque

def bfs(arr,start,end):
    visited=set()
    queue=deque([(start,0)])
    distance=0

    while queue:
        node,dist=queue.popleft()
        if node==end:
            return  dist
        for i in range(1,len(arr)):
            if i not in visited and arr[node][i]==1:
                visited.add(i)
                queue.append((i,dist+1))
    return 0

#dfs 풀이

# def leastDistance(arr,start,end):
#     visited=[False]*len(arr)
#     min=100
#
#     def dfs(arr,start,end,dist):
#         nonlocal min
#         if dist>min:
#             return
#         if start == end:
#             min= min if min<dist else dist
#
#         for i in range(1,len(arr)):
#             if not visited[i-1] and arr[start][i]==1:
#                 visited[i-1]=True
#                 dfs(arr,i,end,dist+1)
#                 visited[i-1]=False
#
#     dfs(arr,start,end,0)
#
#     if min==100:
#         return 0
#     else:
#         return min

T=int(input())

for t in range(T):

    V,E=map(int,input().split())
    arr=[[0]*(V+1) for _ in range(V+1)]

    for i in range(E):
        x,y=map(int,input().split())
        arr[x][y]=1
        arr[y][x]=1

    start,end=map(int,input().split())

    print(f"#{t+1} {bfs(arr,start,end)}")
    #print(f"#{t+1} {leastDistance(arr,start,end)}")