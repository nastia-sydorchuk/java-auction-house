# Auction House Management System

> A Java-based GUI application for managing collectible items in an auction house

## Overview

The Auction House Management System is a Java application that allows users to manage and oversee collectible items such as books, coins, cars, and furniture. The application provides a graphical user interface (GUI) for viewing, sorting, and analyzing collectible items with various filtering and comparison capabilities.

## Classes Overview

### Core Classes

- **`Collectible`** - Abstract base class representing any collectible item with properties:
  - Year of origin
  - Owner name
  - Condition type
  - Starting price
  - Unique ID

- **`CollectibleList`** - Manages a collection of collectible items with features:
  - Load items from CSV files
  - Sort by ID or price
  - Generate reports
  - Export data to files

- **`CollectibleParser`** - Parses CSV data and validates field types and values

- **`AuctionHouseGUI`** - Graphical user interface built with Swing for viewing and managing items

### Item Types

- **`Book`** - Book collectibles (extends Collectible)
- **`Coin`** - Coin collectibles (extends Collectible)
- **`Car`** - Car collectibles (extends Collectible)
- **`Furniture`** - Furniture collectibles (extends Collectible)

### Utilities

- **`EstimatedYear`** - Handles year estimation and validation
- **`IdComparator`** - Comparator for sorting items by ID
- **`PriceComparator`** - Comparator for sorting items by price
- **`FileWriter`** - Handles report generation and file output

## Datasets

The application includes three sample datasets:

1. **collectible_items.csv** - Valid data with correct types and complete fields
2. **collectible_items_missing_fields.csv** - Test data with missing required fields
3. **collectible_items_wrong_types.csv** - Test data with incorrect field types

## How to Run

### Prerequisites
- Java 8 or higher
- Compiler: `javac`

### Compilation

```bash
cd AuctionHouse/src
javac *.java
```

### Execution

```bash
java Main
```

The application will:
1. Load collectible items from the CSV dataset
2. Display a summary of loaded items in the console
3. Generate a report file
4. Launch the GUI for interactive browsing

## Features

- **Load Data** - Import collectible items from CSV files with validation
- **View Items** - Browse all collectibles with their properties
- **Sort** - Sort items by ID or price
- **Filtering** - Filter items by type (Book, Coin, Car, Furniture)
- **Reports** - Generate text reports of inventory
- **Data Validation** - Detect and handle missing or incorrectly typed data
- **GUI Interface** - User-friendly Swing-based interface for data exploration
