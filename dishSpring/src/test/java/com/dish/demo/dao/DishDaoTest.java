package com.dish.demo.dao;

import com.dish.demo.entity.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishDaoTest {
    @Autowired
    private DishDao dishDAO;

    @Test
    public void queryDish() {
        List<Dish> dishList = dishDAO.queryDish();
        // 验证预期值和实际值是否相符
        assertEquals(6, dishList.size());
    }

    @Test
    public void queryDishById() {
        Dish dish =dishDAO.queryDishById(1);
        assertEquals("东苑", dish.getDishName());
    }

    /*@Test
    public void insertDish() {
        Dish dish =new Dish();
        dish.setDishName("南苑");
        dish.setPriority(1);
        int effectedNum=dishDAO.insertDish(dish);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateArea() {
        Dish dish =new Dish();
        dish.setDishName("西苑");
        dish.setDishId(3);
        dish.setLastEditTime(new Date());
        int effectedNum=dishDAO.updateDish(dish);
        assertEquals(1,effectedNum);
    }*/

    @Test
    public void deleteDish() {
        int effctedNum=dishDAO.deleteDish(3);
        assertEquals(1,effctedNum );
    }
}