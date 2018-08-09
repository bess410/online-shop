package com.epam.andrei_sterkhov.online_shop;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class OnlineShopApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineShopApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(OnlineShopApplication.class, args);
	/*	CategoryService bean = run.getBean(CategoryService.class);
		List<Category> all = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
		    LOGGER.info("at the start");
			all = bean.findAll();
			LOGGER.info("at the end");
		}
		System.out.println("End" + all);*/
	}
}
