with open("AdventOfCode\\day1.txt") as file:
    l = [[],[]]
    for line in file:
        nums = line.strip().split("   ")
        l[0].append(int(nums[0]))
        l[1].append(int(nums[1]))
    count = 0
    for x,y in zip(sorted(l[0]),sorted(l[1])):
        count += abs(x-y)
    print(count)

    score = 0
    for i in l[0]:
        if i in l[1]:
            score+=i*l[1].count(i)
    print(score)