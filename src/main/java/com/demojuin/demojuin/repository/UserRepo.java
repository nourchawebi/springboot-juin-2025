package com.demojuin.demojuin.repository;

import com.demojuin.demojuin.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    /* NAMED METHOD */
    List<UserEntity> findByUsernameAndEmailStartingWith(String username, String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
    /* JPQL METHOD */
    @Query("SELECT u from UserEntity u  WHERE u.username=?1 ")
    UserEntity findbyusernamejpql(String username );
    @Query(" SELECT CASE WHEN COUNT(u)>0 THEN true ELSE false end from UserEntity u WHERE u.username=:username")
    boolean existsByUsernamejpqlboolean(@Param("username")  String username);
/* SQL METHOD */
    @Query(value="SELECT * FROM users u WHERE  u.username=?1", nativeQuery = true)
    List<UserEntity> findbyusernamesqlnative(String username);
    @Query(value="SELECT  count(*) FROM users WHERE username:u",nativeQuery = true)
    boolean existsByUsernamesqlboolean(@Param("u")  String username);
    @Query(value="select * from users  where username like :cle%",nativeQuery = true)
    List<UserEntity> findbycle(@Param("cle") String un);
     @Query(value="select * from users where  email like %:domain%", nativeQuery = true)
    List<UserEntity> findbydomain(@Param("domain") String un);

}
