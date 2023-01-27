package sg.edu.nus.iss.app.ssftest.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.ssftest.model.PizzaOrder;

@Service
public class OrderService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void save(final PizzaOrder po){
        System.out.println("po " + po.toJSON().toString());
        redisTemplate.opsForValue().set(po.getOrderId(), po.toJSON().toString());
    }

    public PizzaOrder findById(final String poId) throws IOException{
        String poStr = (String)redisTemplate.opsForValue().get(poId);
        PizzaOrder p = PizzaOrder.create(poStr);
        return p;
    }
}
