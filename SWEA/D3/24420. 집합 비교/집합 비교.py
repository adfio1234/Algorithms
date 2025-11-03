def identifySet(firstSet,secondSet):
    output="?"
    if firstSet==secondSet:
        output="="
    elif len(firstSet)>len(secondSet):
        for i in secondSet:
            if i not in firstSet:
                return "?"
        output=">"
    elif len(firstSet)<len(secondSet):
        for i in firstSet:
            if i not in secondSet:
                return "?"
        output="<"

    return output

T=int(input())
for _ in range(T):
    firstSetSize,secondSetSize=map(int,input().split())
    firstSet=list(map(int,input().split()))
    secondSet=list(map(int,input().split()))
    firstSet.sort()
    secondSet.sort()
    print(identifySet(firstSet,secondSet))
