package inc.droidstar.abcmall;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import inc.droidstar.abcmall.AbcmallShopDetails;

public interface AbcmallShopRepository extends CrudRepository<AbcmallShopDetails,String>{
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE AbcmallShopDetails SET available=:Available WHERE BusinessSpaceType=:BusinessSpaceType")
    void updateSpace(@Param("Available") String Available,@Param("BusinessSpaceType") String BusinessSpaceType);

    // @Query("SELECT Cost FROM AbcmallShopDetails WHERE BusinessSpaceType=:BusinessSpaceType")
    // String fetchByType(@Param("BusinessSpaceType")String BusinessSpaceType);

    @Query("SELECT duration,rentType,Cost FROM AbcmallShopDetails WHERE BusinessSpaceType=:BusinessSpaceType")
    Iterable<AbcmallShopDetails> getByType(@Param("BusinessSpaceType")String BusinessSpaceType);
}