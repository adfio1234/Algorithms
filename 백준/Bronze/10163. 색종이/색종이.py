N = int(input())
arr = [[0]*1001 for _ in range(1001)]
ans = [0]*(N+1)

for paper_num in range(1, N+1):
    x, y, w, h = map(int, input().split())
    for i in range(y, y+h):
        for j in range(x, x+w):
            arr[i][j] = paper_num

for i in range(1001):
    for j in range(1001):
        ans[arr[i][j]] += 1

for i in range(1, N+1):
    print(ans[i])
