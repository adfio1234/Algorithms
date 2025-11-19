from collections import deque
for _ in range(10):
    N=int(input())
    queue=list(map(int,input().split()))
    queue=deque(queue)
    flag=True
    while flag:
        for i in range(1,6):
            tmp=queue.popleft()-i
            if tmp<=0:
                queue.append(0)
                flag=False
                break
            else:
                queue.append(tmp)
    print(f"#{N} {queue[0]} {queue[1]} {queue[2]} {queue[3]} {queue[4]} {queue[5]} {queue[6]} {queue[7]}")
