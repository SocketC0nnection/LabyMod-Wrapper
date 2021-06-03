package net.labymodwrapper.src.utils;

import java.util.UUID;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public final class AddonInfo {

    private final String name;
    private final UUID uuid;
    private final double version;
    private final String hash;
    private final int mcVersion;
    private final boolean enabled;
    private final boolean installer;
    private final boolean restart;
    private final boolean includeInJar;
    private final String description;
    private final long fileSize;
    private final Category category;
    private final boolean verified;
    private final boolean performance;
    private final String author;
    private final int[] sorting;

    public AddonInfo(String name, UUID uuid, double version, String hash, int mcVersion, boolean enabled, boolean installer, boolean restart, boolean includeInJar, String description, long fileSize, Category category, boolean verified, boolean performance, String author, int[] sorting) {
        this.name = name;
        this.uuid = uuid;
        this.version = version;
        this.hash = hash;
        this.mcVersion = mcVersion;
        this.enabled = enabled;
        this.installer = installer;
        this.restart = restart;
        this.includeInJar = includeInJar;
        this.description = description;
        this.fileSize = fileSize;
        this.category = category;
        this.verified = verified;
        this.performance = performance;
        this.author = author;
        this.sorting = sorting;
    }

    public int[] getSorting() {
        return sorting;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isPerformance() {
        return performance;
    }

    public boolean isVerified() {
        return verified;
    }

    public Category getCategory() {
        return category;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIncludeInJar() {
        return includeInJar;
    }

    public boolean isRestart() {
        return restart;
    }

    public boolean isInstaller() {
        return installer;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getMcVersion() {
        return mcVersion;
    }

    public String getHash() {
        return hash;
    }

    public double getVersion() {
        return version;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public enum Category {

        GUI(1),
        TOOLS(2),
        SERVER(3),
        GRAPHICS(4);

        private final int categoryId;

        Category(int categoryId) {
            this.categoryId = categoryId;
        }

        public static Category getCategoryById(int categoryId) {
            for(Category category : Category.values()) {
                if(category.getCategoryId() != categoryId) {
                    continue;
                }

                return category;
            }

            return null;
        }

        public static Category getCategoryByName(String categoryName) {
            for(Category category : Category.values()) {
                if(!category.toString().equalsIgnoreCase(categoryName)) {
                    continue;
                }

                return category;
            }

            return null;
        }

        public int getCategoryId() {
            return categoryId;
        }
    }

}
