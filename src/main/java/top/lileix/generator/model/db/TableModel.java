package top.lileix.generator.model.db;

import java.util.List;

/**
 * Created by lilei on 2017/2/25.
 */
public class TableModel {
    //表名
    private String name;
    //注释
    private String comment;
    public TableModel() {
    }
    public TableModel(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
