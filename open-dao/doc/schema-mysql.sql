DROP TABLE IF EXISTS sys_global_config;
CREATE TABLE `sys_global_config` (
  `config_code` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置CODE值',
  `group_flag` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分组标识',
  `json_value` JSON NOT NULL COMMENT '配置值',
  `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
  PRIMARY KEY (`config_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统全局配置';

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `code` VARCHAR(32) NOT NULL COMMENT '商品编码',
  `title` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '商品标题',
  `named` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '商品名称',
  `description` VARCHAR(1024) COMMENT '商品描述',
  `status` INT(1) NOT NULL DEFAULT 10 COMMENT '商品状态：10下架 20上架',
  `img_cover_url_list` JSON COMMENT '商品封面图列表',
  `img_details_url_list` JSON COMMENT '商品详情图列表',
  `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品实际价格',
  `price_original` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品原价',
  `price_cost` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品成本价',
  `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_goods_code` (`code`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '规格ID',
  `goods_code` VARCHAR(32) NOT NULL COMMENT '商品编码',
  `code` VARCHAR(32) NOT NULL COMMENT '规格编码',
  `named` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '规格名称',
  `description` VARCHAR(1024) COMMENT '规格描述',
  `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_goods_sku_code` (`code`),
  UNIQUE KEY `uq_goods_sku_named` (`goods_code`, `named`, `is_deleted`),
  KEY `idx_goods_code` (`goods_code`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格信息表';

DROP TABLE IF EXISTS `goods_sku_value`;
CREATE TABLE `goods_sku_value` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '规格ID',
  `goods_code` VARCHAR(32) NOT NULL COMMENT '商品编码',
  `goods_sku_code` VARCHAR(32) NOT NULL COMMENT '规格编码',
  `code` VARCHAR(32) NOT NULL COMMENT '规格值编码',
  `value` VARCHAR(128) NOT NULL COMMENT '规格值',
  `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_goods_sku_value_code` (`code`),
  UNIQUE KEY `uq_goods_sku_value` (`goods_sku_code`, `value`, `is_deleted`),
  KEY `idx_goods_code` (`goods_code`),
  KEY `idx_goods_sku_code` (`goods_sku_code`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格值信息表';

DROP TABLE IF EXISTS `goods_sku_detail`;
CREATE TABLE `goods_sku_detail` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品规格详情ID',
  `goods_code` VARCHAR(32) NOT NULL COMMENT '商品编码',
  `code` VARCHAR(32) NOT NULL COMMENT '商品规格详情编码',
  `sku_make_value_code` VARCHAR(128) NOT NULL COMMENT '规格值编码组合',
  `sku_make_value_list` JSON NOT NULL COMMENT '规格值组合列表',
  `img_url` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '规格图',
  `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '规格实际价格',
  `price_original` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '规格原价',
  `price_cost` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '规格成本价',
  `stock_total` INT(11) NOT NULL COMMENT '总库存（锁定库存+可用库存）',
  `stock_lock` INT(11) NOT NULL COMMENT '锁定库存',
  `stock_surplus` INT(11) COMMENT '可用库存',
  `sort` INT(11) NOT NULL DEFAULT 0 COMMENT '规格详情排序',
  `insert_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` BIGINT(13) NOT NULL DEFAULT '0' COMMENT '已删除：0否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_sku_make_value_code` (`sku_make_value_code`),
  KEY `idx_goods_code` (`goods_code`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格详情表';
