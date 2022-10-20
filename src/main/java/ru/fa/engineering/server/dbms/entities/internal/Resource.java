package ru.fa.engineering.server.dbms.entities.internal;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Where(clause = "deleted_at IS NULL")
@Table(name = "resources")
public class Resource extends InternalEntity<Long> {
}
