package com.rhcloud.quest.brainteaser.dao;

import com.rhcloud.quest.brainteaser.dao.dto.QuestDto;

public interface QuestDao {
    QuestDto getQuest(Integer questNumber);
}
