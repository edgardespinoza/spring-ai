package com.eespinor.openai.story;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
class StoryController {

    private final ChatClient chatClient;

    public StoryController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/story")
    Map<String, String> story(){
        var prompt = "Please tell me a story";

        var response = chatClient.prompt().user(prompt).call().content();

        return Map.of("story", response);
    }
}
