package com.liangshou.jmoneyprinter.service.llms.openai;

import io.swagger.models.auth.In;

/**
 * @author X-L-S
 */
public record ChatOptionsBean (String chatModel,
                               Float temperature,
                               Integer maxTokens) {
}
