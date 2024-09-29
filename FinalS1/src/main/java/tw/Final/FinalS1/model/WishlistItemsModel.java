package tw.Final.FinalS1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist_items")
public class WishlistItemsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "wishlist_id")
	@JsonBackReference
	private WishlistModel wishlist;
	
	@ManyToOne
	@JoinColumn(name = "product_variant_id")
	private ProductVariant productVariant;
	
	
	public Long getId() {
		return id;
	} 
	public void setId(Long id) {
		this.id = id;
	}
	public WishlistModel getWishlist() {
		return wishlist;
	}
	public void setWishlist(WishlistModel wishlist) {
		this.wishlist = wishlist;
	}
	public ProductVariant getProductVariant() {
		return productVariant;
	}
	public void setProductVariant(ProductVariant productVariant) {
		this.productVariant = productVariant;
	}
	
}