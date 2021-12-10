package com.cardiff.entity;

import com.cardiff.util.BeanUtil;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Comment extends AuditModel {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String body;

    // Post. Mapping: Many to One. Comments -> Post.
    @ManyToOne
    @NonNull
    private Post post;


    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}
