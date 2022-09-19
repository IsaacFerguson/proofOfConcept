import requests
from bs4 import BeautifulSoup



def main():
    site = requests.get("https://www.allrecipes.com/recipe/8448231/chicken-alfredo-stuffed-shells/")
    soup = BeautifulSoup(site.content, "html.parser")

    data = soup.find_all("span", {'class' : 'ingredients-item-name elementFont__body'})

    file = open("recipe.txt", 'w')

    for title in data:
        file.write(title.text + "\n")




if __name__ == '__main__':
    main()


