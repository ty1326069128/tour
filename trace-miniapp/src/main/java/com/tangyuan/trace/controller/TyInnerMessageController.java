package com.tangyuan.trace.controller;

import com.tangyuan.result.BaseQueryDTO;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import com.tangyuan.trace.entity.TyInnerMessageEntity;
import com.tangyuan.trace.service.logic.TyInnerMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author tangyuan
 * Date  2020-11-19
 */
@ResponseResult
@RestController
@RequestMapping(value = "/api/tyinnermessage")
public class TyInnerMessageController {
    @Resource
    private TyInnerMessageService tyInnerMessageService;

    /**
     * 保存/新增记录
     *
     * @param entity
     * @return
     */
    @PostMapping(path = "/save")
    public CommonDTO save(@RequestBody TyInnerMessageEntity entity) {
        return tyInnerMessageService.save(entity);
    }

    /**
     * 根据ID更新记录
     *
     * @param entity
     * @return int
     */
    @PutMapping(path = "/update")
    public CommonDTO update(@RequestBody TyInnerMessageEntity entity) {
        return tyInnerMessageService.update(entity);
    }

    /**
     * 根据Id删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/deleteById/{id}")
    public CommonDTO deleteById(@PathVariable Integer id) {
        return tyInnerMessageService.deleteById(id);
    }

    /**
     * 通过id获取记录
     *
     * @param id
     * @return DealInvoiceEntity
     */
    @GetMapping(value = "/findById/{id}")
    public CommonDTO findById(@PathVariable Integer id) {
        return tyInnerMessageService.findById(id);
    }

    /**
     * 通过条件分页查询
     *
     * @param queryDTO
     * @return
     */
    @RequestMapping(value = "/findPageByCondition", method = RequestMethod.GET)
    public CommonDTO findPageByCondition(@RequestBody BaseQueryDTO<TyInnerMessageEntity> queryDTO) {
        return tyInnerMessageService.findPageByCondition(queryDTO);
    }
}