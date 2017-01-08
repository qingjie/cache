package com.qingjie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingjie.domain.User;
import com.qingjie.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EHCacheApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CacheManager cacheManager;

	@Before
	public void before() {
		userRepository.save(new User("AAA", 10));
	}

	@Test
	public void tets() throws Exception {

		User u1 = userRepository.findByName("AAA");
		System.out.println("The first query: " + u1.getAge());

		User u2 = userRepository.findByName("AAA");
		System.out.println("The second query: " + u2.getAge());

		
		u1.setAge(20);
		userRepository.save(u1);
		User u3 = userRepository.findByName("AAA");
		System.out.println("The third query:" + u3.getAge());
		
		System.out.println("===================" + cacheManager.toString() + "------------");
	}

}
