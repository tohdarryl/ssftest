package sg.edu.nus.iss.app.ssftest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.ssftest.model.PizzaOrder;
import sg.edu.nus.iss.app.ssftest.service.OrderService;

@RestController
@RequestMapping(path="/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaRestController {

    @Autowired
    private OrderService oSvc;

    @GetMapping(path = "{poId}")
    public ResponseEntity<String> getPizzaOrder(@PathVariable String poId)
            throws IOException {
        PizzaOrder po = oSvc.findById(poId);
        if (po == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Order" + poId + "not found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(po.toJSON().toString());
    }
}
