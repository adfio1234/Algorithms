def solution(str_list):
    answer = []
    for i,j in enumerate(str_list):
        if j=='l':
            return str_list[:i]
        if j=='r':
            return str_list[i+1:]
    return answer
