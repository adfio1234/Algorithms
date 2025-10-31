import math
T=int(input())
for t in range(T):
    N=int(input())
    if N%2==0:
        N=math.ceil(N/2)
        N*=-1
    else:
        N=math.ceil(N/2)
    print("#{} {}".format(t+1,N))