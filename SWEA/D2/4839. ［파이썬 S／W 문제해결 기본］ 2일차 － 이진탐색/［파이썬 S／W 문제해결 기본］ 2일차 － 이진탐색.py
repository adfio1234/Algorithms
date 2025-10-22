
def binary_search(left, right, key):
    count = 0

    while True:
        count += 1
        mid = (left + right) // 2

        if mid == key:
            return count
        elif key < mid:
            right = mid
        else:
            left = mid

        # 무한 루프 방지 + 마지막 확인
        if left == right or right - left == 1:
            count += 1
            mid = (left + right) // 2
            if mid == key:
                return count
            else:
                return count


T=int(input())
for t in range(T):
    page=list(map(int,input().split()))
    A=[1,page[0],page[1]]
    B=[1,page[0],page[2]]
    aFind=binary_search(A[0],A[1],A[2])
    bFind = binary_search(B[0], B[1], B[2])
    if aFind==bFind:
        print("#{} 0".format(t+1))
    elif aFind>bFind:
        print("#{} B".format(t+1))
    else:
        print("#{} A".format(t+1))