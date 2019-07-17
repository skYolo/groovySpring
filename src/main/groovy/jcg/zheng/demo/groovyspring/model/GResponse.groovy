package jcg.zheng.demo.groovyspring.model;
import groovy.transform.*

@Canonical
class GResponse {
	List<String> messages

	List<Object> result
}
