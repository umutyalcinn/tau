import requests
import re
from bs4 import BeautifulSoup

listings_url = 'https://www.sreality.cz/en/search/to-rent/apartments?region=Praha'
offer_links = []

N_PAGES = 141

with open("offer_links.txt", "w") as f:
    for page in range(N_PAGES):
    
        response = requests.get(f"{listings_url}&page={page}")

        if response.status_code == 200:
        
            soup = BeautifulSoup(response.text, 'html.parser')
        
            estate_list_items = soup.find_all(id=re.compile('estate-list-item'))

            for estate_list_item in estate_list_items:
                
                link = next(estate_list_item.children).get("href")

                if link is not None:
                    print(f"grabbed link: {link}")
                    offer_links.append(link)
                    f.write(f"{link}\n")
                
        else:
            print(f"Failed to retrieve the page. Status code: {response.status_code}")

    
