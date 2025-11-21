def stack(string):
    tmp=[]
    for i in range(len(string)):
        if i==0 and (string[i]=="}" or string[i]==")" or string[i]==">" or string[i]=="]"):
            return 0
        if string[i]=="}" and tmp[-1]=="{":
            tmp.pop()
        elif string[i]=="]" and tmp[-1]=="[":
            tmp.pop()
        elif string[i]==")" and tmp[-1]=="(":
            tmp.pop()
        elif string[i]==">" and tmp[-1]=="<":
            tmp.pop()
        else:
            tmp.append(string[i])
    if len(tmp)==0:
        return 1
    else:
        return 0
for t in range(10):
    N=int(input())
    string=input()
    print(f"#{t+1} {stack(string)}")