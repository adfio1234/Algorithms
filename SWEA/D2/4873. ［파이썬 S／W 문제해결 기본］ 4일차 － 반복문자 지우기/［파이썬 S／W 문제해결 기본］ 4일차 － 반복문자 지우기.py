def repeat(s):
    idx=0
    while True:
        if idx>=len(s)-1:
            return len(s)
        if s[idx]==s[idx+1]:
            s=s[:idx]+s[idx+2:]
            idx=0
            continue
        idx+=1


T=int(input())
for t in range(T):
    string=input()
    print("#{} {}".format(t+1,repeat(string)))
