package tw.Final.FinalS1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.Final.FinalS1.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}