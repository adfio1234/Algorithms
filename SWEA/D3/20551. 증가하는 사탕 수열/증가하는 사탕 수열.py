def eatCandy(A,B,C):
    result=0
    if C<=2:
        return -1
    while B>=C:
        result+=1
        B-=1
    while A>=B :
        result+=1
        A-=1
    if A<1 or B<1 or C<1:
        return -1
    return result
T=int(input())
for t in range(T):
    A,B,C=map(int,input().split())
    print(f"#{t+1} {eatCandy(A,B,C)}")