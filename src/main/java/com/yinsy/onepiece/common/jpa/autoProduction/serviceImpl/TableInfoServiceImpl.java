package com.yinsy.onepiece.common.jpa.autoProduction.serviceImpl;

import com.yinsy.onepiece.common.jpa.autoProduction.TableInfo;
import com.yinsy.onepiece.common.jpa.autoProduction.TableInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableInfoServiceImpl {

    @Autowired
    private TableInfoRepository tableInfoRepository;

    public List<TableInfo> getListTableInfo(String tableName){
        return tableInfoRepository.findTableInfo(tableName);
//        return null;
    }


}
