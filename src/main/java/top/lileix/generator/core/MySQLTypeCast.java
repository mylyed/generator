package top.lileix.generator.core;

/**
 * Created by lilei on 2017/2/26.
 */
public class MySQLTypeCast {
    public static String processJavaType(String type) {
        type = type.toLowerCase();
        if (type.indexOf("char") > -1 || type.indexOf("text") > -1) {
//            CHAR         0-255字节          定长字符串
//            VARCHAR      0-255字节          变长字符串
            return "String";
        } else if (type.indexOf("bigint") > -1) {
//            BIGINT         8字节   (-9 233 372 036 854 775 808，9 223 372 036 854 775 807) (0，18 446 744 073 709 551 615) 极大整数值
            return "Long";
        } else if (type.indexOf("int") > -1) {
//            TINYINT        1字节        (-128，127)          (0，255)            小整数值
//            SMALLINT       2字节     (-32 768，32 767)       (0，65 535)         大整数值
//            MEDIUMINT      3字节    (-8 388 608，8 388 607) (0，16 777 215)      大整数值
//            INT或INTEGER   4字节   (-2 147 483 648，2 147 483 647) (0，4 294 967 295) 大整数值
            return "Integer";
        } else if (type.indexOf("float") > -1) {
            return "Float";
        } else if (type.indexOf("double") > -1) {
            return "Double";
        } else if (type.indexOf("date") > -1 || type.indexOf("time") > -1 || type.indexOf("year") > -1) {
            return "java.util.Date";
        } else if (type.indexOf("bit") > -1) {
            return "Boolean";
        } else if (type.indexOf("decimal") > -1) {
            return "java.math.BigDecimal";
        } else if (type.indexOf("blob") > -1) {
            return "byte[]";
        }
        return null;
    }

}
