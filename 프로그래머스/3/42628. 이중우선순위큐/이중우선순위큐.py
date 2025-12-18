from collections import defaultdict
import heapq
def solution(operations):
    answer=[]
    minHeap = []
    maxHeap=[]
    count=defaultdict(int)
    
    heapq.heapify(minHeap)
    heapq.heapify(maxHeap)
    
    for i in range(len(operations)):
        if operations[i][0]=="I":
            value=int(operations[i][2:])
            heapq.heappush(minHeap,value)
            heapq.heappush(maxHeap,-value)
            count[value]+=1
        elif operations[i]=="D -1":
            while minHeap and count[minHeap[0]]==0:
                heapq.heappop(minHeap)
            if minHeap:
                tmp=heapq.heappop(minHeap)
                count[tmp]-=1
        else:
            while maxHeap and count[-maxHeap[0]]==0:
                heapq.heappop(maxHeap)
            if maxHeap:
                tmp=heapq.heappop(maxHeap)
                count[-tmp]-=1
    tmp=0
    for i in count:
        if count[i]!=0:
            tmp=max(i,tmp)
    answer.append(tmp)
    
    tmp=float('inf')
    for i in count:
        if count[i]!=0:
            tmp=min(i,tmp)

    if tmp==float('inf'):
        answer.append(0)
    else:
        answer.append(tmp)
    return answer