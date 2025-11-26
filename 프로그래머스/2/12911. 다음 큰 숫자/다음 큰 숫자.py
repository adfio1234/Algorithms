def findOne(string):
    count=0
    for i in string:
        if i=='1':
            count+=1
    return count      
def solution(n):
    answer = 0
    bString=bin(n)[2:]
    idx=n+1
    while findOne(bString)!=findOne(bin(idx)[2:]):
        idx+=1
        
    return idx