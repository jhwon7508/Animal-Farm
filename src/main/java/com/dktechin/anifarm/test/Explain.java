package com.dktechin.anifarm.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Explain {
    @RequestMapping(value = "/explain", method = {RequestMethod.POST, RequestMethod.GET}, headers = {"Accept=application/json"})
    public HashMap<String, Object> image(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            System.out.println(jsonInString);

            /* 발화 들어온거 확인하기 * */
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
            quickRepl.put("messageText", "고양이 설명");
            quickReplies.add(quickRepl);

            HashMap<String, Object> quickRepl2 = new HashMap<>();
            quickRepl2.put("action", "message");
            quickRepl2.put("label", "개");
            quickRepl2.put("messageText", "개 설명");
            quickReplies.add(quickRepl2);

            HashMap<String, Object> quickRepl3 = new HashMap<>();
            quickRepl3.put("action", "message");
            quickRepl3.put("label", "돼지");
            quickRepl3.put("messageText", "돼지 설명");
            quickReplies.add(quickRepl3);

            HashMap<String, Object> quickRepl4 = new HashMap<>();
            quickRepl4.put("action", "message");
            quickRepl4.put("label", "소");
            quickRepl4.put("messageText", "소 설명");
            quickReplies.add(quickRepl4);

            HashMap<String, Object> quickRepl5 = new HashMap<>();
            quickRepl5.put("action", "message");
            quickRepl5.put("label", "말");
            quickRepl5.put("messageText", "말 설명");
            quickReplies.add(quickRepl5);

            HashMap<String, Object> quickRepl6 = new HashMap<>();
            quickRepl6.put("action", "message");
            quickRepl6.put("label", "양");
            quickRepl6.put("messageText", "양 설명");
            quickReplies.add(quickRepl6);

            HashMap<String, Object> quickRepl7 = new HashMap<>();
            quickRepl7.put("action", "message");
            quickRepl7.put("label", "개구리");
            quickRepl7.put("messageText", "개구리 설명");
            quickReplies.add(quickRepl7);

            HashMap<String, Object> quickRepl8 = new HashMap<>();
            quickRepl8.put("action", "message");
            quickRepl8.put("label", "수탉");
            quickRepl8.put("messageText", "수탉 설명");
            quickReplies.add(quickRepl8);

            HashMap<String, Object> quickRepl9 = new HashMap<>();
            quickRepl9.put("action", "message");
            quickRepl9.put("label", "병아리");
            quickRepl9.put("messageText", "병아리 설명");
            quickReplies.add(quickRepl9);

            HashMap<String, Object> quickRepl10 = new HashMap<>();
            quickRepl10.put("action", "message");
            quickRepl10.put("label", "오리");
            quickRepl10.put("messageText", "오리 설명");
            quickReplies.add(quickRepl6);

            text.put("text", "동물 설명 리스트 입니다");
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