# 用户信息表
DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `login_named` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名称',
    `login_password` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
    `nick_named` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
    `profile_url` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像链接',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`login_named`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

# 用户角色关联表
DROP TABLE IF EXISTS user_roles_relation;
CREATE TABLE `user_roles_relation` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联ID',
    `user_code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编码',
    `roles_code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`user_code`,`roles_code`,`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

# 角色信息表
DROP TABLE IF EXISTS roles;
CREATE TABLE `roles` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
    `named` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
    `description` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`code`),
    UNIQUE KEY (`named`,`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色信息表';

# 菜单信息表
DROP TABLE IF EXISTS menus;
CREATE TABLE `menus` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编码',
    `parent_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '菜单父节点ID',
    `levels` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '菜单层次：0顶级',
    `named` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
    `types` TINYINT(4) NOT NULL COMMENT '节点类型：1页面 2按钮',
    `icon_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标地址',
    `link_url` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '页面地址，非页面可以为空',
    `path` JSON COMMENT '树ID的路径',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单信息';

# 角色菜单关联表
DROP TABLE IF EXISTS roles_menus_relation;
CREATE TABLE `roles_menus_relation` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联ID',
    `roles_code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
    `menus_code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编码',
    `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`roles_code`,`menus_code`,`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单关联表';