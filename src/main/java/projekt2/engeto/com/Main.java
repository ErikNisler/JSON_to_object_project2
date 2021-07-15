package projekt2.engeto.com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import java.net.URI;
import java.net.http.*;
import java.text.ParseException;

import java.util.*;

@RestController
public class Main {
    static StateList stateList = new StateList();
    static Map<String, State> map = new HashMap<>();

    public static void main(String... args) throws IOException, ParseException, InterruptedException {
        boolean isIn = false;
        int count = 0;

        /**1. Zavolat API pomocí HTTP*/
        /**2. Načíst JSON soubor*/

        CallApiByHttp callApiByHttp = new CallApiByHttp();
        callApiByHttp.start();

        /**4. Implementovat vyhledávací logiku
         * 5. Vypsat hodnoty pomocí interaktivní příkazové řádky*/

        /*Sorted by standard rate*/
        stateList.sort();

        System.out.println("MIN");
        stateList.firstThreeMins();

        System.out.println("MAX");
        stateList.firstThreeMaxes();

        /**6. Uložit do souboru*/

        stateList.saveIntoFile("vypis.txt");

        /**Bonus 1 - Následně pak také implementovat vyhledávání daňových sazeb podle zkratek zemí, které bude uživatel zadávat do konzole.*/


        while (count != 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zadej symbol země a já ti zadám její daňové sazby, pro konec stiskni Enter: ");
            String input = scanner.nextLine();

            if (input.isEmpty()){
                count++;
            }
            else {
                for (HashMap.Entry<String, State> entry : map.entrySet()) {
                    if (entry.getKey().equals(input)) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                        isIn = true;
                    }
                }
            }
            if (!isIn) {
                System.out.println("Chybné zadání zkratky země!");
            }
        }

    }

    /**3. Naparsovat JSON soubor do objektu*/

    public static String parse(String responseBody) {

         ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode tree = mapper.readTree(responseBody);

            JsonNode atNode = tree.at("/rates/AT"); JsonNode beNode = tree.at("/rates/BE"); JsonNode bgNode = tree.at("/rates/BG");
            JsonNode cyNode = tree.at("/rates/CY"); JsonNode czNode = tree.at("/rates/CZ"); JsonNode dkNode = tree.at("/rates/DK");
            JsonNode deNode = tree.at("/rates/DE"); JsonNode eeNode = tree.at("/rates/EE"); JsonNode elNode = tree.at("/rates/EL");
            JsonNode grNode = tree.at("/rates/GR"); JsonNode esNode = tree.at("/rates/ES"); JsonNode fiNode = tree.at("/rates/FI");
            JsonNode frNode = tree.at("/rates/FR"); JsonNode hrNode = tree.at("/rates/HR"); JsonNode itNode = tree.at("/rates/IT");
            JsonNode lvNode = tree.at("/rates/LV"); JsonNode ltNode = tree.at("/rates/LT"); JsonNode luNode = tree.at("/rates/LU");
            JsonNode huNode = tree.at("/rates/HU"); JsonNode ieNode = tree.at("/rates/IE"); JsonNode mtNode = tree.at("/rates/MT");
            JsonNode nlNode = tree.at("/rates/NL"); JsonNode plNode = tree.at("/rates/PL"); JsonNode ptNode = tree.at("/rates/PT");
            JsonNode roNode = tree.at("/rates/RO"); JsonNode siNode = tree.at("/rates/SI"); JsonNode skNode = tree.at("/rates/SK");
            JsonNode seNode = tree.at("/rates/SE"); JsonNode ukNode = tree.at("/rates/UK"); JsonNode gbNode = tree.at("/rates/GB");

            State atState = mapper.treeToValue(atNode, State.class); stateList.addState(atState); map.put("AT",atState);
            State beState = mapper.treeToValue(beNode, State.class); stateList.addState(beState); map.put("BE",beState);
            State bgState = mapper.treeToValue(bgNode, State.class); stateList.addState(bgState); map.put("BG",bgState);
            State cyState = mapper.treeToValue(cyNode, State.class); stateList.addState(cyState); map.put("CY",cyState);
            State czState = mapper.treeToValue(czNode, State.class); stateList.addState(czState); map.put("CZ",czState);
            State dkState = mapper.treeToValue(dkNode, State.class); stateList.addState(dkState); map.put("DK",dkState);
            State deState = mapper.treeToValue(deNode, State.class); stateList.addState(deState); map.put("DE",deState);
            State eeState = mapper.treeToValue(eeNode, State.class); stateList.addState(eeState); map.put("EE",eeState);
            State elState = mapper.treeToValue(elNode, State.class); stateList.addState(elState); map.put("EL",elState);
            State grState = mapper.treeToValue(grNode, State.class); stateList.addState(grState); map.put("GR",grState);
            State esState = mapper.treeToValue(esNode, State.class); stateList.addState(esState); map.put("ES",esState);
            State fiState = mapper.treeToValue(fiNode, State.class); stateList.addState(fiState); map.put("FI",fiState);
            State frState = mapper.treeToValue(frNode, State.class); stateList.addState(frState); map.put("FR",frState);
            State hrState = mapper.treeToValue(hrNode, State.class); stateList.addState(hrState); map.put("HR",hrState);
            State itState = mapper.treeToValue(itNode, State.class); stateList.addState(itState); map.put("IT",itState);
            State lvState = mapper.treeToValue(lvNode, State.class); stateList.addState(lvState); map.put("LV",lvState);
            State ltState = mapper.treeToValue(ltNode, State.class); stateList.addState(ltState); map.put("LT",ltState);
            State luState = mapper.treeToValue(luNode, State.class); stateList.addState(luState); map.put("LU",luState);
            State huState = mapper.treeToValue(huNode, State.class); stateList.addState(huState); map.put("HU",huState);
            State ieState = mapper.treeToValue(ieNode, State.class); stateList.addState(ieState); map.put("IE",ieState);
            State mtState = mapper.treeToValue(mtNode, State.class); stateList.addState(mtState); map.put("MT",mtState);
            State nlState = mapper.treeToValue(nlNode, State.class); stateList.addState(nlState); map.put("NL",nlState);
            State plState = mapper.treeToValue(plNode, State.class); stateList.addState(plState); map.put("PL",plState);
            State ptState = mapper.treeToValue(ptNode, State.class); stateList.addState(ptState); map.put("PT",ptState);
            State roState = mapper.treeToValue(roNode, State.class); stateList.addState(roState); map.put("RO",roState);
            State siState = mapper.treeToValue(siNode, State.class); stateList.addState(siState); map.put("SI",siState);
            State skState = mapper.treeToValue(skNode, State.class); stateList.addState(skState); map.put("SK",skState);
            State seState = mapper.treeToValue(seNode, State.class); stateList.addState(seState); map.put("SE",seState);
            State ukState = mapper.treeToValue(ukNode, State.class); stateList.addState(ukState); map.put("UK",ukState);
            State gbState = mapper.treeToValue(gbNode, State.class); stateList.addState(gbState); map.put("GB",gbState);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
