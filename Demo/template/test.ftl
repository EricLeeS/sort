package ${packageName};

<#list importList as import>
import ${import};
</#list>

public  class ${class.className} extends ${class.superClass}{
	private ${class.field.type} ${class.field.name} = ${class.field.value};
	
}