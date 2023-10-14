package LolHistory.presentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @GetMapping("/{gameName}/{tagLine}")
    public String getInvocador (@PathVariable Map<String, String> pathVarsMap){
        String gameName  = pathVarsMap.get("gameName");
        String tagLine = pathVarsMap.get("tagLine");
        return "aquí el " + gameName + " " + tagLine;
    }

}
