package clientservice

import com.codahale.metrics.Counter
import com.codahale.metrics.MetricRegistry
import com.netflix.hystrix.HystrixCommand
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.json.JsonBuilder
import groovy.transform.TypeChecked
import groovy.util.logging.Log
import groovy.util.logging.Slf4j
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 * Created by peter on 21/03/15.
 */
@Slf4j
@RestController
@TypeChecked
class ClientController {
    @Autowired
    ServiceRestClient serviceRestClient;
    @Autowired
    MetricRegistry metricRegistry;

    @RequestMapping(value = "/api/client", method = POST, consumes = "application/json", produces = "application/json")
    ResponseEntity<Client> registerClient(@RequestBody Client client) {
        Counter clientsNumber = metricRegistry?.counter("clients.number")
        clientsNumber.inc();
        log.info "clients number " + clientsNumber.count
        String returned = serviceRestClient.forService("reporter")
                .post()
                .withCircuitBreaker(
                HystrixCommand.Setter.withGroupKey({ 'group_key' }),
                { 'Failed' })
                .onUrl('/api/client')
                .body(new JsonBuilder(client).toPrettyString())
                .withHeaders().contentTypeJson()
                .andExecuteFor().anObject().ofType(String)
        log.info "reporter return "+returned
        return new ResponseEntity<Client>(client, HttpStatus.OK)

    }


}
