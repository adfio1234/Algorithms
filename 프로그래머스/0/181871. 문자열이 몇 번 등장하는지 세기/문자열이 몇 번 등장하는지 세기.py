def solution(myString, pat):
    answer = 0
    while myString.find(pat)!=-1:
        if myString.find(pat)!=-1:
            answer+=1
            myString=myString[myString.find(pat)+1:]
    return answer