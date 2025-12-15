from collections import deque
def solution(maps):
    answer = []
    visited=set()
    def bfs(x,y):
        total=int(maps[y][x])
        dx=[1,-1,0,0]
        dy=[0,0,1,-1]
        queue=deque([(x,y)])
        visited.add((x,y))
        while queue:
            nx,ny=queue.popleft()
            for i in range(4):
                nnx,nny=nx+dx[i],ny+dy[i]
                if 0<=nnx<len(maps[0]) and 0<=nny<len(maps):
                    if maps[nny][nnx]!='X' and (nnx,nny) not in visited:
                        visited.add((nnx,nny))
                        queue.append((nnx,nny))
                        total+=int(maps[nny][nnx])
        return total
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j]!='X' and (j,i) not in visited:
                answer.append(bfs(j,i))
    if len(answer)==0:
        return [-1]
    else:
        answer.sort()
    return answer