from collections import deque
def makeTeam(A,B):
    choiced=set()
    member=['']*(len(A)+1)
    while A and B:
        if A:
            pickA=A.popleft()
        if B:
            pickB=B.popleft()
        if pickA not in choiced:
            choiced.add(pickA)
            member[pickA]='A'
        elif pickA in choiced:
            while A:
                pickA=A.popleft()
                if pickA not in choiced:
                    choiced.add(pickA)
                    member[pickA]='A'
                    break

        if pickB not in choiced:
            choiced.add(pickB)
            member[pickB]='B'
        elif pickB in choiced:
            while B:
                pickB=B.popleft()
                if pickB not in choiced:
                    choiced.add(pickB)
                    member[pickB]='B'
                    break

    return ''.join(member[1:])

T=int(input())
for _ in range(T):
    N=int(input())
    A=deque(map(int,input().split()))
    B=deque(map(int,input().split()))
    print(makeTeam(A,B))