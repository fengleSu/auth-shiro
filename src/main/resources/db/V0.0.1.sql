-- 用户表
CREATE TABLE `t_user` (
  `n_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `c_username` varchar(20) NOT NULL COMMENT '用户名',
  `c_password` varchar(128) NOT NULL COMMENT '密码',
  `c_salt` char(10) NOT NULL COMMENT '盐值',
  `c_email` varchar(50) NOT NULL COMMENT '邮箱',
  `n_create_user` int(11) NOT NULL COMMENT '更新者',
  `d_create_time` datetime NOT NULL COMMENT '创建时间',
  `n_update_user` int(11) NOT NULL COMMENT '更新者',
  `d_update_time` datetime NOT NULL COMMENT '更新时间',
  `n_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 角色表
CREATE TABLE `t_role` (
  `n_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `c_role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `n_create_user` int(11) NOT NULL COMMENT '创建者',
  `d_create_time` datetime NOT NULL COMMENT '创建时间',
  `n_update_user` int(11) NOT NULL COMMENT '更新者',
  `d_update_time` datetime NOT NULL COMMENT '修改时间',
  `n_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 权限表
CREATE TABLE `t_permission` (
  `n_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `c_permission` varchar(50) NOT NULL COMMENT '权限',
  `c_permission_name` varchar(50) NOT NULL COMMENT '权限名称',
  `url` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `n_parent` int(11) DEFAULT NULL COMMENT '父权限',
  `n_sequence` int(11) DEFAULT NULL COMMENT '排序',
  `n_create_user` int(11) NOT NULL COMMENT '创建者',
  `d_create_time` datetime NOT NULL COMMENT '创建时间',
  `n_update_user` int(11) NOT NULL COMMENT '更新者',
  `d_update_time` datetime NOT NULL COMMENT '修改时间',
  `n_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- 用户-角色关系表
CREATE TABLE `t_user_role` (
  `n_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `n_user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `n_role_id` int(20) DEFAULT NULL COMMENT '角色id',
  `n_create_user` int(11) NOT NULL COMMENT '创建者',
  `d_create_time` datetime NOT NULL COMMENT '创建时间',
  `n_update_user` int(11) NOT NULL COMMENT '更新者',
  `d_update_time` datetime NOT NULL COMMENT '修改时间',
  `n_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`n_id`),
  KEY `uniq_n_user_id` (`n_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色关系表';

-- 角色-权限关系表
CREATE TABLE `t_role_permission` (
  `n_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `n_role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `n_permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `n_create_user` int(11) NOT NULL COMMENT '创建者',
  `d_create_time` datetime NOT NULL COMMENT '创建时间',
  `n_update_user` int(11) NOT NULL COMMENT '更新者',
  `d_update_time` datetime NOT NULL COMMENT '修改时间',
  `n_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`n_id`),
  KEY `uniq_n_role_id` (`n_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-权限关系表';