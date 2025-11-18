import math
N, K = map(int, input().split())
answer=0
student = [[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]
for _ in range(N):
    S, Y = map(int, input().split())
    student[S][Y-1]+=1
for i in range(len(student)):
    for j in range(len(student[i])):
        if student[i][j]>0:
            answer+=math.ceil(student[i][j]/K)
print(answer)