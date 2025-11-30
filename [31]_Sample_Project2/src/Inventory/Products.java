package Inventory;

import javax.swing.JOptionPane;

public class Products {
	 // defaults
	public final String DEFAULT_NAME = "Unnamed";
    public final double DEFAULT_PRICE = 1;
    public final int DEFAULT_QUANTITY = 0;
    
    // fields
    private String name;
    private double price;
    private int quantity;
    
    
    // getters and setters
    public String getName() {
    	return this.name;
    }
    public void setName(String n) {
    	this.name = n;
    }
    
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double p) {
    	if(p < 0) {
    		JOptionPane.showMessageDialog(null, 
                    "Insert Failed", 
                    "price cant be negative", 
                    JOptionPane.PLAIN_MESSAGE);
    		
    	}
    	else {
    		this.price = p;
    	}
        
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int q) {
        this.quantity = q;
    }

    
    // constructors
    public Products() {
        setName(DEFAULT_NAME);
        setPrice(DEFAULT_PRICE);
        setQuantity(DEFAULT_QUANTITY);
    }
    public Products(String n, double p, int q) {
        setName(n);
        setPrice(p);
        setQuantity(q);
    }
    
 
}
