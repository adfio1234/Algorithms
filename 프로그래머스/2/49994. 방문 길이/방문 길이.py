def solution(dirs):
    answer=0
    direction={'U':(0,1),'D':(0,-1),'R':(1,0),'L':(-1,0)}
    location=(0,0)
    visited=set()
    for i in dirs:
        x,y=location
        dx,dy=direction[i]
        nx,ny=x+dx,y+dy
        #print((x,y),(nx,ny))
        if -5<=nx<=5 and -5<=ny<=5:
            if (x,y,nx,ny) not in visited:
                #print(i)
                answer+=1
                visited.add((x,y,nx,ny))
                visited.add((nx,ny,x,y))
            location=(nx,ny)
    return answer