T=int(input())
for t in range(T):
    ans=0
    numA,numB=map(int,input().split())
    A=[]
    B=[]
    for i in range(numA):
        A.append(input())
    for i in range(numB):
        B.append(input())
    for i in A:
        if i in B:
            ans+=1
    print(f"#{t+1} {ans}")