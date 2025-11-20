for _ in range(10):
    answer=0
    T=int(input())
    flag=input()
    sentence=input()
    while sentence.find(flag)!=-1:
        idx=sentence.find(flag)
        sentence=sentence[idx+1:]
        answer+=1
    print(f"#{T} {answer}")