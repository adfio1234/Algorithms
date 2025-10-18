T=int(input())
for i in range(T):
    P,Q,R,S,W=map(int,input().split())
    
    #A사 사용시 W*P
    A_use=W*P

    #B사 사용시
    if W<=R:
        B_use=Q
    else:
        B_use=Q+(W-R)*S
        
    print("#{} {}".format(i+1,A_use if A_use<B_use else B_use))
#A는 리터당P
#B는 기본Q 사용량이R이하인경우 Q, R보다많을경우 리터당 S
#한달간 사용량 W