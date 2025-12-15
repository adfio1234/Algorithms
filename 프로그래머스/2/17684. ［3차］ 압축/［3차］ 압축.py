from collections import deque
def solution(msg):
    answer = []
    msg=deque(msg)
    flag=False
    dictionary=dict()
    tmp=""
    for i in range(65,91):
        dictionary[chr(i)]=i-64
        
    if len(msg)==1:
        return [dictionary[msg.popleft()]]
    last=msg.popleft()
    
    while msg:
        tmp=last
        while tmp in dictionary:
            if len(msg)==0:
                flag=True
                break
            last=msg.popleft()
            tmp+=last
        if tmp not in dictionary:
            dictionary[tmp]=len(dictionary)+1
        
        #print(tmp)
        if not flag and len(msg)==0:
            answer.append(dictionary[tmp[:len(tmp)-1]])
            answer.append(dictionary[last])
        elif flag and len(msg)==0:
            answer.append(dictionary[tmp])
        else:
            answer.append(dictionary[tmp[:len(tmp)-1]])
        tmp=""
    return answer
