package com.qjx.hot.controller;

import com.qjx.hot.entrty.SearchEntrty;
import com.qjx.hot.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @author qjx
 */
@RestController
@RequestMapping(value = "hot" )
public class HotController {

    private final HotService service;

    @Autowired
    public HotController(HotService service) {
        this.service = service;
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(){
        return "Hi !!!!!";
    }

    @GetMapping(value = "/getAllHot")
    public ModelAndView getAllHotData(){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        List<SearchEntrty> allHot = service.getAllHot();
        model.addObject("data",allHot);
        model.addObject("status",200);
        model.addObject("msg","successful");
        return  model;
    }


    @GetMapping(value = "/getHotById")
    public ModelAndView getHotDataById(long id){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        SearchEntrty data = service.getHotById(id);
        model.addObject("msg","successful");
        model.addObject("data",data);
        model.addObject("status",200);
        return model;
    }


}
