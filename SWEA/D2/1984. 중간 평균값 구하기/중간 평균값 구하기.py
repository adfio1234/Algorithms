T=int(input())
for t in range(T):
    arr=list(map(int,input().split()))
    arr.sort()
    arr=arr[1:][:-1]
    print("#{} {}".format(t+1,round(sum(arr)/len(arr))))