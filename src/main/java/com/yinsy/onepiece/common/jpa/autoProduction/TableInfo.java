package com.yinsy.onepiece.common.jpa.autoProduction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据库 列实体
 *
 * @author yinsongyuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "COLUMNS", schema = "information_schema", catalog = "")
public class TableInfo {
    @Id
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列类型
     */
    private String dataType;
    /**
     * 列描述
     */
    private String columnComment;
    private String columnKey;
    private String extra;
}
