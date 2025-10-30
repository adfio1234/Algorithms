T=int(input())
for t in range(T):
    str=input()
    ans=0
    if str==str[::-1]:
    	ans=1
    print("#{} {}".format(t+1,ans))