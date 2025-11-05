def leastHeightDwarf(max,total):
    while 1:
        max+=1
        if (total+max)%7==0:
            return max

T=int(input())
for _ in range(T):
    dwarf=list(map(int,input().split()))
    dwarf.sort()
    print(leastHeightDwarf(dwarf[5],sum(dwarf)))
