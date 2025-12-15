def solution(n, wires):
    answer = 100
    graph=[[0 for i in range(n+1)] for j in range(n+1)]
    
    for i in wires:
        x,y=i
        graph[x][y]=1
        graph[y][x]=1
        
    def dfs(node):
        #print(graph[node])
        for i in range(len(graph[node])):
            if graph[node][i]==1 and not visited[i]:
                visited[i]=True
                dfs(i)
                
    for i in wires:
        visited=[False]*(n+1)
        visited[1]=True
        x,y=i
        total=0
        
        graph[x][y]=0
        graph[y][x]=0
        dfs(1)
        for j in visited:
            if j:
                total+=1
        total=min(total,n-total)
        answer=min(answer,(n-2*total))
        graph[x][y]=1
        graph[y][x]=1
        
    return answer