def distanceString(str):
    hash=[0]*10
    visited=[0]*(len(str)+1)
    if len(str)%2==1:
        return "no"
    for i in str:
        hash[i]+=1
    for i in hash:
        if i!=2 and i!=0:
            return "no"
    for i in range(len(str)):
        if visited[i]==0:
            if i+1+str[i]>len(str)-1:
                return "no"
            if str[i+1+str[i]]!=str[i]:
                return "no"
            else:
                visited[i]=1
                visited[i+str[i]+1]=1
    return "yes"

T=int(input())

for t in range(T):
    S=input()
    S=[int(i) for i in S]
    print(f"{distanceString(S)}")