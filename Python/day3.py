import re
with open("AdventOfCode\\day3.txt") as file:
    res = 0
    text = "".join(file.readlines())
    numPairs = re.findall("mul\\((\\d*),(\\d*)\\)",text)
    for num1,num2 in numPairs:
        res += int(num1)*int(num2)
    print(res)

    matches = re.findall(r"(mul\((\d*),(\d*)\))|(do\(\))|(don't\(\))",text,)
    doing = True
    res = 0
    for m in matches:
        match m[3]+m[4]:
            case "":
                if(doing):
                    res += int(m[1])*int(m[2])
            case "do()":
                doing = True
            case "don't()":
                doing = False
    print(res)