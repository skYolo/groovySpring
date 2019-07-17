package jcg.zheng.demo.groovyspring.component

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import groovy.time.TimeCategory
import groovy.time.TimeDuration

import jcg.zheng.demo.groovyspring.component.AddressService
import jcg.zheng.demo.groovyspring.model.*

@RunWith(SpringRunner.class)
@SpringBootTest
class AddressServiceTest {

	@Autowired
	private AddressService addressService

	@Test
	public void test_get_allcountries() {
		def timeStart = new Date()

		List<GCountry> countries = addressService.getCountries();

		def timeStop = new Date()

		countries = addressService.getCountries();

		def timeStop2 = new Date()

		TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
		TimeDuration duration2 = TimeCategory.minus(timeStop2, timeStop)

		println "Groovy first getCountries took " + duration
		println "Groovy second getCountries took " + duration2

		assertTrue(countries.size() == 249)
	}

	@Test
	public void test_get_USA_states() {
		def timeStart = new Date()

		List<GState> usStates = addressService.getStates("USA");

		def timeStop = new Date()

		usStates = addressService.getStates("USA");

		def timeStop2 = new Date()

		TimeDuration duration = TimeCategory.minus(timeStop, timeStart)

		TimeDuration duration2 = TimeCategory.minus(timeStop2, timeStop)

		println "Groovy second getStates took " + duration
		println "Groovy second getStates took " + duration2

		assertTrue(usStates.size() == 55)
	}
}
