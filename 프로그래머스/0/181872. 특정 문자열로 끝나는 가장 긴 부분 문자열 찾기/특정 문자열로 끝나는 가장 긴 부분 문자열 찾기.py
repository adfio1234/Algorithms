def solution(myString, pat):
#     reverse_myString = myString[::-1]
#     pat=pat[::-1]
    
#     index=reverse_myString.find(pat)
#     return myString[:-index] if myString[:-index] else myString
    return myString[:len(myString)-myString[::-1].find(pat[::-1])]