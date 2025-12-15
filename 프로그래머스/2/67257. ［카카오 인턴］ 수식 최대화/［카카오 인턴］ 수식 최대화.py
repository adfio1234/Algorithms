def solution(expression):
    answer = 0
    num=""
    operator=set()
    lst=[]
    
    for i in range(len(expression)):
        if expression[i]=='-' or expression[i]=='+' or expression[i]=='*':
            lst.append(int(num))
            lst.append(expression[i])
            operator.add(expression[i])
            num=""
        else:
            num+=expression[i] 
    lst.append(int(num))
    operator=list(operator)
    def operate(operator,num1,num2):
        if operator=='-':
            return num1-num2
        elif operator=='+':
            return num1+num2
        else:
            return num1*num2
    def first(lst,operator):
        while operator in lst:
            index=lst.index(operator)
            lst=lst[:index-1]+[operate(operator,lst[index-1],lst[index+1])]+lst[index+2:]
            #print(index,lst)
        return lst
    #print(len(operator))
    if len(operator)==1:
        tmp=first(lst,operator[0])
        answer=abs(tmp[0])
    elif len(operator)==2:
        operator=[operator[0]+operator[1],operator[1]+operator[0]]
        for i,j in operator:
            tmp=first(lst,i)
            tmp=first(tmp,j)
            answer=max(answer,abs(tmp[0]))
    else:
        operator=['-+*','+*-','*-+','+-*','-*+','*+-']
        for i,j,k in operator:
            #print(i,j,k)
            tmp=first(lst,i)
            tmp=first(tmp,j)
            tmp=first(tmp,k)
            answer=max(answer,abs(tmp[0]))
    return answer