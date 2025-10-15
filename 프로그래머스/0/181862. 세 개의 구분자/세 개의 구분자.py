def solution(myStr):
    answer=[]
    tmp=''
    start=0
    for i in range(len(myStr)):
        if myStr[i]=='a' or myStr[i]=='b' or myStr[i]=='c':
            answer.append(myStr[start:i])
            start=i+1
    answer.append(myStr[start:])
    answer=[i for i in answer if i]
    if len(answer)==0:
        answer.append("EMPTY")
    return answer