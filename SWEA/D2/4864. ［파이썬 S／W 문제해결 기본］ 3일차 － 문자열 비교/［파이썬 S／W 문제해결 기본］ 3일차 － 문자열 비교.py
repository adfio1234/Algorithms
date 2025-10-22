T=int(input())
for t in range(T):
    str1=input()

    str2=input()
    if str1 in str2:
        print("#{} 1".format(t+1))
    else:
        print("#{} 0".format(t+1))