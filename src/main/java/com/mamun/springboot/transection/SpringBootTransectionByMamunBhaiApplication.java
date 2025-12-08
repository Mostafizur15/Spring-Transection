package com.mamun.springboot.transection;

import com.mamun.springboot.transection.service.AccountService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTransectionByMamunBhaiApplication implements CommandLineRunner {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EntityManagerFactory emf;
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
        System.out.println("HELLO");
		SpringApplication.run(SpringBootTransectionByMamunBhaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.moneyTransfer(1,2,500.00);
		/*EntityManager em = emf.createEntityManager();
		var tx = em.getTransaction();
		tx.begin();
		try{
			tx.commit();
		}catch (Exception e){
			tx.rollback();
		}*/
	}
}
