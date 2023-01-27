package sg.edu.nus.iss.app.ssftest.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssftest.model.Details;
import sg.edu.nus.iss.app.ssftest.model.Order;
import sg.edu.nus.iss.app.ssftest.model.PizzaOrder;
import sg.edu.nus.iss.app.ssftest.service.OrderService;

@Controller
@RequestMapping(path={"","/"})
public class PizzaController {
    
    @Autowired
    private OrderService oSvc;

    Order saveOrder = new Order();
    Integer price = 0;
    Double multiplier = 0.0;
    Double totalCost;
    Integer isRush;
    Double pizzaCost;

    @GetMapping
    public String showLanding(Model model){
        Order o = new Order();
        model.addAttribute("order", o);
        return "index";
    }


    @PostMapping(path="/pizza")
    public String postSelection(@Valid Order order, BindingResult bResult, Model model){
        if(bResult.hasErrors()){
            return "index";
        }
        saveOrder = order;
        Details d = new Details();
        model.addAttribute("details", d);
        return "details";
    }

    @PostMapping(path="/pizza/order")
    public String postOrder(@Valid Details details, BindingResult bResult, Model model){
        if(bResult.hasErrors()){
            return "details";
        }
        // calculate total cost
        this.calculateCost(model, saveOrder.getPizza(), saveOrder.getSize(), saveOrder.getQuantity(), details.getRush());

        PizzaOrder po = new PizzaOrder();

        po.setOrderId(generateID(8));
        po.setName(details.getName());
        po.setAddress(details.getAddress());
        po.setPhone(details.getPhone());
        po.setRush(details.getRush());
        po.setComments(details.getComments());
        po.setPizza(saveOrder.getPizza());
        po.setSize(saveOrder.getSize());
        po.setQuantity(saveOrder.getQuantity());
        po.setTotal(totalCost);
        po.setPizzaCost(pizzaCost);

        oSvc.save(po);
        model.addAttribute("po", po);
        return "confirmation";
    }

    public synchronized String generateID(int numOfChar){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numOfChar){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0,numOfChar);
    }
    
    public void calculateCost(Model model, String pizza, String size, Integer quantity, Boolean rush){

        if (pizza.equalsIgnoreCase("bella") || pizza.equalsIgnoreCase("marinara") || pizza.equalsIgnoreCase("spianatacalabrese")){
            price = 30;
        } else if (pizza.equalsIgnoreCase("margherita")){
            price = 22;
        } else if(pizza.equalsIgnoreCase("trioformaggio")){
            price = 25;
        }
    
        
        if (size.equalsIgnoreCase("sm")){
            multiplier = 1.0;
        } else if (size.equalsIgnoreCase("md")){
            multiplier = 1.2;
        } else if(size.equalsIgnoreCase("lg")){
            multiplier = 1.5;
        }

        if (rush == true){
            isRush = 2;
        } else{
            isRush = 0;
        }
        //add quantity
        pizzaCost = price * multiplier * quantity; 
        totalCost = price * multiplier * quantity + isRush;
        System.out.println(price);
        System.out.println(multiplier);
        System.out.println(quantity);
        System.out.println(totalCost);
    }
}   

