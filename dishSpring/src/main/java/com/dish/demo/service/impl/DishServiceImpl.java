package com.dish.demo.service.impl;

import java.util.Date;
import java.util.List;

import com.dish.demo.dao.DishDao;
import com.dish.demo.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dish.demo.dao.DishDao;
import com.dish.demo.service.DishService;

/**
 * @author 肖远航
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;

    @Override
    public List<Dish> getDishList() {
        // 返回所有的菜品信息
        return dishDao.queryDish();
    }

    @Override
    public Dish getDishById(int dishId) {
        return dishDao.queryDishById(dishId);
    }

    @Transactional(rollbackFor =Exception.class)
    @Override
    public boolean addDish(Dish dish) {
        // 空值判断，主要是判断areaName不为空
        if (dish.getDishName() != null && !"".equals(dish.getDishName())) {
            // 设置默认值
            /*dish.setProbability(0);
            dish.setCalorie(0);
            dish.setDescription("");*/
            try {
                int effectedNum = dishDao.insertDish(dish);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加菜品信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加菜品信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("菜品信息不能为空！");
        }
    }

    /*
    @Transactional(rollbackFor =Exception.class)
    @Override
    public boolean modifyDish(Dish dish) {
        // 空值判断，主要是areaId不为空
        if (dish.getDishId() != null && dish.getDishId() > 0) {
            // 设置默认值
            dish.setLastEditTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = dishDao.updateDish(dish);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }
    */

    @Transactional(rollbackFor =Exception.class)
    @Override
    public boolean deleteDish(int dishId) {
        if (dishId > 0) {
            try {
                // 删除区域信息
                int effectedNum = dishDao.deleteDish(dishId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
