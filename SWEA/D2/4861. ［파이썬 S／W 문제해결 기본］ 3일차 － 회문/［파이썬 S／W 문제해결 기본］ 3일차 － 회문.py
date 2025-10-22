def row(arr,length):
    for i in arr:
        for j in range(len(i)-length+1):
            str1=i[j:(length//2)+j]

            if length%2==1:
                str2=i[(length//2)+j+1:length+j][::-1]
            else:
                str2 = i[(length // 2) + j:length + j][::-1]
            if str1==str2:
                return i[j:length+j]
    return ""
def col(arr,length):
    for i in range(len(arr)):
        for j in range(len(arr[0])-length+1):
            str = ""
            for k in range(j,length+j):
                str+=arr[k][i]
            str1=str[:length//2]
            if length%2==1:
                str2=str[length//2+1:][::-1]
            else:
                str2 = str[length // 2:][::-1]
            if str1==str2:
                return str
    return ""
T=int(input())
for t in range(T):
    width,length=map(int,input().split())
    arr=[]
    result=""
    for i in range(width):
        arr.append(input())
    result=row(arr,length)
    if result=="":
        result=col(arr,length)
    print("#{} {}".format(t+1,result))