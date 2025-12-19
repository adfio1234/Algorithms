from collections import deque
def solution(begin, target, words):
    answer = 0
    visited=[False]*(len(words)+1)
    if target not in words:
        return 0
    def diff(x,y):
        total=0
        for i in range(len(x)):
            if x[i]!=y[i]:
                total+=1
        return total
    
    def bfs(start,step):
        queue=deque([(start,step)])
        while queue:
            cur,distance=queue.popleft()
            if cur==target:
                return distance
            for i in range(len(words)):
                if diff(cur,words[i])==1 and not visited[i]:
                    visited[i]=True
                    queue.append((words[i],distance+1))
    answer=bfs(begin,0)
    return answer