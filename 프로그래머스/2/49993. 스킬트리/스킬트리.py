def solution(skill, skill_trees):
    answer = 0
    for i in range(len(skill_trees)):
        level=[]
        answer+=1
        tree=list(skill_trees[i])
        for j in skill:
            if j in tree:
                level.append(tree.index(j))
            else:
                level.append(100)
        for j in range(len(level)-1):
            if level[j]>level[j+1]:
                answer-=1
                break
    return answer