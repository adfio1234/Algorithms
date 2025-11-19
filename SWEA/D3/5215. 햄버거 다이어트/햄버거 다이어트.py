T=int(input())
for t in range(T):
    N,L=map(int,input().split())
    score=[0]*(L+1)
    taste=[]
    cal=[]
    for i in range(N):
        ta,ca=map(int,input().split())
        taste.append(ta)
        cal.append(ca)
    for i in range(N):
        for j in range(L,cal[i]-1,-1):
            score[j]=max(score[j],score[j-cal[i]]+taste[i])
    print(f"#{t+1} {score[L]}")
