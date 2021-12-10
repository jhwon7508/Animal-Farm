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
public class Sound {
    @RequestMapping(value = "/sound", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept=application/json"})
    public HashMap<String, Object> sound(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

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
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();

            List<HashMap<String, Object>> quickReplies = new ArrayList<>();

            HashMap<String, Object> quickRepl = new HashMap<>();
            quickRepl.put("action", "message");
            quickRepl.put("label", "고양이");
            quickRepl.put("messageText", "고양이 소리는?");
            quickReplies.add(quickRepl);

            HashMap<String, Object> quickRepl2 = new HashMap<>();
            quickRepl2.put("action", "message");
            quickRepl2.put("label", "개");
            quickRepl2.put("messageText", "개 소리는?");
            quickReplies.add(quickRepl2);

            HashMap<String, Object> quickRepl3 = new HashMap<>();
            quickRepl3.put("action", "message");
            quickRepl3.put("label", "돼지");
            quickRepl3.put("messageText", "돼지 소리는?");
            quickReplies.add(quickRepl3);

            HashMap<String, Object> quickRepl4 = new HashMap<>();
            quickRepl4.put("action", "message");
            quickRepl4.put("label", "소");
            quickRepl4.put("messageText", "소 소리는?");
            quickReplies.add(quickRepl4);

            HashMap<String, Object> quickRepl5 = new HashMap<>();
            quickRepl5.put("action", "message");
            quickRepl5.put("label", "말");
            quickRepl5.put("messageText", "말 소리는?");
            quickReplies.add(quickRepl5);

            HashMap<String, Object> quickRepl6 = new HashMap<>();
            quickRepl6.put("action", "message");
            quickRepl6.put("label", "양");
            quickRepl6.put("messageText", "양 소리는?");
            quickReplies.add(quickRepl6);

            HashMap<String, Object> quickRepl7 = new HashMap<>();
            quickRepl7.put("action", "message");
            quickRepl7.put("label", "개구리");
            quickRepl7.put("messageText", "개구리 소리는?");
            quickReplies.add(quickRepl7);

            HashMap<String, Object> quickRepl8 = new HashMap<>();
            quickRepl8.put("action", "message");
            quickRepl8.put("label", "수탉");
            quickRepl8.put("messageText", "수탉 소리는?");
            quickReplies.add(quickRepl8);

            HashMap<String, Object> quickRepl9 = new HashMap<>();
            quickRepl9.put("action", "message");
            quickRepl9.put("label", "병아리");
            quickRepl9.put("messageText", "병아리 소리는?");
            quickReplies.add(quickRepl9);

            HashMap<String, Object> quickRepl10 = new HashMap<>();
            quickRepl10.put("action", "message");
            quickRepl10.put("label", "오리");
            quickRepl10.put("messageText", "오리 소리는?");
            quickReplies.add(quickRepl10);

            /* 발화 처리 부분 * */
            String rtnStr = "";
            if(utter.equals("고양이 소리는?")){
                rtnStr ="야옹";
            }else if(utter.equals("개 소리는?")){
                rtnStr ="멍멍";
            }else if(utter.equals("돼지 소리는?")){
                rtnStr ="꿀꿀";
            }else if(utter.equals("소 소리는?")){
                rtnStr ="음메";
            }else if(utter.equals("오리 소리는?")){
                rtnStr ="꽥꽥";
            }else if(utter.equals("말 소리는?")){
                rtnStr ="히이잉";
            }else if(utter.equals("양 소리는?")){
                rtnStr ="메헤에";
            }else if(utter.equals("수탉 소리는?")){
                rtnStr ="꼬끼오";
            }else if(utter.equals("병아리 소리는?")){
                rtnStr ="삐약삐약";
            }else if(utter.equals("개구리 소리는?")){
                rtnStr ="개굴개굴";
            }else{
                rtnStr="동물 리스트입니다";
            }
            /* 발화 처리 끝*/

            text.put("text", rtnStr);
            simpleText.put("simpleText", text);
            outputs.add(simpleText);

            template.put("outputs", outputs);
            template.put("quickReplies", quickReplies);

            resultJson.put("version", "2.0");
            resultJson.put("template", template);

        } catch (Exception e) {

        }
        return resultJson;
    }
}