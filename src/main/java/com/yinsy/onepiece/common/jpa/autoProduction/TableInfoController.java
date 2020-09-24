package com.yinsy.onepiece.common.jpa.autoProduction;

import com.yinsy.onepiece.common.base.BaseResponse;
import com.yinsy.onepiece.common.jpa.autoProduction.serviceImpl.TableInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jpa")
public class TableInfoController {

    @Autowired
    private TableInfoServiceImpl tableInfoServiceImpl;

    @GetMapping("generate")
    public BaseResponse generateJpaTemplate(String tableName){
        System.out.println("接口正常");
        return new BaseResponse<List<TableInfo>>(tableInfoServiceImpl.getListTableInfo(tableName));
    }
}
