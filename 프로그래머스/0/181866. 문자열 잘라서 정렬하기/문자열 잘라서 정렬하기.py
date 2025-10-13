def solution(myString):
    answer = [s for s in myString.split('x') if s!=""]
    answer.sort()
    return answer