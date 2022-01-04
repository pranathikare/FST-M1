listOne = [1, 2, 3, 4, 5]
listTwo = [11, 12, 13, 14, 15]

print("First List ", listOne)
print("Second List ", listTwo)

listThree = []
for num in listOne:
    if (num % 2 != 0):
        listThree.append(num) 

for num in listTwo:
    if (num % 2 == 0):
        listThree.append(num) 


print("Result List is:")
print(listThree)