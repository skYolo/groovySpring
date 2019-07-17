package jcg.zheng.demo.groovyspring.model

import groovy.transform.*

@Canonical
class GDepartment {
	int id	
	List<GEmployee> employees

}
