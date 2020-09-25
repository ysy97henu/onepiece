package com.yinsy.onepiece.common.jpa.autoProduction;

import com.yinsy.onepiece.common.base.BaseResponse;
import com.yinsy.onepiece.common.jpa.autoProduction.serviceImpl.TableInfoServiceImpl;
import com.yinsy.onepiece.common.util.ExtendStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpa")
public class TableInfoController {

    @Autowired
    private TableInfoServiceImpl tableInfoServiceImpl;

    /**
     * JPA模板创建
     *
     * @param tableName 表名
     * @param moduleName 模块名称
     * @author yinsongyuan
     * @return 响应实体
     */
    @GetMapping("generate")
    public BaseResponse generateJpaTemplate(String tableName, String moduleName){
        System.out.println("接口正常");
        if(ExtendStringUtils.isEmpty(tableName) || ExtendStringUtils.isEmpty(moduleName)){
            return new BaseResponse(201,"参数错误");
        }
        tableInfoServiceImpl.generateJpaTemplate(tableName, moduleName);
        return new BaseResponse();
    }
}
