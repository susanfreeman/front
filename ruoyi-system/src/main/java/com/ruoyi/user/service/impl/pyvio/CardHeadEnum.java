package com.ruoyi.user.service.impl.pyvio;

/**
 * description: CardHeadEnum <br>
 * date: 2024/7/27 10:07 <br>
 *
 *  <br>
 * @version: 1.0 <br>
 */
public enum CardHeadEnum {
    C493193("493193", "100007"),
    C438357("438357", "438357"),
    C540524("540524", "540524");

    private final String cardBin;
    private final String cardHead;

    public static String getCardHeadByCardBin(String cardBin) {
        for (CardHeadEnum value : CardHeadEnum.values()) {
            if (value.cardBin.equals(cardBin)) {
                return value.cardHead;
            }
        }
        return cardBin;
    }

    CardHeadEnum(String cardBin, String cardHead) {
        this.cardHead = cardHead;
        this.cardBin = cardBin;
    }

    public String getCardHead() {
        return cardHead;
    }

    public String getCardBin() {
        return cardBin;
    }
}
