from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    truckIdx=0
    curWeight=0
    
    bridge=[0]*bridge_length
    bridge=deque(bridge)
    
    while truckIdx<len(truck_weights):
        curWeight-=bridge.popleft()
        
        if curWeight+truck_weights[truckIdx]>weight:
            bridge.append(0)
        else:
            bridge.append(truck_weights[truckIdx])
            curWeight+=truck_weights[truckIdx]
            truckIdx+=1
        #print(bridge,curWeight)
        answer+=1
    while bridge:
        bridge.popleft()
        answer+=1
    return answer