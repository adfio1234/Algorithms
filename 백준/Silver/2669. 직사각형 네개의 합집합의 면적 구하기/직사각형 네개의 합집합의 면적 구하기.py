arr=[[0]*100 for _ in range(100)]
ans=0
for i in range(4):
    x1,y1,x2,y2=map(int,input().split())
    for j in range(x1,x2):
        for k in range(y1,y2):
            if arr[j][k]==0:
                arr[j][k]=1
                ans+=1
print(ans)