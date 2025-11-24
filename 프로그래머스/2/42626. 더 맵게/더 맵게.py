import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)

    while True:
        first=heapq.heappop(scoville)
        if first>=K:
            return answer
        if len(scoville)<=0:
            return -1
        second=heapq.heappop(scoville)
        mix=first+second*2
        heapq.heappush(scoville,mix)
        #print(scoville)
        answer+=1
    return -1