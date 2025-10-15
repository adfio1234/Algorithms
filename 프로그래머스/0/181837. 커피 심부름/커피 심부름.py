def solution(order):
#     answer = 0
#     for i in order:
#         if i.find('cafelatte')!=-1:
#             answer+=5000
#         else:
#             answer+=4500
        
#     return answer
    return sum([5000 if 'cafelatte' in i else 4500 for i in order])