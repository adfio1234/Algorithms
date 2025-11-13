def isSameString(S,E):
    while E:
        if S==E:
            return "Yes"
        elif E[-1]=="X":
            E.pop()
        elif E[-1]=="Y":
            E.pop()
            E=E[::-1]
    return "No"
T=int(input())
for t in range(T):
    S=list(input())
    E=list(input())
    print(f"#{t+1} {isSameString(S,E)}")