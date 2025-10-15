def solution(arr):
    answer = []
    two=[]
    
    if 2 not in arr:
        return [-1]
    
    for i,j in enumerate(arr):
        if j==2:
            two.append(i)

    return arr[two[0]:two[-1]+1]