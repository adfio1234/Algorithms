from collections import deque
def solution(str1, str2):
    answer = 0
    tmp=""
    str1=deque(str1.upper())
    str2=deque(str2.upper())
    lst1=[]
    lst2=[]
    dict1=dict()
    dict2=dict()
    dict3=dict()
    total1=0
    total2=0
    
    def multipleSet(str):
        lst=[]
        first=str.popleft()
        
        while len(str)>=1:
            second=str.popleft()
            if 65>ord(first) or ord(first)>90 or 65>ord(second) or ord(second)>90:
                first=second
                continue
            lst.append(first+second)
            first=second
        return lst
    
    lst1=multipleSet(str1)
    lst2=multipleSet(str2)
    
    if len(lst1)==0 and len(lst2)==0:
        return 65536
    else:
        def lstToDict(lst):
            dictTmp=dict()
            for i in lst:
                if i not in dictTmp:
                    dictTmp[i]=1
                else:
                    dictTmp[i]+=1
            return dictTmp
        dict1=lstToDict(lst1)
        dict2=lstToDict(lst2)
    
    #교집합
    for i in dict1:
        if i in dict2:
            dict3[i]=min(dict1[i],dict2[i])
    for i in dict3:
        total1+=dict3[i]
    #print(total1)
    #합집합    
    dict3=dict1
    for i in dict2:
        if i in dict3:
            dict3[i]=max(dict2[i],dict3[i])
        else:
            dict3[i]=dict2[i]
    for i in dict3:
        total2+=dict3[i]
    #print(total2)
    answer=total1/total2
    
    return int(answer*65536)