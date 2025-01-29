`How to Compile and Run`
Clone the repository:

git clone [<repository-url>](https://github.com/gor-davoyan/Item-Upgrade-System.git)

Navigate to the project directory:

cd project-directory

Compile the project using Maven:

mvn clean install

Run the program:

mvn exec:java

`Some Information`
Item Upgrade Logic:
    The program differentiates between general upgrades (common to great, great to rare) and epic upgrades, which involve comparing upgrade counts of multiple items.

Item Class:
    Contains the item name, rarity, and upgrade count. The toString() method is used to display the item’s details (name and rarity).

Inventory Class:
    Stores items in a Map<String, List<Item>>, where the string is the item name and the value is a list of items. This allows easy management of items by their name.
