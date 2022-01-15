package com.joomak.backend.domain.member;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class SystemInfo {
    private LocalDateTime sysRegAt;

    private LocalDateTime sysUpdAt;

    private LocalDateTime sysRegId;

    private LocalDateTime sysUpdId;
}
