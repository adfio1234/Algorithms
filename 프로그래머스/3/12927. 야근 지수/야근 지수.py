import heapq
def solution(n, works):
    answer = 0
    if sum(works)<=n:
        return 0
    works=[-i for i in works]
    heapq.heapify(works)
    for i in range(n):
        tmp=heapq.heappop(works)
        tmp+=1
        heapq.heappush(works,tmp)
    for i in works:
        answer+=i*i
    return answer