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

}

