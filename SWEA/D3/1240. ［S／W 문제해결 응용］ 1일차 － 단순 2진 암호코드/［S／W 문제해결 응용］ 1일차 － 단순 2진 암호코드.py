def decoder(lst):
    decodePaper=["0001101","0011001","0010011",
                 "0111101","0100011","0110001",
                 "0101111","0111011","0110111",
                 "0001011"]
    for i in range(len(decodePaper)):
        if decodePaper[i]==''.join(lst):
            return i
T=int(input())
for t in range(T):
    N, M = map(int, input().split())
    total=0
    for i in range(N):
        code=list(map(str,input()))
        if "1" in code:
            for j in range(M-1,-1,-1):
                if code[j]=="1":
                    secretCode=code[j-55:j+1]
                    break
    codeLst=[]
    for i in range(8):
        codeLst.append(secretCode[7*i:7*(i+1)])
    decode=[]
    for i in codeLst:
        decode.append(decoder(i))
    for i in range(len(decode)):
        if i%2==0:
            total+=(decode[i]*3)
        else:
            total+=decode[i]
    ans=0
    if total%10==0:
        ans=sum(decode)
    print(f"#{t+1} {ans}")