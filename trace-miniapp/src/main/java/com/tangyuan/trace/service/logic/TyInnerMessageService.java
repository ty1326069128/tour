package com.tangyuan.trace.service.logic;

import com.github.pagehelper.Page;
import com.tangyuan.result.BaseQueryDTO;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.trace.entity.TyInnerMessageEntity;
import com.tangyuan.trace.facade.TyInnerMessageFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
* Author tangyuan
* Date  2020-11-19
*/
@Slf4j
@Service
public class TyInnerMessageService {

    @Resource
    private TyInnerMessageFacade tyInnerMessageFacade;

    /**
    * 添加
    *
    * @param entity
    * @return
    */
    @Transactional
    public CommonDTO save(TyInnerMessageEntity entity) {
        int row = tyInnerMessageFacade.save(entity);
        if (row > 0) {
            row = entity.getId();
        }
        return  CommonDTO.success(row);
    }

    /**
    * 更新
    *
    * @param entity
    * @return
    */
    @Transactional
    public CommonDTO update(TyInnerMessageEntity entity) {
        int row = tyInnerMessageFacade.update(entity);
        return  CommonDTO.success(row);
    }

    /**
    * 删除
    *
    * @param id
    * @return
    */
    @Transactional
    public CommonDTO deleteById(int id) {
        int row = tyInnerMessageFacade.deleteById(id);
         return  CommonDTO.success(row);
    }

    /**
    * 根据id查询
    *
    * @param id
    * @return
    */
    public CommonDTO findById(int id) {
        TyInnerMessageEntity entity = tyInnerMessageFacade.findById(id);
         return  CommonDTO.success(entity);
    }

    /**
    * 分页条件查询
    *
    * @param queryDTO
    * @return
    */
    public CommonDTO findPageByCondition(BaseQueryDTO<TyInnerMessageEntity> queryDTO) {

        Condition condition = getCondition(queryDTO.getCondition());

        Page<TyInnerMessageEntity> page = tyInnerMessageFacade.findPageByCondition(condition, queryDTO.getPageNo(), queryDTO.getPageSize());

        return CommonDTO.restPage(page);
    }

    //==================私有方法
    private Condition getCondition(TyInnerMessageEntity entity) {
        Condition condition = new Condition(TyInnerMessageEntity.class);
        if (entity != null) {
        Example.Criteria criteria = condition.createCriteria();
            //TODO 查询条件
        }
        return condition;
    }
}
