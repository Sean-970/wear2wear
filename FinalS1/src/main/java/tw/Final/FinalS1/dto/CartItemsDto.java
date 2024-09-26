package tw.Final.FinalS1.dto;

public class CartItemsDto {
	    private Long cartId;           // 购物车 ID
	    private Long variantId;    // 产品变体 ID
	    private int quantity;      // 数量

	    // Getters 和 Setters
	    public Long getId() {
	        return cartId;
	    }

	    public void setId(Long cartId) {
	        this.cartId = cartId;
	    }

	    public Long getVariantId() {
	        return variantId;
	    }

	    public void setVariantId(Long variantId) {
	        this.variantId = variantId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	}
