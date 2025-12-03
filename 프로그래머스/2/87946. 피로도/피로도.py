def solution(k, dungeons):
    answer = 0
    visited=[False]*len(dungeons)
    def dfs(cur,count):
        nonlocal answer
        answer=max(answer,count)
        for i in range(len(dungeons)):
            minimum,consume=dungeons[i]
            if not visited[i] and minimum<=cur:
                visited[i]=True
                dfs(cur-consume,count+1)
                visited[i]=False
    dfs(k,0)
    return answer