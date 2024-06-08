package com.sky.service;

import com.sky.dto.SetmealDTO;

public interface SetmealService {
    /**
     * 新增分类
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);
}
