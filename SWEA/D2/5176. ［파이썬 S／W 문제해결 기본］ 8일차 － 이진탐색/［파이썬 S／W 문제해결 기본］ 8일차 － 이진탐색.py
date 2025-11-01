def binaryTree(idx):
    global num
    if idx>N:
        return
    binaryTree(idx*2)
    tree[idx]=num
    num+=1
    binaryTree(idx*2+1)

T=int(input())
for t in range(T):
    N=int(input())
    tree=[0]*(N+1)
    num=1

    binaryTree(1)
    print(f"#{t+1} {tree[1]} {tree[N//2]}")