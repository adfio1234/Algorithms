T=int(input())
for t in range(T):
    N=int(input())
    result=0
    arr=[[0]*10 for _ in range(10)]
    for i in range(N):
        area=list(map(int,input().split()))

        for j in range(area[0],area[2]+1):
            for k in range(area[1],area[3]+1):
                if arr[j][k]==0:
                    arr[j][k]=area[4]
                elif arr[j][k]==area[4] or arr[j][k]==-1:
                    continue
                else:
                    result+=1
                    arr[j][k]=-1

    print("#{} {}".format(t+1,result))