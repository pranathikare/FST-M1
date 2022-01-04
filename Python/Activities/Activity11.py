fruits = {
    "apple": 15,
    "banana": 40,
    "grapes": 45,
    "papaya": 35,
    "pineapple": 50
}

fruitName = input("What are you looking for? ").lower()
if(fruitName in fruits):
    print("Yes, this is available")
else:
    print("No, this is not available")