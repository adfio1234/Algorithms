T=int(input())
for t in range(T):
    cup,K=input().split()
    K=int(K)
    pointBubble=0
    if cup=='o..':
        if K%2==0:
            pointBubble=0
        else:
            pointBubble=1
    elif cup=='.o.':
        if K%2==0:
            pointBubble=1
        else:
            pointBubble=0
    elif cup=='..o':
        if K==0:
            pointBubble=2
        elif K%2==0:
            pointBubble=0
        else:
            pointBubble=1
    print(f"#{t+1} {pointBubble}")


