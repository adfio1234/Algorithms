from collections import deque

def bfs(map,start,end):

    queue=deque([start])
    visited=set([start])

    while queue:
        x,y=queue.popleft()
        if (x,y)==end:
            return 1
        for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
            nx,ny=x+dx,y+dy
            if 0<=nx<len(map) and 0<=ny<len(map) and (map[ny][nx]=="0" or map[ny][nx]=="3") and (nx,ny) not in visited:
                queue.append((nx,ny))
                visited.add((nx,ny))

    return 0

T=int(input())
for t in range(T):
    map=[]
    N=int(input())

    for i in range(N):
        row=list(input())
        if "2" in row:
            start=(row.index("2"),i)
        elif "3" in row:
            end=(row.index("3"),i)
        map.append(row)

    print("#{} {}".format(t+1,bfs(map,start,end)))