def findFake(dwarf):
    total=sum(dwarf)
    for i in range(len(dwarf)):
        for j in range(i+1,len(dwarf)):
            if (total-dwarf[i]-dwarf[j])==100:
                return i,j
dwarf=[]
for _ in range(9):
    dwarf.append(int(input()))
fake1,fake2=findFake(dwarf)
dwarf[fake1],dwarf[fake2]=0,0
dwarf.sort()
for i in range(2,9):
    print(dwarf[i])