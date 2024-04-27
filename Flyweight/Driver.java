package Flyweight;

public class Driver {
    public static void main(String[] args) {
        // Create documents with different character properties
        Document doc1 = new Document();
        doc1.addCharacter('H', "Arial", "Red", 12);
        doc1.addCharacter('e', "Arial", "Red", 12);
        doc1.addCharacter('l', "Arial", "Red", 12);
        doc1.addCharacter('l', "Arial", "Blue", 14);
        doc1.addCharacter('o', "Calibri", "Blue", 14);
        doc1.addCharacter(' ', "Calibri", "Blue", 14);
        doc1.addCharacter('W', "Verdana", "Black", 16);
        doc1.addCharacter('o', "Verdana", "Black", 16);
        doc1.addCharacter('r', "Verdana", "Black", 16);
        doc1.addCharacter('l', "Times New Roman", "Black", 16);
        doc1.addCharacter('d', "Times New Roman", "Black", 16);
        doc1.saveToFile("document1.txt");

        // Load and display the saved document
        Document doc2 = Document.loadFromFile("document1.txt");
        System.out.println(doc2.getContent());
    }
}
