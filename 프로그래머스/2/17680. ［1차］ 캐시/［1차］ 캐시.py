from collections import deque
def solution(cacheSize, cities):
    if cacheSize==0:
        return len(cities)*5
    answer=0
    queue=deque()
    #도시이름을 전부 대문자로 변형
    for i in range(len(cities)):
        cities[i]=cities[i].upper()
    
    #도시에 하나씩 접근
    for i in range(len(cities)):
        #print(cities[i])
        if cities[i] in queue:#캐시에 도시가 존재할경우
            answer+=1
            queue.remove(cities[i])
            queue.append(cities[i])
        else: #캐시에 존재하지않을경우
            answer+=5 #cache miss!
            queue.append(cities[i])#cache에 추가
            if len(queue)>cacheSize:#cachesize넘어설경우
                queue.popleft()#가장오래된 cache삭제
        #print(queue)
    return answer