def searchGraph(graph,start,end,visited):
    if visited is None:
        visited=set()

    if start==end:
        return 1
    found=0
    visited.add(start)

    for i in range(1,len(graph[start])):
        if graph[start][i]==1 and i not in visited:
            found=searchGraph(graph,i,end,visited)
        if found==1:
            return 1
    return 0
T=int(input())
for t in range(T):
    ans=1
    numV,numE=map(int,input().split())
    graph=[[0]*(numV+1) for _ in range(numV+1)]

    for _ in range(numE):
        startEdge,endEdge=map(int,input().split())
        graph[startEdge][endEdge]=1

    startNode,endNode=map(int,input().split())
    if 1 not in graph[startNode]:
        ans=0
    elif 1 not in graph[startNode]:
        ans=0
    else:
        ans=searchGraph(graph,startNode,endNode,visited=None)
    print("#{} {}".format(t+1,ans))
