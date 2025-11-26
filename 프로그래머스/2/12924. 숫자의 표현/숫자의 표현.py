def solution(n):
    answer = 1
    
    for i in range(1,n):
        #arr=[]
        total=0
        for j in range(i,n):
            total+=j
            #arr.append(j)
            if total==n:
                answer+=1
                #print(arr)
                break
            if total>n:
                break
    return answer