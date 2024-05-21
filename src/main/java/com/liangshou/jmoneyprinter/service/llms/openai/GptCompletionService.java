package com.liangshou.jmoneyprinter.service.llms.openai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供与 ChatGPT 对话的服务
 * @author X-L-S
 */
@Service
public class GptCompletionService {

    // 这是 Spring AI框架下调用 ChatGPT 对话自带的对话客户端
    private OpenAiChatClient chatClient;

    private final List<Message> messageList = new ArrayList<>();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GptCompletionService(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    /**
     * 单次对话的方法
     * @param message 发送给大模型的消息
     */
    public Map<String, String> singleCompletion (String message) {

        Message messageObj = new UserMessage(message);
        Prompt prompt = new Prompt(messageObj);

        String response = chatClient.call(prompt).getResult().getOutput().getContent();


        return Map.of(
                "AI RESPONSE", response
        );
    }

    /**
     * 多轮对话的方法
     */
    public Map<String, String> multiCompletion (String message) {

        if (messageList.size() >= 10) {
            messageList.remove(0);
        }
        // 为了更直观，在控制台打印
        System.out.println("ME:\t" + message);

        messageList.add(new SystemMessage(message));

        Prompt prompt = new Prompt(messageList);

        String response = chatClient.call(prompt).getResult().getOutput().getContent();

        // 为了更直观，在控制台打印
        System.out.println("AI RESPONSE:\t" + response);

        return Map.of(
                "AI RESPONSE", response
        );
    }

    /**
     * 流式接口调用的方法
     */
    public String streamCompletion (Prompt prompt) {

        StringBuilder outputBuilder = new StringBuilder();

        chatClient.stream(prompt)
                .doOnNext(chatResponse -> {
                    synchronized (outputBuilder) {
                        var result = chatResponse.getResult();
                        // 流式接口调用可能会出现一些 NULL 的情况，要进行判断
                        if (result != null) {
                            var output = result.getOutput();
                            if (output != null) {
                                String content = output.getContent();
                                if (content != null) {
                                    outputBuilder.append(content);
                                }
                                else {
                                    logger.warn("Content is null in ChatOutput.");
                                }
                            }
                            else {
                                logger.warn("Output is null in ChatResult.");
                            }
                        }
                        else {
                            logger.warn("Result is null in ChatResponse.");
                        }
                    }
                })
                .doOnComplete(() -> {
                    // 流完成后的处理逻辑，此时outputBuilder已经包含了所有内容
                    logger.info("All responses processed. OutputBuilder content length: {}", outputBuilder.length());
                })
                .doOnError(error -> {
                    logger.error("An error occurred: {}", error.getMessage());
                })
                // 阻塞，直到最后一个生成完成
                .blockLast();
        logger.info("Stream Completion at {}", Instant.now());
        return outputBuilder.toString();
    }

    public void createChatClient (OpenAiApi api, OpenAiChatOptions chatOptions) {
        try {
            this.chatClient = new OpenAiChatClient(api, chatOptions);
            logger.info("ChatClient已被成功篡改");

        } catch (Exception e) {
            logger.error("构建ChatClient失败", e);
        }
    }

    public OpenAiChatOptions createChatOptions (ChatOptionsBean chatOptionsBean) {
        try {
            return OpenAiChatOptions.builder()
                    .withModel(chatOptionsBean.chatModel())
                    .withTemperature(chatOptionsBean.temperature())
                    .withMaxTokens(chatOptionsBean.maxTokens())
                    .build();
        } catch (Exception e) {
            logger.error("参数配置出错！", e);
            return null;
        }
    }

    /**
     * 构建 Prompt 实例时附带 ChatOption 的调用方法
     *
     * @param api 设置 OpenAI 的 API key 的对象
     * @param prompt 构建了附带 ChatOption 的 Prompt 对象
     */
    public Map<String, String> singleCompletionByPromptWithOption (OpenAiApi api, Prompt prompt) {

        OpenAiChatClient openAiChatClient = new OpenAiChatClient(api);

        String response = openAiChatClient.call(prompt).getResult().getOutput().getContent();

        return Map.of(
                "Response", response
        );
    }
}
