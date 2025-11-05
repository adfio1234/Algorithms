def rotate90(arr):
    result=[]
    for i in range(len(arr)):
        tmp=[]
        for j in range(len(arr)-1,-1,-1):
            tmp.append(arr[j][i])
        result.append(tmp)
    return result

def rotate180(arr):
    result=[]
    for i in range(len(arr)-1,-1,-1):
        tmp=[]
        for j in range(len(arr)-1,-1,-1):
            tmp.append(arr[i][j])
        result.append(tmp)
    return result

def rotate270(arr):
    result=[]
    for i in range(len(arr)-1,-1,-1):
        tmp=[]
        for j in range(len(arr)):
            tmp.append(arr[j][i])
        result.append(tmp)
    return result
T=int(input())
for t in range(T):
    N=int(input())
    arr=[]
    for i in range(N):
        tmp=list(input().split())
        arr.append(tmp)
    arr90=rotate90(arr)
    arr180=rotate180(arr)
    arr270=rotate270(arr)
    ans=[]
    print(f"#{t+1}")
    for i in range(N):
        ans.append(''.join(arr90[i])+" "+''.join(arr180[i])+" "+''.join(arr270[i]))
    for i in ans:
        print(i)