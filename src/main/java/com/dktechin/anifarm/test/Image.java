package com.dktechin.anifarm.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Image {
    @RequestMapping(value = "/image", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept=application/json"})
    public HashMap<String, Object> image(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            System.out.println(jsonInString);

            /* 발화 들어온거 확인하기 */
            HashMap<String, Object> userRequest = (HashMap<String, Object>) params.get("userRequest");
            String utter = userRequest.get("utterance").toString().replace("\n", "");

            List<HashMap<String, Object>> outputs = new ArrayList<>();

            HashMap<String, Object> template = new HashMap<>();
            HashMap<String, Object> simpleImage = new HashMap<>();
            HashMap<String, Object> imageUrl = new HashMap<>();

            List<HashMap<String, Object>> quickReplies = new ArrayList<>();

            HashMap<String, Object> quickRepl = new HashMap<>();
            quickRepl.put("action", "message");
            quickRepl.put("label", "고양이");
            quickRepl.put("messageText", "고양이 사진입니다");
            quickReplies.add(quickRepl);

            HashMap<String, Object> quickRepl2 = new HashMap<>();
            quickRepl2.put("action", "message");
            quickRepl2.put("label", "개");
            quickRepl2.put("messageText", "개 사진입니다");
            quickReplies.add(quickRepl2);

            /* 발화 처리 부분 * */
            String rtnStr = "";
            if(utter.equals("고양이 사진입니다")){
                rtnStr ="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Cat_poster_1.jpg/600px-Cat_poster_1.jpg";
            }else if(utter.equals("개 사진입니다")) {
                rtnStr = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Coat_types_3.jpg/500px-Coat_types_3.jpg";
            }else{
                rtnStr = "shorturl.at/opDMS";
            }

            imageUrl.put("imageUrl", rtnStr);
            simpleImage.put("simpleImage", imageUrl);
            outputs.add(simpleImage);

            template.put("outputs", outputs);
            template.put("quickReplies", quickReplies);

            resultJson.put("version", "2.0");
            resultJson.put("template", template);

        } catch (Exception e) {

        }
        return resultJson;
    }
}