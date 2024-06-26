package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/admin/category")
@Api(tags = "分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增的分类：{}",categoryDTO);

        categoryService.save(categoryDTO);

        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询:{}",categoryPageQueryDTO);

        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);

        return Result.success(pageResult);


    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteById(Long id){
        log.info("删除分类id：{}",id);
        categoryService.deleteById(id);

        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}",categoryDTO);

        categoryService.update(categoryDTO);

        return Result.success();

    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类状态")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("启用禁用分类状态和id：{}，{}",status,id);

        categoryService.startOrStop(status,id);


        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类，类型：{}",type);

        List<Category> list = categoryService.list(type);
        return Result.success(list);
     }

}
