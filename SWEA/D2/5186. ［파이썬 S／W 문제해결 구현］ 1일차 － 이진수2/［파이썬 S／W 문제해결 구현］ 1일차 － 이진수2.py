T=int(input())
for j in range(T):
    N = float(input())
    two = 1
    result = []
    for i in range(13):
        two /= 2
        if N >= two:
            N -= two
            result.append(1)
        else:
            result.append(0)
        if N == 0:
            print("#{} {}".format(j+1,''.join(map(str,result))))
            break
    if N!=0:
        print("#{} overflow".format(j+1))