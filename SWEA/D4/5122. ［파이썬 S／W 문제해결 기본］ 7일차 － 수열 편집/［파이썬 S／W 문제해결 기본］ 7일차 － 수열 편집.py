T=int(input())
for t in range(T):

    #arrLength: 수열의 길이
    #amendNum: 수정 추가 횟수
    #targetIdx: 출력할 인덱스 번호
    arrLength,amendNum,targetIdx=map(int,input().split())

    arr=list(map(int,input().split()))
    for i in range(amendNum):
        #command 입력
        command=input().split()

        if command[0]=='I':
            idx,addNum=int(command[1]),int(command[2])
            arr=arr[:idx]+[addNum]+arr[idx:]

        elif command[0]=='D':
            idx=int(command[1])
            arr=arr[:idx]+arr[idx+1:]
        else:
            idx=int(command[1])
            arr[idx]=int(command[2])

    if targetIdx>=len(arr):
        print(f"#{t + 1} {-1}")
        continue
    print(f"#{t + 1} {arr[targetIdx]}")