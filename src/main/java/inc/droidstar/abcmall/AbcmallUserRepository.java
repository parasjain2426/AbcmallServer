package inc.droidstar.abcmall;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import inc.droidstar.abcmall.AbcmallUserdetails;

public interface AbcmallUserRepository extends CrudRepository<AbcmallUserdetails,Integer>{

    @Query("SELECT password FROM AbcmallUserdetails WHERE Username=:Username")
    String fetchUser(@Param("Username")String Username);

    @Query("SELECT UserType FROM AbcmallUserdetails WHERE Username=:Username")
    String fetchUserType(@Param("Username")String Username);

    @Query("SELECT FirstName,LastName,UserType,ContactNo,email,Address,BookFrom,BookTo,BusinessSpace FROM AbcmallUserdetails WHERE Username=:Username")
    Iterable<AbcmallUserdetails> userDetails(@Param("Username")String Username);

    @Query("SELECT FirstName,LastName,ContactNo,email,Address,BookFrom,BookTo,BusinessSpace FROM AbcmallUserdetails WHERE UserType=:UserType")
    Iterable<AbcmallUserdetails> allUserDetails(@Param("UserType")String UserType);

    @Query("SELECT BookTo FROM AbcmallUserdetails WHERE BusinessSpace=:BusinessSpace")
    String nextAvail(@Param("BusinessSpace")String BusinessSpace);

    @Transactional
    @Modifying
    @Query("UPDATE AbcmallUserdetails SET password=:password WHERE Username=:Username")
    void updatepass(@Param("Username")String Username,@Param("password")String password);

    @Transactional
    @Modifying
    @Query("UPDATE AbcmallUserdetails SET BusinessSpace=:BusinessSpace,BookFrom=:BookFrom,BookTo=:BookTo WHERE Username=:Username")
    void updatebook(@Param("Username")String Username,@Param("BusinessSpace")String BusinessSpace,@Param("BookFrom")String BookFrom,@Param("BookTo")String BookTo);
}