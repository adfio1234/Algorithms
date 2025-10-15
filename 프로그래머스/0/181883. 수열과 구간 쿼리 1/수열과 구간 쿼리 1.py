def solution(arr, queries):
    answer = []
    for s,e in queries:
        arr=[j+1 if i>=s and i<=e else j for i,j in enumerate(arr)]
    return arr