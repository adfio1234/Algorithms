def solution(my_string):
    answer = [0 for i in range(52)]
    for i in range(len(my_string)):
        if my_string[i]<'a':
            answer[ord(my_string[i])-65]+=1
        else:
            answer[ord(my_string[i])-71]+=1
    return answer