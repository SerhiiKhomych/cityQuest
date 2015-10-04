package com.rhcloud.quest.brainteaser.dao;

import com.rhcloud.quest.brainteaser.dao.dto.QuestDto;
import com.rhcloud.quest.brainteaser.dao.dto.TooltipDto;
import org.springframework.stereotype.Repository;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

@Repository("questDao")
public class QuestDaoImpl implements QuestDao{

    private final static Map<Integer, QuestDto> questMap;

    public static final int FIVE_MINUTES = 300000;
    public static final int TEN_MINUTES = 600000;
    public static final int FIFTEEN_MINUTES = 900000;

    static {
        questMap = new HashMap<Integer, QuestDto>();

        Queue<TooltipDto> tooltips = new LinkedList<TooltipDto>();

        TooltipDto firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Cтрілка знаходиться на дорожньому знаку");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        TooltipDto secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Знак буде справа. Він до мосту");
        secondTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(secondTooltip);

        TooltipDto thirdTooltip = new TooltipDto();
        thirdTooltip.setMessage("Фото - http://quest-brainteaser.rhcloud.com/resources/images/sign.png");
        thirdTooltip.setMillisecondsToWait(FIFTEEN_MINUTES);
        tooltips.add(thirdTooltip);

        QuestDto questDto = new QuestDto();
        questDto.setName("Cтріла");
        questDto.setMessage("По дорозі з кінця парку Кіото до Чернгівської стрілка вкаже тобі на потрібну штуку) " +
                "Для того отримувати підказки натискай на конпку (через певний час кнопка стане доступною). Оновлюй" +
                " сторінку щоб бачити стільки часу лишилось до підказки");
        questDto.setTooltips(tooltips);

        questMap.put(1, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Грушевський) Це ж так просто");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Оглянь лавочки :)");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Президент");
        questDto.setMessage("Їдь до пам\'ятника \'пpезиденту\'. Він добре знав історію :)");
        questDto.setTooltips(tooltips);

        questMap.put(2, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Його звали Тарас :)");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Оглянь лавочки :)");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("100");
        questDto.setMessage("50 + 50 :)");
        questDto.setTooltips(tooltips);

        questMap.put(3, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("до Володимирського)");
        firstTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Шукай блискавку :)");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Код на електронному щиті :)");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Святиня");
        questDto.setMessage("Йди до найближчого собору і добре оглянь територію :)");
        questDto.setTooltips(tooltips);

        questMap.put(4, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Їдь на Шулявку");
        firstTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Шукай Сільпо");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        thirdTooltip = new TooltipDto();
        thirdTooltip.setMessage("Два числа в назві також мають сенс");
        thirdTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(thirdTooltip);

        TooltipDto fourthTooltip = new TooltipDto();
        fourthTooltip.setMessage("Відкривай 14 скриньку");
        fourthTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(fourthTooltip);

        questDto = new QuestDto();
        questDto.setName("3.14Соль");
        questDto.setMessage("В цьому районі повставали більшовики. Назва завдання має сенс :)");
        questDto.setTooltips(tooltips);

        questMap.put(5, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("14 :)");
        firstTooltip.setMillisecondsToWait(FIFTEEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Лавочки)");
        secondTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Гуртожиток");
        questDto.setMessage("Так, тобі треба знайти гуртожиток в якому я жив, номер сьогодні вже фігурував :)");
        questDto.setTooltips(tooltips);

        questMap.put(6, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Йди на поляну");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Поляна це такий парк на вулиці Польовій :)");
        secondTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Не треба слів. Хай буде тільки діло...");
        questDto.setMessage("Шукай пам\'ятник автору цих слів");
        questDto.setTooltips(tooltips);

        questMap.put(7, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Йди на площу знань");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Вона схожа на око Саурона :)");
        secondTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Wi-fi");
        questDto.setMessage("Якось я казав що в КПІ є штука, яка роздає wi-fi :)");
        questDto.setTooltips(tooltips);

        questMap.put(8, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Шукай вертоліт :)");
        firstTooltip.setMillisecondsToWait(TEN_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Це біля музею КПІ");
        secondTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Вертоліт");
        questDto.setMessage("Він придумав перший вертоліт :)");
        questDto.setTooltips(tooltips);

        questMap.put(9, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Це біля метро КПІ. Номер 35 :)");
        firstTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(firstTooltip);

        secondTooltip = new TooltipDto();
        secondTooltip.setMessage("Оглянь лавочки :)");
        secondTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(secondTooltip);

        questDto = new QuestDto();
        questDto.setName("Формула");
        questDto.setMessage("Знайди корпус де я навчався. Номер 3_ :)");
        questDto.setTooltips(tooltips);

        questMap.put(10, questDto);

        tooltips = new LinkedList<TooltipDto>();

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("АТБ біля метро КПІ (біля поліклініки)");
        firstTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(firstTooltip);

        firstTooltip = new TooltipDto();
        firstTooltip.setMessage("Номер 14");
        firstTooltip.setMillisecondsToWait(FIVE_MINUTES);
        tooltips.add(firstTooltip);

        questDto = new QuestDto();
        questDto.setName("АТБ");
        questDto.setMessage("Роз\'вязок (http://quest-brainteaser.rhcloud.com/resources/images/key.jpg) - номер скриньки :)");
        questDto.setTooltips(tooltips);

        questMap.put(11, questDto);
    }

    public QuestDto getQuest(Integer questNumber) {
        return questMap.get(questNumber);
    }

    public Queue<TooltipDto> getQuestTooltips(Integer questNumber) {
        return  getQuest(questNumber).getTooltips();
    }
}
