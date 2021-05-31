package net.labymodwrapper.src.utils;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public enum Group {

    ADMINISTRATOR(1),
    DEVELOPER(2),
    SR_MODERATOR(3),
    MODERATOR(4),
    JR_MODERATOR(5),
    CONTENT(6),
    TRANSLATOR(7),
    PARTNER(8),
    VIP(9),
    LABYMOD_PLUS(10),
    COSMETIC_CREATOR(11),
    JR_DEVELOPER(12);

    private final int groupId;

    Group(int groupId) {
        this.groupId = groupId;
    }

    public static Group getGroupById(int groupId) {
        for(Group group : Group.values()) {
            if(group.getGroupId() != groupId) {
                continue;
            }

            return group;
        }

        return null;
    }

    public static Group getGroupByName(String groupName) {
        for(Group group : Group.values()) {
            if(!group.toString().equalsIgnoreCase(groupName)) {
                continue;
            }

            return group;
        }

        return null;
    }

    public int getGroupId() {
        return groupId;
    }
}
