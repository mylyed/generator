package top.lileix.generator;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import top.lileix.generator.model.java.ClassMode;
import top.lileix.generator.model.java.FieldModel;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lilei on 2017/2/25.
 */
public class App {
    public static void main(String[] args) throws SQLException, IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(App.class.getClassLoader().getResource("").getPath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template temp = cfg.getTemplate("ModeTemplate.ftl");
        DBUtil dbUtil = new DBUtil();
        dbUtil.getAllTables(dbUtil.getConnection()).forEach(t -> {
            ClassMode classMode = new ClassMode(t);
            List<FieldModel> fieldModels = new ArrayList<FieldModel>();
            try {
                dbUtil.getFields(dbUtil.getConnection(), t).forEach(
                        f -> {
                            FieldModel fieldModel = new FieldModel(f);
                            fieldModels.add(fieldModel);
                        }
                );
                classMode.setFieldModels(fieldModels);
                System.out.println(JSONObject.toJSONString(classMode,true));

                Writer out = new OutputStreamWriter(System.out);
                Map root = new HashMap();
                root.put("classMode", classMode);
                temp.process(root, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dbUtil.getConnection().close();


    }

}
