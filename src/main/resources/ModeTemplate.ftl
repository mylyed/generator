@Entity
@Table(name="${classMode.tableName}")
/**
* ${classMode.comment}
*/
public class ${classMode.className} {
<#list  classMode.fieldModels as fieldModel>
    <#if fieldModel.comment!=''>
    /** ${fieldModel.comment} **/
    </#if>
    <#if fieldModel.primaryKey>
    @Id
    @GeneratedValue
    </#if>
    @Column(name="${fieldModel.dbFieldName}")
    private ${fieldModel.fieldType} ${fieldModel.fieldName};


</#list>

<#list  classMode.fieldModels as fieldModel>
        public ${fieldModel.fieldType} get${fieldModel.fieldName?cap_first}() {
            return ${fieldModel.fieldName};
        }

        public void set${fieldModel.fieldName?cap_first}(String ${fieldModel.fieldName}) {
            this.${fieldModel.fieldName} = ${fieldModel.fieldName};
        }

</#list>


}

