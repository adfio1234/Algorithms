def relateColor(color1,color2):

    circleColor = ['purple', 'red', 'orange', 'yellow', 'green', 'blue', 'purple', 'red']
    ans='X'
    if color1>color2:
        color1,color2=color2,color1
    if color1==color2:
        ans='E'
    elif circleColor[color1-1]==circleColor[color2] or circleColor[color1+1]==circleColor[color2]:
        ans='A'
    elif circleColor[color1+3]==circleColor[color2]:
        ans='C'
    return ans

T=int(input())
for _ in range(T):
    convertNum={'red':1,'orange':2,'yellow':3,'green':4,'blue':5,'purple':6}
    color1,color2=input().split()
    color1=convertNum[color1]
    color2=convertNum[color2]
    print(relateColor(color1,color2))
