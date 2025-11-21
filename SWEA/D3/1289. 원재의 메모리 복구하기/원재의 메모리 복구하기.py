T=int(input())
for t in range(T):
    memory=input()
    flag=False#False는 뒤가 0이라는 의미
    ans=0
    for i in range(len(memory)):
        if memory[i]=="1" and not flag:
            ans+=1
            flag=True
        elif memory[i]=="0" and flag:
            ans+=1
            flag=False
    print(f"#{t+1} {ans}")