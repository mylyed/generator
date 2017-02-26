package top.lileix.generator.model.java;

import top.lileix.generator.model.db.TableModel;
import top.lileix.generator.util.StringUtil;

import java.util.List;

/**
 * Created by lilei on 2017/2/26.
 */
public class ClassMode {
    private String className;
    private String tableName;
    private String comment;
    List<FieldModel> fieldModels;
    public ClassMode() {
    }

    public ClassMode(TableModel tableModel) {
        String tempStr=StringUtil.camelName(tableModel.getName());
        this.className =tempStr.substring(0,1).toUpperCase()+tempStr.substring(1);
        this.tableName = tableModel.getName();
        this.comment = tableModel.getComment();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<FieldModel> getFieldModels() {
        return fieldModels;
    }

    public void setFieldModels(List<FieldModel> fieldModels) {
        this.fieldModels = fieldModels;
    }
}
