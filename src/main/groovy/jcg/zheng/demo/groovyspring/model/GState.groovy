package jcg.zheng.demo.groovyspring.model;

import groovy.transform.*

@Canonical
class GState {
	Long id
	String country
	String name
	String abbr
	String area
	String capital
	String largest_city
}
