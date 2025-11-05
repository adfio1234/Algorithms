def primeFactorization(num):
    lst=[0,0,0,0,0]
    while num!=1:
        if num%2==0:
            num//=2
            lst[0]+=1
        if num%3==0:
            num//=3
            lst[1]+=1
        if num%5==0:
            num//=5
            lst[2]+=1
        if num%7==0:
            num//=7
            lst[3]+=1
        if num%11==0:
            num//=11
            lst[4]+=1
    return lst[0],lst[1],lst[2],lst[3],lst[4]
T=int(input())
for t in range(T):
    num=int(input())
    a,b,c,d,e=primeFactorization(num)
    print(f"#{t+1 } {a} {b} {c} {d} {e}")