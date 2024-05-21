package com.liangshou.jmoneyprinter.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * 路径工具类，提供项目路径获取、目录创建等功能。
 *
 * @author X-L-S
 */
public class PathUtils {

    /**
     * 获取项目的根目录路径。
     *
     * @return 项目的根目录Path对象
     */
    public static Path getRootDir() {
        // 假设项目的根目录是相对于用户目录的特定子目录
        return Paths.get(System.getProperty("user.home"), ".yourProject");
    }

    /**
     * 获取存储目录路径。
     *
     * @param subDir 子目录名称，可以为空
     * @param create 如果子目录不存在，是否创建
     * @return 存储目录的Path对象
     */
    public static Path getStorageDir(String subDir, boolean create) throws IOException {
        Path storagePath = getRootDir().resolve("storage").resolve(subDir);
        if (create && !Files.exists(storagePath)) {
            Files.createDirectories(storagePath);
            // 可以设置权限，例如在Linux环境下
            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
                Files.setPosixFilePermissions(storagePath, perms);
            }
        }
        return storagePath;
    }

    /**
     * 获取资源目录路径。
     *
     * @param subDir 子目录名称，可以为空
     * @return 资源目录的Path对象
     */
    public static Path getResourceDir(String subDir) {
        return getRootDir().resolve("resource").resolve(subDir);
    }

    // TODO: 继续添加如taskDir, fontDir, songDir, publicDir等方法，参照上面的模式实现

    // 示例：获取任务目录路径
    public static Path getTaskDir(String subDir) throws IOException {
        return getStorageDir("tasks", true).resolve(subDir);
    }

    // TODO：在实际应用中，根据操作系统和具体需求调整权限设置和其他逻辑
}
