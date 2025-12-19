def solution(record):
    answer = []
    user=dict()
    
    for i in record:
        message=i.split()
        if len(message)==3:
            if message[0]=="Enter":
                if message[1] not in user:
                    user[message[1]]=message[2]
                elif message[1] in user:
                    user[message[1]]=message[2]
            elif message[0]=="Change":
                user[message[1]]=message[2]
    
    for i in record:
        message=i.split()
        if len(message)==3:
            if message[0]=="Enter":
                welcome="님이 들어왔습니다."
                answer.append(user[message[1]]+welcome)
        if len(message)==2:
            exit="님이 나갔습니다."
            answer.append(user[message[1]]+exit)

    return answer