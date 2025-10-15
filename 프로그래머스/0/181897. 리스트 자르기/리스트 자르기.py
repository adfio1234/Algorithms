def solution(n, slicer, num_list):
    answer = []
    #a,b,c=slicer 를 사용하여 가독성을 올릴 수 있다.
    if n==1:
        answer=num_list[:slicer[1]+1]
    elif n==2:
        answer=num_list[slicer[0]:]
    elif n==3:
        answer=num_list[slicer[0]:slicer[1]+1]
    else:
        answer=num_list[slicer[0]:slicer[1]+1:slicer[2]]
    return answer