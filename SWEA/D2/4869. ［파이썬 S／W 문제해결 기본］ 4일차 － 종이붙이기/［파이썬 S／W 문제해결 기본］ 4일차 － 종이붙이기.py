import math
def factorial(n):
    ans=1
    for i in range(1,n+1):
        ans*=i
    return ans

T=int(input())
for t in range(T):
    ans=1 #모두1인경우
    width=int(input())
    width=int(width/10)
    maxBigBlock=math.floor(width/2)

    for i in range(1,maxBigBlock+1):
        count=math.pow(2,i)
        combination=factorial(width-i)/(factorial(width-(2*i))*factorial(i))
        ans+=count*combination

    print("#{} {}".format(t+1,int(ans)))