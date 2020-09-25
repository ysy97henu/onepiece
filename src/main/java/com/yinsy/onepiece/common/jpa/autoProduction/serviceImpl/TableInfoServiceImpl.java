package com.yinsy.onepiece.common.jpa.autoProduction.serviceImpl;

import com.yinsy.onepiece.common.jpa.autoProduction.TableInfo;
import com.yinsy.onepiece.common.jpa.autoProduction.TableInfoRepository;
import com.yinsy.onepiece.common.util.ExtendStringUtils;
import com.yinsy.onepiece.common.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class TableInfoServiceImpl {

    @Autowired
    private TableInfoRepository tableInfoRepository;

    // 项目路径相关常量
    // 获取根目录
    public static final String BASE_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\";
    // 个人项目路径
    public static final String SELF_PATH = "com\\yinsy\\onepiece\\";
    /**
     * 根据库表创建 相关实体
     *
     * @param tableName 数据库表名称
     * @param moduleName 模块名称
     * @Version 1.0 仅支持JPA
     * @author yinsongyuan
     */
    public void generateJpaTemplate(String tableName, String moduleName) {
        // 获取列实体集合
        List<TableInfo> listTableInfo = getListTableInfo(tableName);
        // 字符串处理: 下划线 -> 首字母大写驼峰
        tableName = ExtendStringUtils.captureName(ExtendStringUtils.camelCaseName(tableName));
        // 获取路径
        String path = BASE_PATH + SELF_PATH + moduleName + "\\";
        // 创建实体类
        createEntity(listTableInfo, tableName, path, moduleName);
        // 创建DAO层
        createRepository(listTableInfo, tableName, path, moduleName);
        // 创建servicec层
        createService(tableName, path, moduleName);
        // 创建controller层
        createController(tableName, path, moduleName);
    }

    /**
     * 获取库表所有列
     *
     * @param tableName 库表名
     * @return 列集合 {@link TableInfo}
     */
    public List<TableInfo> getListTableInfo(String tableName) {
        return tableInfoRepository.findTableInfo(tableName);
    }

    /**
     * 创建实体类
     */
    public void createEntity(List<TableInfo> tableInfos, String tableName, String path, String moduleName) {
        File file = FileUtils.createFile(path + "entity\\" + tableName + ".java");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "package " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".entity;\n" +
                        "\n" +
                        "import lombok.Data;\n" +
                        "import javax.persistence.*;\n" +
                        "import java.sql.Timestamp;\n" +
                        "\n" +
                        "@Entity\n" +
                        "@Table\n" +
                        "@Data\n" +
                        "public class " + tableName + " {\n"
        );
        //遍历设置属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                stringBuffer.append("    @Id\n");
            }
            stringBuffer.append("    /**\n");
            stringBuffer.append("    * " + tableInfo.getColumnComment() + "\n");
            stringBuffer.append("    **/\n");
            stringBuffer.append("    private " + ExtendStringUtils.dataTypeToJavaType(tableInfo.getDataType()) + " " + ExtendStringUtils.camelCaseName(tableInfo.getColumnName()) + ";" + "\n\n");
        }
        stringBuffer.append("}");
        FileUtils.fileWriter(file, stringBuffer);
    }

    /**
     * 创建repository类
     */
    private void createRepository(List<TableInfo> tableInfos, String tableName, String path, String moduleName) {
        File file = FileUtils.createFile(path + "repository\\" + tableName + "Repository.java");
        StringBuffer stringBuffer = new StringBuffer();
        String t = "String";
        //遍历属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                t = ExtendStringUtils.dataTypeToJavaType(tableInfo.getDataType());
            }
        }
        stringBuffer.append(
                "package " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".repository;\n" +
                        "\n" +
                        "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                        "import org.springframework.stereotype.Repository;\n" +
                        "import " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".entity." +tableName+";\n" +
                        "\n" +
                        "@Repository\n" +
                        "public interface " + tableName + "Repository extends JpaRepository<" + tableName + ", " + t + "> {"
        );
        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtils.fileWriter(file, stringBuffer);
    }

    /**
     * 创建service类
     */
    private void createService(String tableName, String path, String moduleName) {
        File file = FileUtils.createFile(path + "service\\" + tableName + "Service.java");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "package " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".service;\n" +
                        "\n" +
                        "public interface " + tableName + "Service {"
        );
        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtils.fileWriter(file, stringBuffer);

        //Impl
        File file1 = FileUtils.createFile(path + "service\\impl\\" + tableName + "ServiceImpl.java");
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(
                "package " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".service.impl;\n" +
                        "\n" +
                        "import org.springframework.stereotype.Service;\n" +
                        "import " + SELF_PATH.replaceAll("\\\\", ".")+ moduleName + ".service."+tableName+"Service;\n" +
                        "\n" +
                        "@Service\n" +
                        "public class " + tableName + "ServiceImpl implements " + tableName + "Service {"
        );
        stringBuffer1.append("\n");
        stringBuffer1.append("}");
        FileUtils.fileWriter(file1, stringBuffer1);
    }

    /**
     * 创建controller类
     */
    private void createController(String tableName, String path, String moduleName) {
        File file = FileUtils.createFile(path + "controller\\" + tableName + "Controller.java");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "package " + SELF_PATH.replaceAll("\\\\", ".") + moduleName + ".controller;\n" +
                        "\n" +
                        "import org.springframework.web.bind.annotation.RestController;\n" +
                        "\n" +
                        "@RestController\n" +
                        "public class " + tableName + "Controller {"
        );
        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtils.fileWriter(file, stringBuffer);
    }
}
