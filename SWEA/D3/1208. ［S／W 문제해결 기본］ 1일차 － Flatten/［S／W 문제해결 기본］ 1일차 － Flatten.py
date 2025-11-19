for i in range(10):
    T = int(input())
    box = list(map(int, input().split()))
    for _ in range(T):
        box.sort()
        box[-1] -= 1
        box[0] += 1
    print(f"#{i+1} {max(box)-min(box)}")