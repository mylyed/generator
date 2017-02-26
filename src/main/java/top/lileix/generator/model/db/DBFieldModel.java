package top.lileix.generator.model.db;

/**
 * 数据库字段
 * Created by lilei on 2017/2/25.
 */
public class DBFieldModel {
    //字段名
    private String field;
    //字段类型
    private String type;
    //是否运允许为空
    private String allowNull;
    //是否为主键
    private String key;

    private String extra;
    //注释
    private String comment;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAllowNull() {
        return allowNull;
    }

    public void setAllowNull(String allowNull) {
        this.allowNull = allowNull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "DBFieldModel{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", allowNull='" + allowNull + '\'' +
                ", key='" + key + '\'' +
                ", extra='" + extra + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
