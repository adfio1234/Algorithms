def solution(board, h, w):
    answer = 0
    target=board[h][w]
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    for i in range(4):
        nx,ny=w+dx[i],h+dy[i]
        if 0<=nx<len(board) and 0<=ny<len(board):
            if board[ny][nx]==target:
                answer+=1
    return answer