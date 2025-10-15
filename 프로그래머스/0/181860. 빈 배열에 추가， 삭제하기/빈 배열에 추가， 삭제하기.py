def solution(arr, flag):
    answer = []
    for i,j in enumerate(flag):
        if j:
            answer+=[arr[i]]*arr[i]*2
        else:
            # for k in range(arr[i]):
            #     answer.pop()
            answer=answer[:-arr[i]]
                
    return answer