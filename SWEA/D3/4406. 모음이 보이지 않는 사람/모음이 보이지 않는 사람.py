def convert(base):
    vowel = ['a', 'e', 'i', 'o', 'u']
    convertBase = ''
    for i in range(len(base)):
        if base[i] in vowel:
            continue
        convertBase += base[i]
    return convertBase
T = int(input())
for t in range(T):
    base = input()

    print(f"#{t + 1} {convert(base)}")