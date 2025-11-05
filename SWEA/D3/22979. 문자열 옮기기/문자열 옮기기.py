def operateCommand(text,command):
    total=sum(command)
    total%=len(text)

    return text[total:]+text[:total]
T=int(input())
for _ in range(T):
    text=input()
    operation=int(input())
    command=list(map(int,input().split()))
    print(operateCommand(text,command))