package com.gem.xmgc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TaskCheck implements Serializable {
    private static final long serialVersionUID = 3513283686516070879L;
    private Long id;
    private Long taskid;//作业Id
    private Long sid;//学生Id
    private LocalDateTime chechtime;//
}
