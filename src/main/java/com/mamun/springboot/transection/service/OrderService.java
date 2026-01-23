package com.mamun.springboot.transection.service;

import com.mamun.springboot.transection.entity.Product;
import com.mamun.springboot.transection.exception.DataAccessError;
import com.mamun.springboot.transection.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    @Transactional
    public void placeOrder(long pid, int qnt){
        //some logic are skiped here
        try{
            Product product = productRepository.findById(pid).orElseThrow();
            var updatedStock = product.getStock()-qnt;
            product.setStock(updatedStock);   // even we commented the save method but it will still update the db.
                        // as while we set the data it hold data on cache and after
                        // the execution of method there is automatically update will be call for data flash.
            //productRepository.save(product);
            productRepository.flush();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.err.println("Error: "+ex.getMessage());   // this will be for log but not for user.
            throw new DataAccessError("Error occurred while placing order!");
        }
    }
}
