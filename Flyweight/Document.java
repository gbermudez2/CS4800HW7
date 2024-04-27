package Flyweight;

import java.io.*;

public class Document {
    private StringBuilder content = new StringBuilder();

    public void addCharacter(char c, String font, String color, int size) {
        CharacterProperties properties = CharacterPropertiesFactory.getCharacterProperties(font, color, size);
        content.append("[").append(c).append(": ").append(properties.getFont()).append(", ")
                .append(properties.getColor()).append(", ").append(properties.getSize()).append("] ");
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Document loadFromFile(String fileName) {
        Document doc = new Document();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doc.content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public String getContent() {
        return content.toString();
    }
}

