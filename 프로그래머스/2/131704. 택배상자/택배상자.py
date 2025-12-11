def solution(order):
    answer = 0
    stack=[]
    boxNum=1
    for i in order:
        if i>boxNum:
            for j in range(boxNum,i):
                stack.append(j)
                boxNum=j
            boxNum+=1
        if boxNum==i:
            answer+=1
            boxNum+=1
        elif stack[-1]==i:
            answer+=1
            stack.pop()
        elif stack[-1]!=i and boxNum!=i:
            break
        #print(i,stack,boxNum,answer)
    return answer