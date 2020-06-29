package com.andrew.task.tracker.service.impl;

import com.andrew.task.tracker.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.boot.info.InfoProperties;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andre on 27.06.2020.
 */
@Component
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired(required = false)
    private BuildProperties buildProperties;

    @Autowired(required = false)
    private GitProperties gitProperties;

    private String getInfo(InfoProperties infoProperties) {
        if (infoProperties == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        infoProperties
                .iterator()
                .forEachRemaining(entry -> parseEntries(entry, stringBuilder));
        return stringBuilder.toString();
    }

    private void parseEntries(InfoProperties.Entry entry, StringBuilder stringBuilder) {
        SimpleDateFormat format = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        stringBuilder
                .append(entry.getKey())
                .append(": ");
        if (entry.getKey().matches(".*time$")) {
            long timestamp = Long.parseLong(entry.getValue());
            stringBuilder.append(format.format(new Date(timestamp)));
        } else {
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append("\r\n");

    }

    private String getGitInfo() {
        return getInfo(gitProperties);
    }

    private String getBuildInfo() {
        return getInfo(buildProperties);
    }

    @Override
    public String getInfo() {
        return getBuildInfo() + getGitInfo();
    }
}

