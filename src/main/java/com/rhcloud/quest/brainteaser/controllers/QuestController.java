package com.rhcloud.quest.brainteaser.controllers;

import com.rhcloud.quest.brainteaser.dao.dto.TooltipRequestDto;
import com.rhcloud.quest.brainteaser.services.QuestService;
import com.rhcloud.quest.brainteaser.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("quest")
public class QuestController {

    private static final Logger LOG = LoggerFactory.getLogger(QuestController.class);
    public static final String PHONE_NUMBER = "80632288720";

    @Autowired
    QuestService questService;

    @Autowired
    SmsService smsService;

    @RequestMapping("/{questNumber}")
    public String getQuestInfo(@PathVariable("questNumber") int questNumber, ModelMap modelMap) {
        questService.setStartTime(questNumber, false);
        processRequest(questNumber, modelMap, false);
        return "quest";
    }

    @RequestMapping("quest/tooltip/{questNumber}")
    public String getTooltipQuestInfo(@PathVariable("questNumber") int questNumber,ModelMap modelMap) {
        processRequest(questNumber, modelMap, true);
        questService.setStartTime(questNumber, true);
        questService.nextTooltip(questNumber);
        return "redirect:/quest/" + questNumber;
    }

    private void processRequest(int questNumber, ModelMap modelMap, boolean isTooltip) {
        modelMap.put("questNumber", questNumber);

        String questName =  questService.getQuestName(questNumber);
        modelMap.put("name", questName);

        String questMessage = questService.getQuestMessage(questNumber);

        if (!questService.isMessageSent(questNumber)) {
            LOG.info("Quest message:  {} will be sent", questMessage);
            smsService.sendSms(PHONE_NUMBER, questMessage);
            questService.setMessageSent(questNumber);
        }

        TooltipRequestDto tooltipRequestDto = questService.getAvailableTooltipMessage(questNumber);
        boolean tooltipButtonActive = false;
        String tooltipText = tooltipRequestDto.getMessage();
        if (!StringUtils.isEmpty(tooltipText)) {
            tooltipButtonActive = true;
        }

        if (isTooltip) {
            LOG.info("Tooltip text : {} will be sent", tooltipText);
            smsService.sendSms(PHONE_NUMBER, tooltipText);
        }

        String toolTipInfoMessage = tooltipRequestDto.getInfoMessage();
        modelMap.put("tooltipInfo", toolTipInfoMessage);
        modelMap.put("tooltipButtonActive", tooltipButtonActive);
        modelMap.put("tooltipURL", "quest/tooltip/" + questNumber);
    }
}
