T=int(input())
for t in range(T):
    ans=1
    str=input()
    stack=[]
    for i in str:
        if i!='(' and i!=')' and i!='{' and i!='}':
            continue
        elif len(stack)==0 and (i==')' or i=='}'):
            ans=0
            break
        elif i==')' or i=='}':

            if i==')':
                if stack[-1]=='(':
                    stack.pop()
                else:
                    ans=0
                    break
            elif i=='}':
                if stack[-1]=='{':
                    stack.pop()
                else:
                    ans=0
                    break
        else:
           stack.append(i)
    if len(stack)!=0:
        ans=0
    print("#{} {}".format(t+1,ans))