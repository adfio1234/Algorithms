from collections import deque
for _ in range(10):
    T=int(input())
    arr=[]
    tmp=[]
    for i in range(100):
        tmp=list(map(int,input().split()))
        arr.append(tmp)
    start=(tmp.index(2),99)
    def ladder(start):
        queue=deque([start])
        visited=set([start])

        while queue:
            x,y=queue.popleft()
            if y==0:
                return x
            if 0<=(x-1)<100 and 0<=y<100 and arr[y][x-1]==1 and (x-1,y) not in visited:
                queue.append((x-1,y))
                visited.add((x-1,y))
            elif 0<=(x+1)<100 and 0<=y<100 and arr[y][x+1]==1 and (x+1,y) not in visited:
                queue.append((x+1,y))
                visited.add((x+1,y))
            elif 0<=x<100 and 0<=y-1<100 and arr[y-1][x]==1 and (x,y-1) not in visited:
                queue.append((x,y-1))
                visited.add((x,y-1))

        return 0


    print(f"#{T} {ladder(start)}")