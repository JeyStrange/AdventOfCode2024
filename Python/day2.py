def safe(nums):
    badJumps = [i for i in range(len(nums)-1) if not 1<=abs(nums[i]-nums[i+1]) <=3] 
    return (sorted(nums) == nums or sorted(nums, reverse=True) == nums) and not badJumps
with open("AdventOfCode\\day2.txt") as file:
    safeReports = 0
    safeReports2 = 0
    for line in file:
        nums = [int(x) for x in line.strip().split(" ")]
        if safe(nums):
            safeReports += 1
        elif [i for i in range(len(nums)) if safe(nums[:i]+nums[i+1:])]:
            safeReports2 += 1
    print(safeReports)
    print(safeReports + safeReports2)