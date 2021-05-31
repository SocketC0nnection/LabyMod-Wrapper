package net.labymodwrapper.src.utils;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public enum Sticker {

    HALLOWEEN_PACK(1),
    CHRISTMAS_PACK(2),
    REVED_PACK(3),
    VALENTINES_DAY_2020(4),
    STAY_SAFE_PACK(5),
    FIVE_YEARS_LABYMOD(6),
    SPACE_PACK(7),
    SCHMOCKYYY_PACK(8),
    FLEXRACE_PACK(9),
    LUMPI_PACK(10),
    SPIRITENDO_PACK(11),
    DERKEV99_PACK(12),
    FLOEX_PACK(13),
    FLAGS_PACK(14),
    KROONUL_PACK(15),
    DOBERMANNX_PACK(16),
    XPIEPS_PACK(17),
    PLAYFLEX_PACK(18),
    SNOKELP_PACK(19),
    VALENTINES_DAY_2021(20),
    COOODEX_PACK(21),
    ISSEI_KUN_PACK(22),
    SKUNKED_STICKER_PACK(23),
    OMARMU_PACK(24);

    private final int stickerId;

    Sticker(int stickerId) {
        this.stickerId = stickerId;
    }

    public static Sticker getStickerById(int stickerId) {
        for(Sticker sticker : Sticker.values()) {
            if(sticker.getStickerId() != stickerId) {
                continue;
            }

            return sticker;
        }

        return null;
    }

    public static Sticker getStickerByName(String stickerName) {
        for(Sticker sticker : Sticker.values()) {
            if(!sticker.toString().equalsIgnoreCase(stickerName)) {
                continue;
            }

            return sticker;
        }

        return null;
    }

    public int getStickerId() {
        return stickerId;
    }

}
