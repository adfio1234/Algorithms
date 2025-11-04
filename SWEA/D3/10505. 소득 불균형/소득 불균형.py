T = int(input())
for t in range(T):
    N = int(input())
    lst = list(map(int, input().split()))
    avg = sum(lst) / N
    ans = 0
    for i in lst:
        if i <= avg:
            ans += 1

    print(f"#{t + 1} {ans}")