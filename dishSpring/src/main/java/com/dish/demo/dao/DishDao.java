package com.dish.demo.dao;

import java.util.List;

import com.dish.demo.entity.Dish;

/**
 * @author 肖远航
 */
public interface DishDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Dish> queryDish();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Dish queryDishById(int dishId);

    /**
     * 插入区域信息
     *
     * @param dish
     * @return
     */
    int insertDish(Dish dish);

    /**
     * 更新区域信息
     *
     * @param dish
     * @return
     */
    int updateDish(Dish dish);

    /**
     * 删除区域信息
     */
    int deleteDish(int dishId);
}
