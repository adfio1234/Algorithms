def solution(binomial):
    answer = 0
    parameter=[]
    parameter=binomial.split(" ")# 공백을 분리해주는 함수
    if parameter[1]=="-":
        answer=int(parameter[0])-int(parameter[2])
    elif parameter[1]=="+":
        answer=int(parameter[0])+int(parameter[2])
    else:
        answer=int(parameter[0])*int(parameter[2])
    return answer