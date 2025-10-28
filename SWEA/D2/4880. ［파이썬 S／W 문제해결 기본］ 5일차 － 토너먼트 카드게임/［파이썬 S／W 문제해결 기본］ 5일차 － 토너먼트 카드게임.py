def game(card,first,second):
    win={1:3,2:1,3:2}
    if card[first]==card[second]:
        return first
    elif win[card[first]]==card[second]:
        return first
    else:
        return second

def divideConquer(arr,left,right):
    if right==left:
        return left
    elif right-left==1:
        return game(arr,left,right)
    else:
        mid=(left+right)//2
        leftWin=divideConquer(arr,left,mid)
        rightWin=divideConquer(arr,mid+1,right)
        return game(arr,leftWin,rightWin)

T=int(input())
for t in range(T):
    N=int(input())
    card=list(map(int,input().split()))
    #arr=[(i+1,card[i]) for i in range(len(card))]

    print("#{} {}".format(t+1,divideConquer(card,0,len(card)-1)+1))