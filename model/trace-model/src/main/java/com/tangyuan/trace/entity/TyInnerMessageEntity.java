package com.tangyuan.trace.entity;

import com.tangyuan.base.dal.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;


/**
* Author tangyuan
* Date  2020-11-19
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inner_message")
public class TyInnerMessageEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "open_id")
	private String openId;
	@Column(name = "message_id")
	private int messageId;
	@Column(name = "status")
	private int status;


}