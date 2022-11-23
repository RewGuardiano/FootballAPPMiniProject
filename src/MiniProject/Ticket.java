package MiniProject;

import java.io.Serializable;

public class Ticket implements Serializable{
private String name;

private String Category;

private String Description;

private double Price;


    public Ticket(){
        this("None","None","None",0);
    }

    public Ticket(String name, String category, String description, double price) {
        setName(name);
        setCategory(category);
        setDescription(description);
        setPrice(price);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    public String toString() {
        return String.format("Name: %s\nCategory: %s\nDescription: %s\nPrice: %s\n",getName(),getCategory(),getDescription(),getPrice());
    }
}
