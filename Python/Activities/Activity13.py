def calculateSum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum

numList = [50, 20, 30, 100]

print(calculateSum(numList))