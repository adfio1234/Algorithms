def solution(my_string, m, c):
    return ''.join([my_string[i] for i in range(len(my_string)) if i%m==c-1])
