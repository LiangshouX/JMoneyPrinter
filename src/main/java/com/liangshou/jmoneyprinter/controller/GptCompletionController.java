package com.liangshou.jmoneyprinter.controller;

import com.liangshou.jmoneyprinter.service.llms.openai.ChatOptionsBean;
import com.liangshou.jmoneyprinter.service.llms.openai.GptCompletionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author X-L-S
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class GptCompletionController {
    private final GptCompletionService completionService;

    public GptCompletionController(GptCompletionService completionService) {
        this.completionService = completionService;
    }

    @GetMapping("/gpt/singleCompletion")
    public Map<String, String> singleCompletion (@RequestParam(defaultValue = "你会不会唱跳Rap打篮球？") String message) {
        return completionService.singleCompletion(message);
    }

    @GetMapping("gpt/multiCompletion")
    public Map<String, String> multiCompletion (@RequestParam(defaultValue = "你会不会唱跳Rap打篮球？") String message) {

        return completionService.multiCompletion(message);
    }

    @GetMapping("/gpt/manual")
    public Map<String, String> manualConfigDemo (@RequestParam String api,
                                                 @RequestParam(defaultValue = "gpt-4") String chatModel,
                                                 @RequestParam(defaultValue = "1.0") String temperature,
                                                 @RequestParam(defaultValue = "10") String maxTokens,
                                                 @RequestParam(defaultValue = "你会不会唱跳Rap打篮球？") String message) {
        OpenAiApi openAiApi = new OpenAiApi(api);
        Float temp = Float.parseFloat(temperature);
        Integer maxToken = Integer.parseInt(maxTokens);

        ChatOptionsBean optionsBean = new ChatOptionsBean(chatModel, temp, maxToken);

        OpenAiChatOptions chatOptions = completionService.createChatOptions(optionsBean);

        Prompt prompt = new Prompt(new UserMessage(message), chatOptions);

        return completionService.singleCompletionByPromptWithOption(openAiApi, prompt);

    }
}
