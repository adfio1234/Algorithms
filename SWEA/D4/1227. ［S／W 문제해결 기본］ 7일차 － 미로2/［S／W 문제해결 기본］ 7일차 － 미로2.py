from collections import deque
for _ in range(10):
    T=int(input())
    arr=[]
    start,end=(0,0),(0,0)
    for i in range(100):
        tmp=list(map(int,input()))
        if 2 in tmp:
            start=(tmp.index(2),i)
        if 3 in tmp:
            end=(tmp.index(3),i)
        arr.append(tmp)
    def bfs(start,end):
        visited=set([start])
        queue=deque([start])
        dx=[1,-1,0,0]
        dy=[0,0,1,-1]
        while queue:
            x,y=queue.popleft()
            if (x,y)==end:
                return 1
            for i in range(4):
                nx,ny=x+dx[i],y+dy[i]
                if 0<=nx<100 and 0<=ny<100:
                    if arr[ny][nx]!=1 and (nx,ny) not in visited:
                        queue.append((nx,ny))
                        visited.add((nx,ny))

        return 0
    print(f"#{T} {bfs(start,end)}")