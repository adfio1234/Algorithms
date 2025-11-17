from collections import deque
def bfs(maps,end):
    visited=set((0,0))
    queue=deque([(0,0,1)])
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    while queue:
        x,y,distance=queue.popleft()
        if (x,y)==end:
            return distance
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<len(maps[0]) and 0<=ny<len(maps):
                if (nx,ny) not in visited and maps[ny][nx]==1:
                    queue.append((nx,ny,distance+1))
                    visited.add((nx,ny))
    return -1
        
def solution(maps):
    end=((len(maps[0])-1,len(maps)-1))
    return bfs(maps,end)
#0 벽있음