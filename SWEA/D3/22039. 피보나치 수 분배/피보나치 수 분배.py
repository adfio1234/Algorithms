T=int(input())
for _ in range(T):
    N=int(input())
    result=''
    if N%3==1:
        result='impossible'
    else:
        if N%3==2:
            result='BA'
        N//=3
        for i in range(N):
            result+="BBA"
    print(result)

