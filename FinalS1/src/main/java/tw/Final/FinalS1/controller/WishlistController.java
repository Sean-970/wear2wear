package tw.Final.FinalS1.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.Final.FinalS1.dto.WishlistDto;
import tw.Final.FinalS1.model.WishlistItemsModel;
import tw.Final.FinalS1.model.WishlistModel;
import tw.Final.FinalS1.repository.UserRepository;
import tw.Final.FinalS1.repository.WishlistRepository;
import tw.Final.FinalS1.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	public WishlistService wishlistService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@PostMapping("/toggle")
	public ResponseEntity<WishlistModel> toggleWishlistItem(@RequestBody WishlistDto wishlistRequest) {
		Long wishlistId = wishlistRequest.getWishlistId();
        Long productId = wishlistRequest.getProductId();
        
        // 查找喜愛清單
        WishlistModel wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));

        // 檢查商品是否已存在於喜愛清單中
        boolean itemExists = wishlist.getWishlistItems().stream()
                .anyMatch(item -> Objects.equals(item.getProduct().getId(), productId));

        if (itemExists) {
            // 如果商品存在，則移除
            return ResponseEntity.ok(wishlistService.deleteWishlist(wishlistRequest));
        } else {
            // 如果商品不存在，則添加
            return ResponseEntity.ok(wishlistService.addTowishlist(wishlistRequest));
        }
    }
	

	@PostMapping("/add")
	public ResponseEntity<WishlistModel> addTowishlist(@RequestBody WishlistDto wishrequest) {
		try {

			WishlistModel addwishlist = wishlistService.addTowishlist(wishrequest);
			return ResponseEntity.ok(addwishlist);

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

//	@PostMapping("/update")
//	public ResponseEntity<WishlistModel> updateWishlist(@RequestBody WishlistDto wishrequest) {
//		try {
//
//			WishlistModel updateWishlist = wishlistService.updateWishlist(wishrequest);
//			return ResponseEntity.ok(updateWishlist);
//
//		} catch (RuntimeException e) {
//
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteWishlist(@RequestBody WishlistDto wishrequest) {
		try {

			WishlistModel deleteWishlist = wishlistService.deleteWishlist(wishrequest);
			return ResponseEntity.ok("Items successfully deleted");

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<List<WishlistItemsModel>> getWishlistItems(@PathVariable Long id){
		
		List<WishlistItemsModel> wishlistItems = wishlistService.getWishlistItems(id);
		
		return ResponseEntity.ok(wishlistItems);
	}
	
	

}
