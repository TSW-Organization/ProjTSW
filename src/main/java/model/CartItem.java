package model;

import java.io.Serializable;

public class CartItem extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
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

}
