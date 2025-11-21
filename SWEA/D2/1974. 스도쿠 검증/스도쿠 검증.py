T = int(input())
for t in range(T):
    ans = 1
    sudoku = []
    total = 0
    for i in range(9):
        tmp = list(map(int, input().split()))
        sudoku.append(tmp)


    def rowSudoku(sudoku):
        tf = [False] * 9
        for i in range(len(sudoku)):
            for j in range(len(sudoku[i])):
                tf[sudoku[i][j] - 1] = True
            if False in tf:
                return 0
            tf = [False] * 9
        return 1


    ans = rowSudoku(sudoku)
    if ans==1:
        ans = rowSudoku(list(map(list, zip(*sudoku))))
    if ans==1:
        tf = [False] * 9
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                tf[sudoku[i][j] - 1] = True
                tf[sudoku[i][j + 1] - 1] = True
                tf[sudoku[i][j + 2] - 1] = True
                tf[sudoku[i + 1][j] - 1] = True
                tf[sudoku[i + 1][j + 1] - 1] = True
                tf[sudoku[i + 1][j + 2] - 1] = True
                tf[sudoku[i + 2][j] - 1] = True
                tf[sudoku[i + 2][j + 1] - 1] = True
                tf[sudoku[i + 2][j + 2] - 1] = True
                if False in tf:
                    ans = 0
                tf = [False] * 9

    print(f"#{t + 1} {ans}")