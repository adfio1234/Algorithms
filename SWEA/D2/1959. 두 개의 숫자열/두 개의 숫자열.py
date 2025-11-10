def findMax(small,big):
    result=0
    total=0
    for i in range(0,len(big)-len(small)+1):
        total=0
        for j in range(len(small)):
            total+=(small[j]*big[i+j])
        if result<total:
            result=total
    return result

T=int(input())
for t in range(T):
    N,M=map(int,input().split())
    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    if len(arr1)>len(arr2):
        arr1,arr2=arr2,arr1
    print(f"#{t+1} {findMax(arr1,arr2)}")