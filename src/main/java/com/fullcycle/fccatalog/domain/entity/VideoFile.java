package com.fullcycle.fccatalog.domain.entity;

import java.text.DecimalFormat;

public class VideoFile extends BaseEntity {
  private String title;
  private Float duration;
  private String url;
  private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

  public VideoFile(String title, Float duration, String url) {
    this.setTitle(title);
    this.setDuration(duration);
    this.setUrl(url);
  }

  public VideoFile(String title, Float duration) {
    this.setTitle(title);
    this.setDuration(duration);
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  
  public Float getDuration() {
    return Float.valueOf(decimalFormat.format(duration));
  }
  public void setDuration(Float duration) {
    this.duration = Float.valueOf(decimalFormat.format(duration));
  }
  
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
}
