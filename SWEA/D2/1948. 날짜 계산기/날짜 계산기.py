T=int(input())
for t in range(T):
    calendar=[0,31,28,31,30,31,30,31,31,30,31,30,31]
    data=list(map(int,input().split()))
    firstMonth,firstDate=data[0],data[1]
    secondMonth,secondDate=data[2],data[3]

    leftDay=calendar[firstMonth]-firstDate
    for i in range(firstMonth+1,secondMonth):
        leftDay+=calendar[i]
    if firstMonth!=secondMonth:
        leftDay+=secondDate

    print(f"#{t+1} {leftDay+1}")