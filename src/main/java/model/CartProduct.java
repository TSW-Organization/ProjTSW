package model;

import java.io.Serializable;

public class CartProduct extends Product implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private int cartProductQuantity;
	
	
    public CartProduct() {
        
    }
    
    public int getQuantity() {
    	return cartProductQuantity;
    }
    
    public void setQuantity(int cartProductQuantity) {
    	this.cartProductQuantity =  cartProductQuantity;
    }
    

}