T=int(input())
for t in range(T):
    list=input().split()
    stack=[]
    num=0
    for i in list:
        if i=='+' or i=='-' or i=='/' or i=='*' or i=='.':
            num-=1
        else:
            num+=1

    if num!=0:
        print("#{} error".format(t+1))
    else:
        for i in list:
            if i=='+':
                stack.append(stack.pop()+stack.pop())
            elif i=='-':
                a=stack.pop()
                b=stack.pop()
                stack.append(b-a)
            elif i=='/':
                a=stack.pop()
               	b=stack.pop()
                stack.append(int(b/a))
            elif i=='*':
                stack.append(stack.pop()*stack.pop())
            elif i=='.':
                print("#{} {}".format(t+1,stack[0]))
            else:
                stack.append(int(i))
