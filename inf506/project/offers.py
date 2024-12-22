import requests
import re
import csv
from bs4 import BeautifulSoup

class Offer:
    link: str = ""
    price: str = ""
    accessories: list[str] = []
    area: str = ""
    date: str = ""

    def toList(self):
        return [
            self.link,
            self.price,
            ",".join(self.accessories),
            self.area,
            self.date
        ]

BASE_URL = "https://www.sreality.cz"
OUTPUT_PATH = "offers.csv"

csv_data = [["Link", "Price", "Accessories", "Area", "Date"]]
                
with open('offer_links.txt', 'r') as file:
    
    for link in file:

        print(f"Trying to scrap {link}")

        request_url = f"{BASE_URL}{link}"
        response = requests.get(request_url)

        if response.status_code == 200:

            soup = BeautifulSoup(response.text, 'html.parser')

            info_divs = soup.find_all("div", class_=re.compile('css-1xhj18k'))

            offer = Offer()
            offer.link = request_url

            for info_div in info_divs:
                info_iter = iter(info_div.children)
                
                title = next(info_iter)

                while title.name == "style":
                    title = next(info_iter)

                title_text = title.get_text()[:-1]
                    
                info = next(info_iter)

                info_text = ""

                while info.name == "style":
                    info = next(info_iter)

                if title_text == "Accessories":
                    for accessories in info.contents:
                        if accessories.name == "style":
                            continue

                        for accessory in accessories:
                            if accessory.name == "style":
                                continue

                            info_text = accessory.get_text()
                            offer.accessories.append(info_text)

                else:
                    info_text = info.get_text().replace('\u200b', '').replace('\xa0', ' ')
                    print(f"info: {info_text}")
                
                if title_text == "Price":
                    offer.price = info_text
                elif title_text == "Area":
                    offer.area = info_text
                elif title_text == "Edited":
                    offer.date = info_text

            csv_offer = offer.toList()
            csv_data.append(csv_offer)

    
with open(OUTPUT_PATH, mode='w', newline='') as file:
    # Create a csv.writer object
    writer = csv.writer(file)
    # Write data to the CSV file
    writer.writerows(csv_data)
                     
print(f"CSV file '{OUTPUT_PATH}' created successfully.")
