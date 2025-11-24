def solution(n, computers):
    answer = 0
    visited=[False]*(n)
    graph=[[0]*(n) for _ in range(n)]
    
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if computers[i][j]==1:
                graph[i][j]=1
        

    def search(start):
        nonlocal answer
        for i in range(n):
            if graph[start][i]==1 and not visited[i]:
                visited[i]=True
                search(i)
                
    for i in range(n):
        if not visited[i]:
            answer+=1
            search(i)
                        
    return answer