package clientservice

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
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

    @RequestMapping(value = "/api/client", method = POST, consumes = "application/json")
    ResponseEntity<Client> registerClient(@RequestBody Client client) {


        return new ResponseEntity<Client>(client, HttpStatus.OK)

    }


}
