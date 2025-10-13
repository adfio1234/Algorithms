def solution(my_string, queries):
    original=[]
    for i,j in queries:
        original.append(my_string[:i])
        original.append(my_string[j+1:])

        piece=my_string[i:j+1]
        reverse_slice=piece[::-1]
        
        my_string=""
        my_string=original[0]+reverse_slice+original[1];
        
        original=[]

    return my_string