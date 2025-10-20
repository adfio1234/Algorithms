T=int(input())
for i in range(T):
    entire,part=map(int,input().split())
    arr=list(map(int,input().split()))
    result=[]
    for j in range(entire-part+1):
        result.append(sum(arr[j:j+part]))

    print("#{} {}".format(i+1,max(result)-min(result)))