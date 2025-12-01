def solution(want, number, discount):
    answer = 0
    wishList=[]
    for i in range(len(want)):
        for j in range(number[i]):
            wishList.append(want[i])
    wishList.sort()
    for j in range(0,len(discount)-9):
        tmp=discount[j:10+j]
        tmp.sort()
        if wishList==tmp:
            answer+=1
    return answer