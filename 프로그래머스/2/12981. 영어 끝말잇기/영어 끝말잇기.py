import math
def solution(n, words):
    answer = [0,0]
    visited=[words[0]]
    for i in range(1,len(words)):
        if words[i] in visited or words[i][0]!=visited[-1][-1]:
            answer[0],answer[1]=(i%n)+1,math.ceil((i+1)/n)
            break
        visited.append(words[i])
    return answer