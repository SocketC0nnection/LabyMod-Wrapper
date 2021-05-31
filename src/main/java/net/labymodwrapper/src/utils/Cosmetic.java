package net.labymodwrapper.src.utils;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public enum Cosmetic {

    CLOAK(0),
    WOLF_TAIL(1),
    LABY_WINGS(2),
    CAT_TAIL(3),
    MOEHRITZ(4),
    BEARD(5),
    REDNOSE(6),
    HAT(7),
    TOOL(8),
    HALO(9),
    ANTLERS(10),
    RABBIT_EARS(11),
    DEVIL_HORNS(12),
    CRYSTAL_WINGS(13),
    STEAMPUNK_WINGS(14),
    HALLOWEEN(15),
    CHRISTMAS_HAT(16),
    STEGI_HAT(17),
    MERCH_CROWN(18),
    CAP(19),
    BACKPACK(20),
    CAT_EARS(21),
    BANDANA(22),
    HEADSET(23),
    ANGEL_WINGS(24),
    FLOWER(25),
    DOG_EARS(26),
    SHOES(27),
    ROYAL_CROWN(28),
    GRIEFERGAMES_BELT(29),
    REVED_FIRE_HAND(30),
    COVER_MASK(31),
    SNOXH_EYES(32),
    WATCH(33),
    KAWAII_MASK(34),
    BUTTERFLY_WINGS(35),
    EYELIDS(36),
    RABBIT_SHOES(38),
    MUSTACHE(43),
    BABY_DRAGON(44),
    PARROT(45),
    MINIME(46),
    GOGGLES(47),
    POOP(48),
    BEE(49),
    GLASSES(50),
    HEARTGLASSES(51),
    OWL(52),
    BALLOON_TEST(53),
    DEVIL_WINGS(54),
    LABYTEST(55),
    UNICORN(56),
    FLOWERDIADEM(57),
    UNICORNHORN(58),
    FANNY_PACK(59),
    MECHANIC_WINGS(60),
    TOUCAN(61),
    PANDA(62),
    MONKEY(63),
    FISHER_HAT(64),
    PENGUIN(65),
    SUNGLASSES(66),
    CHIWAWA(67),
    RACOON(68),
    KOALA(69),
    RABBIT(70),
    HIPSTERGLASSES(71),
    FLOWER_CROWN_TEST(72),
    TIARA(73),
    TESTCOSMETIC(74),
    PARTYHAT(75),
    FIRE_WINGS(76),
    TEST(77),
    GEM(78),
    SLIME(79),
    GUN(80),
    BLOCKY(81);

    private final int cosmeticId;

    Cosmetic(int cosmeticId) {
        this.cosmeticId = cosmeticId;
    }

    public static Cosmetic getCosmeticById(int cosmeticId) {
        for(Cosmetic cosmetic : Cosmetic.values()) {
            if(cosmetic.getCosmeticId() != cosmeticId) {
                continue;
            }

            return cosmetic;
        }

        return null;
    }

    public static Cosmetic getCosmeticByName(String cosmeticName) {
        for(Cosmetic cosmetic : Cosmetic.values()) {
            if(!cosmetic.toString().equalsIgnoreCase(cosmeticName)) {
                continue;
            }

            return cosmetic;
        }

        return null;
    }

    public int getCosmeticId() {
        return cosmeticId;
    }
}
