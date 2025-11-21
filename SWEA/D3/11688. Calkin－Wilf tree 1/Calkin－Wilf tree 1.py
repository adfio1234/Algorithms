T=int(input())
for t in range(T):
    string=input()
    a,b=1,1
    for i in range(len(string)):
        if string[i]=='L':
            b+=a
        elif string[i]=='R':
            a+=b
    print(f"#{t+1} {a} {b}")
