package tw.Final.FinalS1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.Final.FinalS1.model.CartItemsModel;
import tw.Final.FinalS1.model.CartModel;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsModel, Integer> {

	//新增此方法來根據 cartId 刪除 CartItemsssa
	void deleteByCartId(Long cartId);

	List<CartItemsModel> findByCartId(Long cartId);
}
