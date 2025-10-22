T=int(input())
for t in range(T):
    str1=set(input())

    str2=list(input())
    dictStr1=dict()
    for i in str1:
        dictStr1[i]=0
    for i in str2:
        if i in dictStr1:
            dictStr1[i]+=1
    print("#{} {}".format(t+1,max(dictStr1.values())))