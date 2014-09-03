import spock.lang.Specification

class AddSpec extends Specification {

    def "should add 2 numbers"() {
        expect:
        2 == new Adder().add([1,1])
    }

}
