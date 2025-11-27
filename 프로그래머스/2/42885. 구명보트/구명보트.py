def solution(people, limit):
    people.sort()
    left = 0
    right = len(people) - 1
    boats = 0
    
    while left <= right:
        # 가장 무거운 사람(people[right])과
        # 가장 가벼운 사람(people[left])을 태울 수 있으면 같이 태움
        if people[left] + people[right] <= limit:
            left += 1
        # 무거운 사람은 무조건 배 태워야 하므로
        right -= 1
        boats += 1
    
    return boats
