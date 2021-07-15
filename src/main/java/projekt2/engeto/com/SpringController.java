package projekt2.engeto.com;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@RestController
public class SpringController {

    StateList stateList = new StateList();

    /**Bonus 2 - Vytvořte vlastní HTTP API, které vystaví danou funkcionalitu přes webový server (jak jsme si ukázali v lekci 12)*/

    @PostMapping("api/state")
    public State postState(@RequestBody State state){
        return state;
    }


}
