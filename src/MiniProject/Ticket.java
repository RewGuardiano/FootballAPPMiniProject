package MiniProject;

import java.io.Serializable;

/**
 *
 */

public class Ticket implements Serializable{
    private String name;

    private String Email;

    private String Category;

    private String Description;

    private double Price;


    public Ticket(){
        this("None","None","None","None",0);
    }

    public Ticket(String name,String email, String category, String description, double price) {
        setName(name);
        setEmail(email);
        setCategory(category);
        setDescription(description);
        setPrice(price);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.equals(""))
            throw new IllegalArgumentException("The Ticket must have a Person's name assigned to it\n");
        this.name = name;

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        if(price<0)
            throw new IllegalArgumentException("The ticket price must be a positive number\n");
       this.Price = price;
    }
    public String toString() {
        return String.format("Name: %s\nCategory: %s\nDescription: %s\nPrice: %.2f\n",getName(),getCategory(),getDescription(),getPrice());
    }
}
