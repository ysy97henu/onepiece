package com.yinsy.onepiece.common.jpa.autoProduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableInfoRepository extends JpaRepository<TableInfo, Long> {

    @Query(value = "SELECT column_name,data_type,column_comment,column_key,extra FROM information_schema.COLUMNS WHERE table_name = ?1", nativeQuery = true)
    List<TableInfo> findTableInfo(String tableName);
}
