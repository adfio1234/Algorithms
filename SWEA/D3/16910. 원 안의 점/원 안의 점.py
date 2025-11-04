def circleSum(N):
    sum=0
    for i in range(1,N+1):
        for j in range(N+1):
            if (i*i+j*j)>(N*N):
                break
            else:
                sum+=1
    return sum
T=int(input())
for t in range(T):
    N=int(input())

    print(f"#{t+1} {circleSum(N)*4+1}")