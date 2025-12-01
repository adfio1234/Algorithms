def solution(people, limit):
    answer = 0
    people.sort()
    left=0
    right=len(people)-1
    while left<=right:
        if (people[right]+people[left])<=limit:
            left+=1
        right-=1
        answer+=1
        #print(left,right,answer)
    return answer