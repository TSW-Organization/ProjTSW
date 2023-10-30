package it.unisa.bean;

import java.io.Serializable;

public class CartItem extends Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int selectedQuantity;
	private int cartId;
	private int productId;
	
	
	
	public int getSelectedQuantity() {
		return selectedQuantity;
	}

	public void setSelectedQuantity(int selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}

	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	/*
	int selectedQuantity;
	
	public CartItem(Product product, int selectedQuantity) {
        super(product.getId(), product.getName(), product.getPrice(), product.getSeller(),
              product.getImgSrc(), product.getCategory(), product.getQuantity(),
              product.getFavorites(), product.getListingDate(), product.getDescription());

        this.selectedQuantity = selectedQuantity;
    }
	
	
	public int getSelectedQuantity() {
		return selectedQuantity;
	}
	
	public void setSelectedQuantity(int selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}
	*/
}
