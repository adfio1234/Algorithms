def solution(arr):
    i=0
    while(1):
        back=arr
        arr=[int(i/2) if i>=50 and i%2==0 else i*2+1 if i<50 and i%2==1 else i for i in arr]
        if back==arr:
            return i
        i+=1
        
