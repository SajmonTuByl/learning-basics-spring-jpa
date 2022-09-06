package com.example.learningbasicsspringjpa;

// Controller class handles HTTP requests

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // Annotation informs Spring that this is a controller
// Instead of @Controller, @RestController could be also used - @ResponseBody won't be necessary, as @RestController assumes it by default
@RequestMapping(path="/demo") //localhost:3306/demo/... All mappings will be available under this address.
public class RequestController {

    @Autowired //Spring will automatically create a userRepository Bean
    private UserRepository userRepository;

    // @ResponseBody // What a function returns will be transformed into a format suitable for REST app (e.g. JSON, XML).
    // It makes the returned value able to be display in the HTTP response, because normally JAVA objects cannot be displayed so simply.
    // A String value will be sent as a response, not a VIEW.
    // @ResponseBody == @RequestMapping(..., produces = MediaType.APPLICATION_JSON_VALUE)

    // @RequestMapping // Converts elements available for the HTTP request into objects types requested by a JAVA app (e.g. JSON, XML).
    @PostMapping(path="/add") // POST request
    //@RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody String addUser (@RequestParam(value = "username") String username, @RequestParam(value = "age") int age, @RequestParam(value = "city") String city){
        System.out.println("test1");
        User user = new User(username, age, city);
        userRepository.save(user);
        System.out.println("test2");
        return "A user has been added";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        System.out.println("test");
        return userRepository.findAll();
    }

}
