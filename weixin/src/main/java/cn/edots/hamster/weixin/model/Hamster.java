package cn.edots.hamster.weixin.model;

import cn.edots.ormosia.model.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hamster_tbl")
public class Hamster extends Domain {
}
