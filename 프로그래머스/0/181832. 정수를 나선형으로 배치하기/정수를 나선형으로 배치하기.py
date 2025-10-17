def solution(n):
    answer = [[0]*n for _ in range(n)]
    
    count=1
    
    top=0
    bottom=n-1
    left=0
    right=n-1
    
    while count<=n*n:
        for i in range(left,right+1):
            answer[top][i]=count
            count+=1
        top+=1
        
        for i in range(top,bottom+1):
            answer[i][right]=count
            count+=1
        right-=1
        
        for i in range(right,left-1,-1):
            answer[bottom][i]=count
            count+=1
        bottom-=1
        
        for i in range(bottom,top-1,-1):
            answer[i][left]=count
            count+=1
        left+=1
    return answer