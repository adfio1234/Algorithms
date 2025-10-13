def solution(arr, query):
    answer = arr
    for q,i in enumerate(query):#enumerate를 사용하여 인덱스와 값을 순회한다.
        if q%2==0:
            answer=answer[:i+1]
            #print(answer)
        else:
            answer=answer[i:]
            #print(answer)
    return answer