package ${model.packageName};

<#list model.importList as import>
import ${import};
</#list>

<#if model.classModel??>
<@compress>
<#if model.classModel.javaDoc??>${model.classModel.javaDoc.toString()}</#if>
<#if model.classModel.annotation??>${model.classModel.annotation.toString()}</#if>
</@compress>

${model.classModel.getDeclaration()}{

<@compress>
<#list model.classModel.methodList as method>
<#if method.javaDoc??>${method.javaDoc.toString()}</#if>
<#if method.annotation??>${method.annotation.toString()}</#if>
${method.getDeclaration()};
</#list>
</@compress>

}
</#if>

