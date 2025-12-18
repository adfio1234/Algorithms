from collections import deque
def solution(n, edge):
    answer = 0
    distance=[0]*(n+1)
    graph=[[] for i in range(n+1)]
    visited=[False]*(n+1)
    visited[1]=True
    def bfs():
        queue=deque([(1,0)])

        while queue:
            currentNode,moveDistance=queue.popleft()

            for i in graph[currentNode]:
                #print(moveNode)
                if not visited[i]:
                    #print(i)
                    distance[i]=moveDistance+1
                    queue.append((i,moveDistance+1))
                    visited[i]=True
        
    for i,j in edge:
        graph[i].append(j)
        graph[j].append(i)
    bfs()
    for i in distance:
        if max(distance)==i:
            answer+=1
    return answer