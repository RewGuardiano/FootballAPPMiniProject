package MiniProject;

import java.io.Serializable;

/**
 * This is instantiable class which defines a Ticket
 * @author Rewinell
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
    /**
     * 5-arguments constructor
     * @param  name The name of the person who set the ticket
     * @param email The email of the person
     * @param  category of the ticket
     * @param  description of the Ticket seats
     * @param  price of the Ticket
     */
    public Ticket(String name,String email, String category, String description, double price) {
        setName(name);
        setEmail(email);
        setCategory(category);
        setDescription(description);
        setPrice(price);

    }

    /**
     * Accessor method to return the name of the person who set the ticket.
     * @return the name of person who set the ticket.
     */

    public String getName() {
        return name;
    }

    /**
     *Mutator method to set the name of the Ticket
     * @param name the name of the dish
     * @throws IllegalArgumentException in the case of no name entered
     */
    public void setName(String name) {
        if(name==null||name.equals(""))
            throw new IllegalArgumentException("The Ticket must have a Person's name assigned to it\n");
        this.name = name;

    }

    /**
     * Accessor method to return email of the person who set the Ticket.
     * @return the email of person setting the ticket.
     */

    public String getEmail() {
        return Email;
    }

    /**
     * Mutator method to set the person email who set the ticket
     * @param email the email of the ticket owner
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Accessor method of the ticket's category.
     */

    public String getCategory() {
        return Category;
    }

    /**
     * Mutator method to set the category of the ticket
     * the category has initialized values already
     */
    public void setCategory(String category) {
        this.Category = category;
    }

    /**
     *Accessor method to return the description of the ticket.
     * @return the description of the ticket.
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Mutator method to set the description of the ticket
     * @param description the description of the Ticket Seats.
     */

    public void setDescription(String description) {
        this.Description = description;
    }

    /**
     *Accessor method to return the price of the ticket.
     * @return The price of the ticket.
     */
    public double getPrice() {
        return Price;
    }

    /**
     *Mutator method to set the Price of the ticket.
     * @param price the price of the ticket
     * @throws IllegalArgumentException in the case if the price is invalid or zero.
     */
    public void setPrice(double price) {
        if(price<0)
            throw new IllegalArgumentException("The ticket price must be a positive number\n");
       this.Price = price;
    }

    /**
     * Method to get the state of a Book object
     * @return a String value of identifying the state of the ticket object.
     */
    public String toString() {
        return String.format("Name: %s\nCategory: %s\nDescription: %s\nPrice: %.2f\n",getName(),getCategory(),getDescription(),getPrice());
    }
}
