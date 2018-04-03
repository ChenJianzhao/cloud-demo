package com.example.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    List<User> findByEmailLike(String email);

    User findByUserNameIgnoreCase(String userName);

    List<User> findByUserNameOrderByEmailDesc(String email);


    // 分页查询
//    Page<User> findAll(Pageable pageable);    //   父类方法

    Page<User> findByUserName(String userName,Pageable pageable);

    // 限制查询
    User findTopByOrderByUserNameDesc();

    Page<User> queryFirst10ByUserName(String userName, Pageable pageable);

    List<User> findFirst10ByUserName(String userName, Sort sort);

    List<User> findTop10ByUserName(String userName, Pageable pageable);

    // 自定义查询
    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int modifyByIdAndUserId(String  userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmailAddress(String email);
}