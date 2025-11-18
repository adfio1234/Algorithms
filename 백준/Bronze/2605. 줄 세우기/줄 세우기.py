N=int(input())
student=list(map(int,input().split()))
list=[]
for i in range(len(student)):
    list.append(i+1)
    for j in range(student[i]):
        list[len(list)-1-j],list[len(list)-2-j]=list[len(list)-2-j],list[len(list)-j-1]
for i in list:
    print(i,end=" ")