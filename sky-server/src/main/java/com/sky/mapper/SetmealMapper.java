package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from sky_take_out.setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /**
     * 根据id修改套餐
     * @param setmeal
     */
    void update(Setmeal setmeal);

    /**
     * 新增套餐
     * @param setmeal
     */
    void insert(Setmeal setmeal);

    /**
     * 根据id查询套餐
     *
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.setmeal where id = #{id};")
    Setmeal getByid(Long id);

    /**
     * 根据id删除套餐
     * @param setmealId
     */
    @Delete("delete from sky_take_out.setmeal where id = #{id};")
    void deleteById(Long setmealId);

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
}
