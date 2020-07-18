package com.dish.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dish.demo.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.dish.demo.service.DishService;

@RestController    // @Controller  和 @ResponseBody的结合
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/listdish", method = RequestMethod.GET)
    private Map<String, Object> listDish() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Dish> list = new ArrayList<Dish>();
        // 获取区域列表
        list = dishService.getDishList();
        modelMap.put("dishlist", list);
        return modelMap;
    }

    /**
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getdishbyid", method = RequestMethod.GET)
    private Map<String, Object> getDishById(Integer dishId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Dish dish = dishService.getDishById(dishId);
        modelMap.put("dish", dish);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param
     * @param
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/adddish", method = RequestMethod.POST)
    private Map<String, Object> addDish(@RequestBody Dish dish)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", dishService.addDish(dish));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     *
     * @param
     * @param
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     *//*
    @RequestMapping(value = "/modifydish", method = RequestMethod.POST)
    private Map<String, Object> modifyDish(@RequestBody Dish dish)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", dishService.modifyDish(dish));
        return modelMap;
    }*/

    @RequestMapping(value = "/removedish", method = RequestMethod.GET)
    private Map<String, Object> removeDish(Integer dishId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", dishService.deleteDish(dishId));
        return modelMap;
    }

}
