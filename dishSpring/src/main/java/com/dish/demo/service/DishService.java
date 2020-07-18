package com.dish.demo.service;

import java.util.List;

import com.dish.demo.entity.Dish;

/**
 * @author 肖远航
 */
public interface DishService {

    /**
     * 获取区域列表
     *
     * @return
     */
    List<Dish> getDishList();

    /**
     * 通过区域Id获取区域信息
     *
     * @param
     * @return
     */
    Dish getDishById(int dishId);

    /**
     * 增加区域信息
     *
     * @param dish
     * @return
     */
    boolean addDish(Dish dish);

    /**
     * 修改区域信息
     *
     * @param dish
     * @return
     *//*
    boolean modifyDish(Dish dish);

    *//**
     * 删除区域信息
     *
     * @param
     * @return
     */
    boolean deleteDish(int dishId);

}
