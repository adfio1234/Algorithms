T=input()
print("0 1 2 3 4 5 6 7 8 9")
result=[0,0,0,0,0,0,0,0,0,0]
for i in range(len(T)):
    result[int(T[i])]+=1
for i in range(len(result)):
    print("{} ".format(result[i]),end="")