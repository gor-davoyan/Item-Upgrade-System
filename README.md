
# Project Title

## How to Compile and Run

### Clone the repository:

```bash
git clone [<repository-url>](https://github.com/gor-davoyan/Item-Upgrade-System.git)
```

### Navigate to the project directory:

```bash
cd project-directory
```

### Compile the project using Maven:

```bash
mvn clean install
```

### Run the program:

```bash
mvn exec:java
```

## Some Information

### Item Upgrade Logic:

The program differentiates between general upgrades (common to great, great to rare) and epic upgrades, which involve comparing upgrade counts of multiple items.

### Item Class:

Contains the item name, rarity, and upgrade count. The `toString()` method is used to display the item’s details (name and rarity).

### Inventory Class:

Stores items in a `Map<String, List>`, where the string is the item name and the value is a list of items. This allows easy management of items by their name.
