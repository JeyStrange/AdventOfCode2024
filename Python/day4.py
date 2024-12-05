def countXmas(r,c):
    patterns = [""]*8
    for i in range(4):
        for j in range(len(patterns)):
            if 0 <= r+offsets[j][0]*i < len(crossword) and 0<= c+offsets[j][1]*i < len(crossword[r+offsets[j][0]*i]): 
                patterns[j] += crossword[r+offsets[j][0]*i][c+offsets[j][1]*i]
    return patterns.count("XMAS")
offsets = ((-1,0),(-1,+1),(0,+1),(+1,+1),(+1,0),(+1,-1),(0,-1),(-1,-1))
def masBox(r,c):
    patterns = [''.join([crossword[r+i][c+i] for i in range(3)]),''.join([crossword[r+2-i][c+i] for i in range(3)])]
    return patterns.count("MAS") + patterns.count("SAM") > 1
with open("AdventOfCode\\day4.txt") as file:
    crossword = [list(x) for x in file.readlines()]
    print(sum([countXmas(r,c) for r in range(len(crossword)) for c in range(len(crossword))]))
    print(sum([masBox(r,c) for r in range(len(crossword)-2) for c in range(len(crossword)-2)]))
