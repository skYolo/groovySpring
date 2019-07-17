package jcg.zheng.demo.groovyspring.component

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

import groovy.json.JsonSlurper
import groovy.transform.Memoized
import jcg.zheng.demo.groovyspring.model.GCountry
import jcg.zheng.demo.groovyspring.model.GResponseWrapper
import jcg.zheng.demo.groovyspring.model.GState

@Component
class AddressService {
	@Value('${AddressService.HostUrl}')
	private String serviceHostUrl

	private String countryPath = "/country/get/all"

	private String statePath = "/state/get/"


	private static final Logger logger = LoggerFactory.getLogger(AddressService.class)

	@Memoized
	List<GState> getStates(String countryCode){
		List<GState> states = new ArrayList<>()
		String getResult = new URL(serviceHostUrl + statePath + countryCode + "/all").text
		logger.debug( "getStates called rest service.")
		def jsonMap = new JsonSlurper().parseText(getResult)

		GResponseWrapper rep = new GResponseWrapper(jsonMap)
		return rep.getRestResponse().getResult()
	}

	@Memoized
	List<GCountry> getCountries(){
		List<GCountry> countryList = new ArrayList<>()
		String getResult = new URL(serviceHostUrl + countryPath).text
		logger.debug( "getCountries called rest service.")
		def jsonMap = new JsonSlurper().parseText(getResult)

		GResponseWrapper rep = new GResponseWrapper(jsonMap)
		
		return rep.getRestResponse().getResult()
	}
}
