package top.lileix.generator.model.java;

import top.lileix.generator.core.MySQLTypeCast;
import top.lileix.generator.model.db.DBFieldModel;
import top.lileix.generator.util.StringUtil;

/**
 * Created by lilei on 2017/2/25.
 */
public class FieldModel {
    //字段名称
    private String dbFieldName;

    //字段名称
    private String fieldName;
    //字段类型
    private String fieldType;
    //是否是主键
    private boolean  primaryKey;

    private String comment;

    public FieldModel(DBFieldModel fieldModel) {
        this.dbFieldName =fieldModel.getField();
        this.fieldName = StringUtil.camelName(fieldModel.getField());
        this.fieldType = MySQLTypeCast.processJavaType(fieldModel.getType());
        this.primaryKey = fieldModel.getKey().equalsIgnoreCase("PRI");
        this.comment = fieldModel.getComment();
    }


    public FieldModel() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public void setDbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
