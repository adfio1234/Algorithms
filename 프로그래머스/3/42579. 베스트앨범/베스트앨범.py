def solution(genres, plays):
    answer = []
    song=dict()
    for i in range(len(genres)):
        genre=genres[i]
        if genre not in song:
            song[genre]=0
        song[genre]+=plays[i]
    song=dict(sorted(song.items(),key=lambda x:x[1],reverse=True))
    for i in song:
        tmp=[]
        for j in range(len(genres)):
            if genres[j]==i:
                tmp.append((plays[j],j))
        tmp.sort(key=lambda x:(-x[0],x[1]))
        if len(tmp)==1:
            answer.append(tmp[0][1])
        else:
            tmp=[tmp[i][1] for i in range(2)][::-1]
            while tmp:
                answer.append(tmp.pop())
        
    return answer