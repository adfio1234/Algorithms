def factorial(n):
    ans=1
    for i in range(2,n+1):
        ans*=i
    return ans
T=int(input())
for t in range(T):
    N=int(input())
    ans=0
    use3=N//3
    for i in range(use3+1):
        use2=(N-(i*3))//2
        for j in range(use2+1):
            use1=(N-(i*3)-(j*2))
            if j!=0:
                ans+=factorial(i+j+use1)/(factorial(i)*factorial(j)*factorial(use1))*(2**j)
            else:
                ans += factorial(i + j + use1) / (factorial(i) * factorial(j) * factorial(use1))
    print(f"#{t+1} {int(ans)}")