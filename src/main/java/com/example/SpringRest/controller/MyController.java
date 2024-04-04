package com.example.SpringRest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class MyController {
    static ArrayList<String> nums=new ArrayList<String>();
    @GetMapping
    public List test()
    {
        return nums; //"Hello World";
    }

    @PostMapping
    public String postapitest(@RequestBody String name)
    {
        nums.add(name);
        return "Added";//Post API   " + name;
    }

    @PutMapping("{index}")
    public String putapitest(@PathVariable int index,@PathVariable String name) {
        if (index <= nums.size() && index >= 0) {
            nums.set(index, name);
            return "value added";
        } else {
            //nums.set(1,name);
            return "false";
            //Put API  " + name;
        }
    }
    @DeleteMapping("{index}")
    public String deleteapitest(@PathVariable int index)
    {
        if(index<=nums.size() && index>=0)
        {
            nums.remove(index);
            return "value removed";
        }
        else {
            return "false";
        }
    }
}
