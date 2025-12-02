def solution(bandage, health, attacks):
    answer = 0
    endTime=attacks[-1][0]
    startTime=0
    comboHeal=0
    maxComboHeal=bandage[0]
    heal=bandage[1]
    idx=0
    maxHp=health
    
    while startTime<endTime:
        startTime+=1
        if attacks[idx][0]==startTime:
            if (health-attacks[idx][1])<=0:
                return -1
            health-=attacks[idx][1]
            comboHeal=0
            idx+=1
        else:
            comboHeal+=1
            health+=heal
        if comboHeal==maxComboHeal:
            health+=bandage[2]
            comboHeal=0
        if health>maxHp:
            health=maxHp
    return health