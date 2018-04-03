package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

//        Assert.assertEquals(3, userRepository.findAll().size());
//        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));

        Assert.assertEquals("bb", userRepository.findByEmailLike("bb@126.com").get(0).getNickName());
        Assert.assertEquals("bb", userRepository.findByUserNameIgnoreCase("BB2").getNickName());
    }

    @Test
    public void testPageQuery() throws Exception {
        int page=1,size=1;
        Sort sort = new Sort(Sort.Direction.DESC, "UserName");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> users = userRepository.findAll(pageable);
        users.forEach(System.out::println);

        users =  userRepository.findByUserName("bb2", pageable);
        users.forEach(System.out::println);
    }

    @Test
    public void testAnnotationQuery() throws Exception {
        Assert.assertEquals("bb", userRepository.findByEmailAddress("bb@126.com").getNickName());
    }
}
