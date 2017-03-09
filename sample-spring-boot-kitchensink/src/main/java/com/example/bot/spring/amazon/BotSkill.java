package com.example.bot.spring.amazon;

import com.example.bot.spring.amazon.model.BotSkillRequest;
import com.example.bot.spring.amazon.model.BotSkillResponse;

public interface BotSkill {
    BotSkillResponse execute(BotSkillRequest request);
}
