package tw.Final.FinalS1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.Final.FinalS1.model.userInfoMedel;

@Repository
public interface UserInfoRepository extends JpaRepository<userInfoMedel, Integer> {
    
}
