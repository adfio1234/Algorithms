T=int(input())
for t in range(T):
    N,K=map(int,input().split())
    homework=[]
    student=list(map(int,input().split()))
    for i in range(1,N+1):
        if i not in student:
            homework.append(i)
    print(f"#{t+1}",end="")
    for i in homework:
        print(f" {i}",end="")
    print()