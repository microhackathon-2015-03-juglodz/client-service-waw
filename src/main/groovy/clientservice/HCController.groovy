package clientservice

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created by peter on 21/03/15.
 */
@Slf4j
@RestController
@TypeChecked
class HCController {
    @RequestMapping(
            value = '/hc',
            method = GET)
    String healthCheck() {
        return "1"
    }

}
