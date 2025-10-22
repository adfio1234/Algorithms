for t in range(10):
    #건물의 개수
    N=int(input())
    #건물높이 배열
    height=list(map(int,input().split()))

    #조망권이 확보된 세대의 개수
    result=0

    for i in range(2,N-1):
        #양옆의 4개의 건물보다는 높아야 조망권이 확보된다
        if height[i]>height[i-1] and height[i]>height[i+1] and height[i]>height[i-2] and height[i]>height[i+2]:
            #양옆의 4개의 건물중 높은건물을 선택한다.
            high=max(height[i-1],height[i+1],height[i-2],height[i+2])
            result+=height[i]-high
    print("#{} {}".format(t+1,result))