def recurrsionMultiply(N,M):
    sum=1
    if M==1:
        return sum*N
    sum=recurrsionMultiply(N,M-1)
    if sum!=1:
        return sum*N

for _ in range(10):
    T=int(input())
    N,M=map(int,input().split())
    print(f"#{T} {recurrsionMultiply(N,M)}")