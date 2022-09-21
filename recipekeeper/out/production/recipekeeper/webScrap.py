import requests
from bs4 import BeautifulSoup
import os
from pathlib import Path



def main():
    # downloads the html of site 
    site = requests.get("https://www.allrecipes.com/recipe/8448231/chicken-alfredo-stuffed-shells/")
    soup = BeautifulSoup(site.content, "html.parser")

    # searches for the html tags with the ingredients
    data = soup.find_all("span", {'class' : 'ingredients-item-name elementFont__body'})
    
    # gets the name of the recipe
    head = soup.find('h1')
                     
    file = open('recipe.txt', 'w+')

    file.write("https://www.allrecipes.com/recipe/8448231/chicken-alfredo-stuffed-shells/ \n")

    # writes each ingredient to txt file
    file.write(head.text + '\n')
    for title in data:
        file.write(title.text + "\n")





if __name__ == '__main__':
    main()


