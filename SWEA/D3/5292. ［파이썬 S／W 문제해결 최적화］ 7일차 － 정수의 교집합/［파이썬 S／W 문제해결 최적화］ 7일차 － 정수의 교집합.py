T=int(input())
for t in range(T):
    N,M=map(int,input().split())
    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    intersection=set(arr1)&set(arr2)
    print(f"#{t+1} {len(intersection)}")
